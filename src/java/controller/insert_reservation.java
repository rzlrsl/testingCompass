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
@WebServlet(name = "insert_reservation", urlPatterns = {"/insert_reservation"})
public class insert_reservation extends HttpServlet {

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
            
            HttpSession session = request.getSession(true);
            String item=request.getParameter("itemName");
            String start_date =request.getParameter("startDate");
            String end_date =request.getParameter("endDate");
            String email=(String)session.getAttribute("username");
            //open session
        item Item=(item) session.getAttribute("Descip");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insert_reservation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addwishlist at " + email+ "</h1>");
             out.println("<table><tr rowspan=\"4\"><td colspan=\"2\"><img  src="+ Item.getImage() +"></td></tr>");
             out.println("<tr rowspan=\"2\"><td><br> Name </td><td>"+Item.getName()+"<br></td></tr>");
             out.println("<tr rowspan=\"2\"><td><br> ID</td><td>"+Item.getId()+"</td></tr><br>");
             out.println("<tr rowspan=\"2\"><td><br> Price </td><td> RM"+Item.getPrice()+"</td></tr>");
             out.println("<tr rowspan=\"2\"><td><br> Price </td><td> RM"+start_date+"</td></tr>");
             out.println("<tr rowspan=\"2\"><td><br> Price </td><td> RM"+end_date+"</td></tr>");
              out.println("<tr rowspan=\"2\"><td><br> Type </td><td> "+Item.getType()+"</td></tr></table>");
            
                              
         String driverName = "com.mysql.jdbc.Driver";
         String dbName = "myretro";
         String url = "jdbc:mysql://localhost/"+dbName+"?";
         String userName = "root";
         String Password = "";
         
               PreparedStatement ps = null;
try{
    
        Class.forName(driverName);
         Connection con = DriverManager.getConnection(url,userName,Password);
         
         String query ="INSERT INTO reservation(ItemID,UserID,Item_name,Item_type,status,start_date,end_date,item_price) VALUES(?,?,?,?,?,?,?,?)";
         
         ps = con.prepareStatement(query);
         ps.setString(1,Item.getId());
         ps.setString(3,Item.getName());
         ps.setString(2,email);
         ps.setString(5,"pending");
         ps.setString(4,Item.getType());
         ps.setString(6,start_date);
         ps.setString(7,end_date);
         ps.setDouble(8,Item.getPrice());
         int i = ps.executeUpdate();
         if(i>0)
             {
                out.println("<script>alert(\"Reserve Successfully\")</script>");
                RequestDispatcher rd= request.getRequestDispatcher("./status_servlet");
                rd.forward(request,response);
                
}
else
{
    RequestDispatcher rd= request.getRequestDispatcher("./status_servlet.jsp");
                rd.forward(request,response);
                out.println("<script>alert(\"There is a problem in updating Record\")</script>");
}
}
catch (SQLException query)
{
    request.setAttribute("error", query);
out.println(query);
//    out.println("<script>alert(\"You have reserve this item 1\")</script>");
//    RequestDispatcher rd= request.getRequestDispatcher("./status_servlet.jsp");
//                rd.forward(request,response);
//    out.println("<script>alert(\"your have reserve this item\")</script>");
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
            Logger.getLogger(insert_reservation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(insert_reservation.class.getName()).log(Level.SEVERE, null, ex);
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
