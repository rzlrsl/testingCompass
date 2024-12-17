/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import bean.AD_ItemAvailability;

/**
 *
 * @author User
 */
@WebServlet(name = "AD_CheckAvailability", urlPatterns = {"/AD_CheckAvailability"})
public class AD_CheckAvailability extends HttpServlet {

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
            
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "myretro";
        String url = "jdbc:mysql://localhost/"+dbName+"?";
        String userName = "root";
        String password = "";
        String query = "SELECT id,image,name,status FROM cassete";
        
        
        Class.forName(driver); //2- load & register driver
        Connection con = DriverManager.getConnection(url,userName,password); //3-establish connection
        Statement st = con.createStatement();//4- create statement
        ResultSet rs = st.executeQuery(query);//5- Execute query
        
        
        HttpSession session = request.getSession(true);
        Vector itemList=new Vector();
        Vector itemList1=new Vector();
        Vector itemList2=new Vector();
        
           while(rs.next()){//6- process the result
                 
                 AD_ItemAvailability list=new AD_ItemAvailability();
                 list.setId(rs.getString(1));
                 list.setPic(rs.getString(2));
                 list.setName(rs.getString(3));
                 list.setStatus(rs.getString(4));
                 itemList.add(list);
                 
            }

           session.setAttribute("List", itemList);
           
           query= "SELECT id,image,name,status FROM dvd";
           rs = st.executeQuery(query);//5- Execute query
           while(rs.next()){
               
               AD_ItemAvailability list1=new AD_ItemAvailability();
                 list1.setId(rs.getString(1));
                 list1.setPic(rs.getString(2));
                 list1.setName(rs.getString(3));
                 list1.setStatus(rs.getString(4));
                 itemList1.add(list1);
           }
           session.setAttribute("List1", itemList1);
           
              
           query = "SELECT id,image,name,status FROM comic";
           rs = st.executeQuery(query);//5- Execute query
           while(rs.next()){
               
                AD_ItemAvailability list2=new AD_ItemAvailability();
                 list2.setId(rs.getString(1));
                 list2.setPic(rs.getString(2));
                 list2.setName(rs.getString(3));
                 list2.setStatus(rs.getString(4));
                 itemList2.add(list2);
           }
           
           session.setAttribute("List2", itemList2);

            
    RequestDispatcher rd= request.getRequestDispatcher("/AD_CheckAvailability.jsp");
    rd.forward(request,response);
        st.close();
        con.close();
        
        
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
            Logger.getLogger(AD_CheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AD_CheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AD_CheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AD_CheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
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
