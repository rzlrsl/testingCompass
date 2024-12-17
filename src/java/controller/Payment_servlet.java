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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
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
@WebServlet(name = "Payment_servlet", urlPatterns = {"/Payment_servlet"})
public class Payment_servlet extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            String price[]= request.getParameterValues("price");
            Double totalPrice=0.0;
            String method=request.getParameter("method");
            session.setAttribute("method",method);
            if("delivery".equals(method))
            {
                totalPrice=8.00;
            }
            
            String email=(String)session.getAttribute("username");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Payment_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Payment_servlet at " + request.getContextPath() + "</h1>");
            out.println("<table width=\"600\" style=\"border:1px solid hotpink;margin-left:auto;margin-right:auto;\">");
            out.println("<tr>");
           out.println("<th align=\"center\"><strong>ID</strong></th>");
           out.println("<th align=\"center\"><strong>PRICE</strong></th>");
           out.println("<th align=\"center\"><strong>NAME</strong></th>");
           out.println("</tr>"); 
           
           Vector itemList=new Vector();
            if(price !=null){
                
                out.println("Languages are: ");
                for(String lang: price){
                    out.println("<tr>");
                    out.println("<td>" + lang+"</td>");
                    item list=new item();
                    list.setId(lang);
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "myretro";
        String url = "jdbc:mysql://localhost/"+dbName+"?";
        String userName = "root";
        String password = "";
        String query = "SELECT item_price,Item_name FROM reservation WHERE ItemID='"+lang+"' and UserID='"+email+"'";
        
        Class.forName(driver); //2- load & register driver
        Connection con = DriverManager.getConnection(url,userName,password); //3-establish connection
        Statement st = con.createStatement();//4- create statement
        ResultSet rs = st.executeQuery(query);//5- Execute query
                    
        while(rs.next()){//6- process the result
              
             out.println("<td>"+rs.getDouble(1)+"</td>");
             list.setPrice(rs.getDouble(1));
             out.println("<td>"+rs.getString(2)+"</td>");
             list.setName(rs.getString(2));
             out.println("<tr>");
             totalPrice+=rs.getDouble(1);
             itemList.add(list);   
            }
            
                }
                
            }
            session.setAttribute("listpay",itemList);
            
             out.println("<tr>");
             out.println("<td>TotalPrice</td>");
             out.println("<td>"+totalPrice+"</td>");
             session.setAttribute("total",totalPrice);
             out.println("<tr>");
             out.println("</table>");
            out.println("</body>");
            out.println("</html>");
         RequestDispatcher rd= request.getRequestDispatcher("/payment_details.jsp");
         rd.forward(request,response);   
            
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
            Logger.getLogger(Payment_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Payment_servlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Payment_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Payment_servlet.class.getName()).log(Level.SEVERE, null, ex);
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
