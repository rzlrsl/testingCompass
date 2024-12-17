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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class register_servlet extends HttpServlet {

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
        String fullname=request.getParameter("fullname");
        String email=request.getParameter("email");
        String username=request.getParameter("username");
        String userpass=request.getParameter("password");
        String address=request.getParameter("address");
        String number=request.getParameter("contact");
        
        //open connection
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "myretro";
        String url = "jdbc:mysql://localhost/"+dbName+"?";
        String userName = "root";
        String password = "";
        String query = "SELECT * FROM user_profile WHERE email='"+email+"'";
        
        Class.forName(driver); //2- load & register driver
        Connection con = DriverManager.getConnection(url,userName,password); //3-establish connection
        Statement st = con.createStatement();//4- create statement
        
        //query="INSERT INTO user_profile(fullname,address,phone_num,email,username) VALUES (?,?,?,?,?)";
        
        ResultSet rs = st.executeQuery(query);//5- Execute query
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>register validation</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            while(rs.next()){//6- process the result
                
               RequestDispatcher rd=request.getRequestDispatcher("./register_page.jsp");
               rd.include(request,response);
               out.println("<script>alert(\"Email have been Register.Please use other email address to Register\")</script>");
                
                
            }//end of if
            //
            //insert register
                //query = "INSERT INTO user_profile(password,fullname,address,email,phone_num,email,username) VALUES ('"+userpass+"','"+fullname+"','"+address+"','"+email+"','"+number+"','"+email+"','"+username+"')";
                query="INSERT INTO user_profile(password,fullname,address,phone_num,email,username) VALUES (?,?,?,?,?,?)";
                PreparedStatement st1=con.prepareStatement(query);
                
                st1.setString(1,userpass);
                st1.setString(2,fullname);
                st1.setString(3,address);
                st1.setString(4,number);
                st1.setString(5,email);
                st1.setString(6,username);
                
                st1.executeUpdate();
                
                //System.out.println(insertStatus + "row affected");//6-process result
                
            st.close();//7. close connection
            con.close();
              
            out.println("<script>alert(\"Account Successfully Registered!\")</script>");
            RequestDispatcher rd=request.getRequestDispatcher("./login.jsp");
               rd.include(request,response);
            //out.println("<jsp:forward page=\"./login.jsp\" />");
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
            Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void header(String location_httpwwwredirecttourlcom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
