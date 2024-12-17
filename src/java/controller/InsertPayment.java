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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EndUser
 */
public class InsertPayment extends HttpServlet {

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
            out.println("<title>Servlet InsertPayment</title>");            
            out.println("</head>");
            out.println("<body>");
          
            
                
         HttpSession session = request.getSession(true);
        String nameemail=(String) session.getAttribute("username");
        
        String Address=request.getParameter("Address");
        String Method=request.getParameter("method");
        Double total_price=Double.parseDouble(request.getParameter("total_price"));
          String payment_option=request.getParameter("payment_option");
          Double total_payment=Double.parseDouble(request.getParameter("total_Payment")); 
          
          out.println("<h1>"+nameemail+"</h1>");
          out.println(Address);
          out.println(Method);
          out.println(total_price);
          out.println(payment_option);
          out.println(total_payment);
          
            String driver="com.mysql.jdbc.Driver";
       String dbName="myretro";
       String url="jdbc:mysql://localhost/"+dbName+"?";
      String userName="root";
       String password="";
       
       String query="INSERT INTO payment(userID,address,method,price,payment_option,total_payment) VALUES (?,?,?,?,?,?)";//preparedstatement
      
       
        Class.forName(driver); // 2. load and register driver 
             
       
       Connection con=DriverManager.getConnection(url,userName,password);//3.establish the connection
       //Statement st=con.createStatement();//4.create statement//normal statement
       PreparedStatement st=con.prepareStatement(query); //diff with normal is need to include parameter query
        
       if("delivery".equals(Method))
       {
       total_payment=total_price+8;
       }
       
       
        st.setString(1,nameemail);
       st.setString(2,Address);
       st.setString(3,Method);
       st.setDouble(4,total_price);
       st.setString(5,payment_option);
       st.setDouble(6, total_payment);
       
       session.setAttribute("total_payment", total_payment);
       
       st.executeUpdate();
       st.close();//7. close connection
        con.close(); 
       
       
            
           
            if("visa".equals(payment_option))
            {  RequestDispatcher rd=request.getRequestDispatcher("/visa.jsp");
                rd.forward(request,response);
            
            }
            
            else
            {
                  RequestDispatcher rd=request.getRequestDispatcher("/mastercard.jsp");
                rd.forward(request,response);
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
            Logger.getLogger(InsertPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertPayment.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertPayment.class.getName()).log(Level.SEVERE, null, ex);
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
