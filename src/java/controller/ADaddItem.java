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
@WebServlet(name = "ADaddItem", urlPatterns = {"/ADaddItem"})
public class ADaddItem extends HttpServlet {

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
        
        String type=request.getParameter("type");
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        double price=Double.parseDouble(request.getParameter("price"));
        int stock=Integer.parseInt(request.getParameter("stock"));
        String description=request.getParameter("decrip");
        String image=request.getParameter("image");
        
       String driver="com.mysql.jdbc.Driver";
       String dbName="myretro";
       String url="jdbc:mysql://localhost/"+dbName+"?";
       String userName="root";
       String password="";
       
       String query="INSERT INTO "+type+"(image,name,price,stock,description.id) VALUES (?,?,?,?,?)";//preparedstatement
      
       
        Class.forName(driver); // 2. load and register driver 
             
       
       Connection con=DriverManager.getConnection(url,userName,password);//3.establish the connection
       //Statement st=con.createStatement();//4.create statement//normal statement
       PreparedStatement st=con.prepareStatement(query); //diff with normal is need to include parameter query
       
       st.setString(1,image);
       st.setString(2,name);
       st.setDouble(3,price);
       st.setInt(4,stock);
       st.setString(5,description);
       st.setString(6,id);
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
            out.println("<title>Servlet ADaddItem</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ADaddItem at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ADaddItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADaddItem.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ADaddItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADaddItem.class.getName()).log(Level.SEVERE, null, ex);
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
