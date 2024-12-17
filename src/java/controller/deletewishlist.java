/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.item;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
@WebServlet(name = "deletewishlist", urlPatterns = {"/deletewishlist"})
public class deletewishlist extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            String id=request.getParameter("id");
            String email=(String)session.getAttribute("username");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet deletewishlist</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deletewishlist at " + email + id+ "</h1>");
            
                               
         String driverName = "com.mysql.jdbc.Driver";
         String dbName = "myretro";
         String url = "jdbc:mysql://localhost/"+dbName+"?";
         String userName = "root";
         String Password = "";
         
               PreparedStatement ps = null;
try{
    
        Class.forName(driverName);
         Connection con = DriverManager.getConnection(url,userName,Password);
         
         String query ="DELETE FROM wishlist WHERE id=? and userID=?";
         
         ps = con.prepareStatement(query);
         ps.setString(1,id);
         ps.setString(2,email);
 
       
         int i = ps.executeUpdate();
         String action=request.getParameter("action");
         String type=request.getParameter("type");
         if("reserve".equals(action))
         {
         String driver = "com.mysql.jdbc.Driver";
        String password = "";
         query = "SELECT id,image,name,stock,price,description FROM "+type+" WHERE id='"+id+"'";
        
        Class.forName(driver); //2- load & register driver
        Connection con1 = DriverManager.getConnection(url,userName,password); //3-establish connection
        Statement st = con1.createStatement();//4- create statement
        ResultSet rs = st.executeQuery(query);//5- Execute query
        
            item list=new item();
            list.setType(type);
           while(rs.next()){//6- process the result
                 
                 
                 list.setImage(rs.getString(2));
                 list.setName(rs.getString(3));
                 list.setPrice(rs.getDouble(5));
                 list.setId(rs.getString(1));
                 list.setStock(rs.getInt(4));
                 list.setDescription(rs.getString(6));
                 
            }

           session.setAttribute("Descip",list);

             
             
             
                 RequestDispatcher rd= request.getRequestDispatcher("./reservation.jsp");
                rd.forward(request,response);
         }
         if(i>0)
             {
                RequestDispatcher rd= request.getRequestDispatcher("./wishlist_servlet");
                rd.forward(request,response);
                out.println("<script>alert(\"Remove Successfully\")</script>");
}
else
{
            RequestDispatcher rd= request.getRequestDispatcher("./description_page");
                rd.forward(request,response);
                out.println("<script>alert(\"There is a problem in updating Record\")</script>");
               
}
}
catch (SQLException query)
{
request.setAttribute("error", query);
out.println(query);
}
            
            out.println("</body>");
            out.println("</html>");
        }
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
            Logger.getLogger(deletewishlist.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(deletewishlist.class.getName()).log(Level.SEVERE, null, ex);
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
