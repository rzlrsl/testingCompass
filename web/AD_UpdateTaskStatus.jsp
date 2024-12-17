<%-- 
    Document   : AD_UpdateTaskStatus
    Created on : Feb 1, 2021, 9:46:35 AM
    Author     : GoGoBe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
   
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Admin Update Task Status Page</title>
     <link rel="stylesheet" type="text/css" href="style/type.css">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Custom Stylesheet -->
    <link href="css/style_1.css" rel="stylesheet">

</head>

<body>

    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    
    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <div class="brand-logo">
                <a href="index.html">
                    <b class="logo-abbr"><img src="images/logo.png" alt=""> </b>
                    <span class="logo-compact"><img src="./images/logo-compact.png" alt=""></span>
                    <span class="brand-title">
                        <img src="images/logo-text.png" alt="">
                    </span>
                </a>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">    
            <div class="header-content clearfix">
                
                <div class="nav-control">
                    <div class="hamburger">
                        <span class="toggle-icon"><i class="icon-menu"></i></span>
                    </div>
                </div>
                <div class="header-right">
                    <ul class="clearfix">
                        
                        <li class="icons dropdown d-none d-md-flex">
                            <a href="javascript:void(0)" class="log-user"  data-toggle="dropdown">
                                <span><%
                                        String hello=(String) session.getAttribute("hello");
                                        out.println(hello);
                                        %></span>  <i class="fa fa-angle-down f-s-14" aria-hidden="true"></i>
                            </a>
                            <div class="drop-down dropdown-language animated fadeIn  dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        
                                        <li><a href="./login.jsp">Logout</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                      
                    </ul>
                </div>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="nk-sidebar">           
            <div class="nk-nav-scroll">
                <ul class="metismenu" id="menu">
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false"></i><span class="nav-text">DASHBOARD</span>
                        </a>
                         <ul aria-expanded="false">
                           <li><a href="./AD_ItemPage.jsp">ITEM PAGE</a></li>
                            <li><a href="./ADaddItem.jsp">ADD ITEM</a></li>
                            <li><a href="./AD_TaskStatus">TASK STATUS</a></li>
                            <li><a href="./AD_CheckAvailability">CHECK AVAILABILITY</a></li>
                            <li><a href="./AD_ReturnItem">RETURN ITEM</a></li>
                        </ul>
                    </li>
                    
            </div>
        </div>
       <div class="content-body">


            <div class="container-fluid">
                <h1>Update Item Status</h1>
        
            </div>
            <!-- #/ container -->
            
        
        <%
        String UserID= request.getParameter("UserID");
        String ItemName=request.getParameter("Item_name");
        //String UserID="raziela178@gmail.com";
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "myretro";
        String url = "jdbc:mysql://localhost/"+dbName+"?";
        String userName = "root";
        String password = "";
        String query = "SELECT * FROM reservation where UserID='"+UserID+"' and Item_name='"+ItemName+"' and status<>'done'";
        
        Class.forName(driver); //2- load & register driver
        Connection con = DriverManager.getConnection(url,userName,password); //3-establish connection
        Statement st = con.createStatement();//4- create statement
        ResultSet rs = st.executeQuery(query);//5- Execute query
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
            //START TABLE
           out.println("<TABLE >");
           out.println("<tr>");
           out.println("<th align=\"center\"><strong>NAME</strong></th>");
           out.println("<th align=\"center\"><strong>TYPE</strong></th>");
           out.println("<th align=\"center\"><strong>CUSTOMER EMAIL</strong></th>");
           out.println("<th align=\"center\"><strong>STATUS</strong></th>");
           out.println("</tr>");
           
           while(rs.next()){//6- process the result
                 //out.println("<form method='post' >");
           
                 out.println("<tr>");
                 out.println("<td alighn=\"center\">"+rs.getString(3)+"</td>");
                 out.println("<td align=\"center\">" + rs.getString(4) + "</td>");
                 out.println("<td align=\"center\">" + rs.getString(2) + "</td>");
                 
                 out.println("<td align=\"center\"><form method=post>"
                         + "<select id=\"status\" name=\"status\">"
                         + "<option value=\"pending\">Pending</option>"
                         + "<option value=\"approve\">Approve</option>"
                         + "<option value=\"reject\">Reject</option>"
                         + "<option value=\"In delivery\">In delivery</option>"
                         + "</select></td>"
                         +"<td><input type='submit' value='Submit' formaction='AD_UpdateTaskStatus'></td>"
                         + "</form>");
                 
                 session.setAttribute("UserID",rs.getString(2));
                 session.setAttribute("ItemName",rs.getString(3));
                 //out.println("<td><a href='AD_UpdateTaskStatus.jsp?UserID="+rs.getString(2)+"'>update</a></td>");
                 out.println("</tr>");
     
           }
            out.println("</TABLE>"); 
            //END OF THE TABLE
            out.println("</body>");
            out.println("</html>");
          %>
       

        </div>
        
       
        <div class="footer">
            <div class="copyright">
                <footer>Copyright &copy; <b><i>MyRetro's@UTM</i></b>  Store</footer>
            </div>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

</body>
</html>

