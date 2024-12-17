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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "AD_addItem", urlPatterns = {"/AD_addItem"})
public class AD_addItem extends HttpServlet {

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
            String type=request.getParameter("type");
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String price=request.getParameter("price");
            String descrip=request.getParameter("decrip");
            String image=request.getParameter("image");
            String status=request.getParameter("status");
            String rid="";
            if("cassete".equals(type))
            {
                rid="CA"+id;
            }
            if("comic".equals(type))
            {
                rid="CO"+id;
            }
            if("dvd".equals(type))
            {
                rid="DVD"+id;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AD_addItem</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AD_addItem at " + type + "</h1>");
            out.println("<h1>Servlet AD_addItem at " + rid + "</h1>");
            out.println("<h1>Servlet AD_addItem at " + name + "</h1>");
            out.println("<h1>Servlet AD_addItem at " + price + "</h1>");
            out.println("<h1>Servlet AD_addItem at " + descrip + "</h1>");
            out.println("<h1>Servlet AD_addItem at " + image + "</h1>");
            out.println("<h1>Servlet AD_addItem at " + status + "</h1>");
            
         String driverName = "com.mysql.jdbc.Driver";
         String dbName = "myretro";
         String url = "jdbc:mysql://localhost/"+dbName+"?";
         String userName = "root";
         String Password = "";
         
          PreparedStatement ps = null;
try{
    
        Class.forName(driverName);
         Connection con = DriverManager.getConnection(url,userName,Password);
         
         String query ="INSERT INTO "+type+"(id,image,name,price,description,status) VALUES(?,?,?,?,?,?)";
         ps = con.prepareStatement(query);
         ps.setString(1,rid);
         ps.setString(2,image);
         ps.setString(3,name);
         ps.setDouble(4,Double.parseDouble(price));
         ps.setString(5,descrip);
         ps.setString(6,status);
         
       
         int i = ps.executeUpdate();
         if(i>0)
             {
                RequestDispatcher rd= request.getRequestDispatcher("./AD_ItemPage.jsp");
                rd.forward(request,response);
                out.println("<script>alert(\"Update Successfully\")</script>");
}
else
{
RequestDispatcher rd= request.getRequestDispatcher("./updateProfile.jsp");
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
            Logger.getLogger(AD_addItem.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AD_addItem.class.getName()).log(Level.SEVERE, null, ex);
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
