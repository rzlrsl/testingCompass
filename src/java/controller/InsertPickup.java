/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import bean.Rental;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author User
 */
@WebServlet(name = "InsertPickup", urlPatterns = {"/InsertPickup"})
public class InsertPickup extends HttpServlet {

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
        
        HttpSession session = request.getSession(true);
         String nameemail=(String) session.getAttribute("username");
        
        
        String pickupDate=request.getParameter("pickupDate");
        String phoneNumber=request.getParameter("phoneNumber");
        String Address=request.getParameter("Address");
        
        String driver="com.mysql.jdbc.Driver";
       String dbName="myretro";
       String url="jdbc:mysql://localhost/"+dbName+"?";
       String userName="root";
       String password="";
       
       String query="INSERT INTO pickup(date_time,phone_number,Address,CustomerName) VALUES (?,?,?,?)";//preparedstatement
      
       
        Class.forName(driver); // 2. load and register driver 
             
       
       Connection con=DriverManager.getConnection(url,userName,password);//3.establish the connection
       //Statement st=con.createStatement();//4.create statement//normal statement
       PreparedStatement st=con.prepareStatement(query); //diff with normal is need to include parameter query
       
       st.setString(1,pickupDate);
       st.setString(2,phoneNumber);
       st.setString(3,Address);
       st.setString(4,nameemail);
       
//       Rental rental=new Rental();
//       rental.setPickupDate(pickupDate);
//       rental.setAddress(Address);
//       rental.setPhoneNumber(phoneNumber);
//       
//       session.setAttribute("rental",rental);

//         st.setString(1,"31/01/2021");
//         st.setString(2,"0182644041");
//         st.setString(3,"Vista bla bla");
       
        int insertStatus=0;// to loop at status of row
       
       //st.executeUpdate(query);//5. Execute query
       st.executeUpdate();
       System.out.println(insertStatus+"row affected");//want to see affected row 6.Process result
       
        st.close();//7. close connection
        con.close();
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JdbcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            RequestDispatcher rd=request.getRequestDispatcher("/PickupDetail.jsp");
            rd.include(request,response);
            out.println("<script>alert(\"Pickup have been successfully added\")</script>");
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
            Logger.getLogger(InsertPickup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertPickup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertPickup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertPickup.class.getName()).log(Level.SEVERE, null, ex);
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
