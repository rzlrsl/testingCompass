<%-- 
    Document   : try
    Created on : Jan 17, 2021, 6:34:01 PM
    Author     : USER
--%>

<%@page import="bean.AD_Item"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.*"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>PAGE TITLE</title>
     <link href="css/main.css" rel="stylesheet" media="all">
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
                <h1>ADD ITEM</h1>
            </div>
            <!-- #/ container -->
                   
 <div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
        <div class="wrapper wrapper--w780">
            <div class="card card-3">
                <div class="card-heading"></div>
                <div class="card-body">
                    
                  
                    
                    <form method="POST">
                        TYPE :
                        <div class="input-group">
                                <label for="type"></label>
                                <select name="type" id="hospital">
                                <option value="cassete">CASSETTE</option>
                                <option value="comic">COMIC/BOOK</option>
                                <option value="dvd">DVD</option>
                                </select>
                        </div>
                        <br>   
                         ID :<br>
                        <div class="input-group">
                           <INPUT type="text" name="id" placeholder="enter number">
                        </div>
                          <br>   
                          NAME :<br> 
                        <div class="input-group">
                            
                            <textarea name="name" placeholder="enter title" rows="5" cols="100"></textarea>
                        </div>
                           <br>  
                           PRICE :<br> 
                        <div class="input-group">
                            
                            <INPUT type="double" name="price" placeholder="enter rent price">
                            
                        </div>
                        <br> 
                        DESCRIPTION :<br> 
                        <div class="input-group">
                            
                            <textarea name="decrip" placeholder="enter description" rows="5" cols="100"></textarea>
                        </div>
                           <br>  
                           IMAGE :<br> 
                         <div class="input-group">
                             
                            
                            <textarea name="image" placeholder="enter url image" rows="5" cols="100"></textarea>
                        </div>
                           <br> 
                            STATUS : <br> 
                            <div class="input-group">
                                
                                <label for="status"></label>
                                <select name="status" id="hospital">
                                <option value="active">ACTIVE</option>
                                <option value="deactive">DEACTIVE</option>
                                </select>
                        </div>
                           <br>  
                        <div class="p-t-10">
                            <TR><button class="btn btn--pill btn--green" type="submit" formaction="AD_addItem">Submit</button></TR>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

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
    
        <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>


</body>
</html>
