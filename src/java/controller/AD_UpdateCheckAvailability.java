/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.AD_ItemAvailability;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
@WebServlet(name = "AD_UpdateCheckAvailability", urlPatterns = {"/AD_UpdateCheckAvailability"})
public class AD_UpdateCheckAvailability extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

             /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AD_UpdateReturnItem</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
        HttpSession session=request.getSession(true);
        //String UserID=(String)session.getAttribute("UserID");
        String type=request.getParameter("type");
        String id=(String)session.getAttribute("id");
        String status=request.getParameter("status");
        
        
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "myretro";
        String url = "jdbc:mysql://localhost/"+dbName+"?";
        String userName = "root";
        String password = "";
        
        try{
        String query = "Update "+type+" set status=? where id='"+id+"'";
        //String query = "Update reservation set status=? where UserID='"+UserID+"'";
        //INSERT INTO pickup(date_time,phone_number,Address,CustomerName) VALUES (?,?,?,?)
        
        
        Class.forName(driver); //2- load & register driver
        Connection con = DriverManager.getConnection(url,userName,password); //3-establish connection
        //Statement st = con.createStatement();//4- create statement
        PreparedStatement st=con.prepareStatement(query); //diff with normal is need to include parameter query
       
       st.setString(1,status);
       
       int insertStatus=0;// to loop at status of row
       
       insertStatus=st.executeUpdate();
       System.out.println(insertStatus+"row affected");//want to see affected row 6.Process result
       //ResultSet rs = st.executeQuery(query);//5- Execute query
       
       if(insertStatus>0){
           RequestDispatcher rd= request.getRequestDispatcher("./AD_CheckAvailability");
            rd.include(request,response);
            out.println("<script>alert('your reservation have been successfully added')</script>");
            
       }
       else{
           out.println("<script>alert('There is a problem in updating Record')</script>");
//            RequestDispatcher rd= request.getRequestDispatcher("./AD_CheckAvailability");
//            rd.forward(request,response);
       }
       
        st.close();//7. close connection
        con.close();
        }catch(SQLException query){
            request.setAttribute("error", query);
            out.println(query);
        }
        
        
        out.println("</body>");
        out.println("</html>");

        
       }
        RequestDispatcher rd= request.getRequestDispatcher("./AD_CheckAvailability");
        rd.include(request,response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AD_UpdateCheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AD_UpdateCheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AD_UpdateCheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AD_UpdateCheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
