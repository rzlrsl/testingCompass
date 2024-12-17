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
import java.sql.SQLException;
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
@WebServlet(name = "addwishlist", urlPatterns = {"/addwishlist"})
public class addwishlist extends HttpServlet {

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
             item Item=(item) session.getAttribute("Descip");
              
            String email=(String)session.getAttribute("username");
                  
                   
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addwishlist</title>");            
            out.println("</head>");
            out.println("<body>");
           
                   
         String driverName = "com.mysql.jdbc.Driver";
         String dbName = "myretro";
         String url = "jdbc:mysql://localhost/"+dbName+"?";
         String userName = "root";
         String Password = "";
         
               PreparedStatement ps = null;
try{
    
        Class.forName(driverName);
         Connection con = DriverManager.getConnection(url,userName,Password);
         
         String query ="INSERT INTO wishlist(id,name,userID,price,type,image) VALUES(?,?,?,?,?,?)";
         
         ps = con.prepareStatement(query);
         ps.setString(1,Item.getId());
         ps.setString(2,Item.getName());
         ps.setString(3,email);
         ps.setDouble(4,Item.getPrice());
         ps.setString(5,Item.getType());
         ps.setString(6,Item.getImage());
       
         int i = ps.executeUpdate();
         if(i>0)
             {
                RequestDispatcher rd= request.getRequestDispatcher("./wishlist_servlet");
                rd.forward(request,response);
                out.println("<script>alert(\"WishList added Successfully\")</script>");
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
RequestDispatcher rd= request.getRequestDispatcher("./wishlist_servlet");
                rd.forward(request,response);
                out.println("<script>alert(\"This item have added in wishlist\")</script>");
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
            Logger.getLogger(addwishlist.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addwishlist.class.getName()).log(Level.SEVERE, null, ex);
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
