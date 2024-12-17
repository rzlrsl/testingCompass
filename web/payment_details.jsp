<%-- 
    Document   : try
    Created on : Jan 17, 2021, 6:34:01 PM
    Author     : USER
--%>

<%@page import="bean.item"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>PAGE TITLE</title>
     <link rel="stylesheet" type="text/css" href="style/try.css">
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
                                        <li><a href="./profile">Profile</a></li>
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
                    <li class="nav-label">Dashboard</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false"></i><span class="nav-text">Dashboard</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./dashboard.jsp">HOME</a></li>
                        </ul>
                    </li>
                    <li class="nav-label"><a href="./wishlist_servlet">WISHLIST</a></li>
                  
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                        <span class="nav-text">PICK UP</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./PickUpForm.jsp">PICKUP FORM</a></li>
                            <li><a href="./PickupDetail.jsp">PICKUP DETAILS</a></li>
                        </ul>
                    </li>
              
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                         <span class="nav-text">RENTAL ITEM</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./dvd_servlet">DVD</a></li>
                            <li><a href="./cassete_servlet">CASSETTE</a></li>
                            <li><a href="./comic_servlet">COMIC/BOOK</a></li>
                        </ul>
                    </li>
                    <li class="nav-label"><a href="./status_servlet">RENTAS STATUS</a></li>
                    <li class="nav-label"><a href="./listApproved">PAYMENT</a></li>
                </ul>
            </div>
        </div>
       <div class="content-body">


            <div class="container-fluid">
                <h1>PayMent Details</h1>
            </div>
                       <%        
           
            
            String method=(String) session.getAttribute("method");
            String address=(String) session.getAttribute("address");
            Double Total=(Double) session.getAttribute("total");
               
           out.println("<TABLE>");
           out.println("<tr>");
           out.println("<th align=\"center\"><strong>ID</strong></th>");
           out.println("<th align=\"center\"><strong>NAME</strong></th>");
           out.println("<th align=\"center\"><strong>PRICE/WEEK</strong></th>");
           out.println("</tr>"); 
           
           Vector itemList = (Vector)session.getAttribute("listpay");
                
               for(int i=0; i<itemList.size(); i++)
               {    
                   item List = (item)itemList.get(i);
                 out.println("<tr>");
                 out.println("<td align=\"center\">" + List.getId() + "</td>");
                 out.println("<td align=\"center\">" + List.getName() + "</td>");
                 out.println("<td align=\"center\"> RM" + List.getPrice() + "</td>");
                 out.println("</tr>");
                 
            }
            out.println("<tr>");
            out.println("<td align=\"center\">method : "+method+"</td>");
            out.println("<td colspan=\"2\">");
            out.println("total price : "+Total+"</td>");
            out.println("</tr>");
       
            
            out.println("<tr>");
            out.println("<td align=\"center\">ADDRESS</td>");
            out.println("<td colspan=\"2\">");
            out.println("<label for=\"address\" color=\"black\" ></label><br><textarea  name=\"address\" placeholder=\""+address+"\" rows=\"5\" cols=\"30\"></textarea></td>");
            out.println("</tr>");
            
            out.println("</tr>");
           out.println("<br><td colspan=\"2\">");
           out.println("<form method=\"POST\" action=\"paidv2?total="+Total+"\">");
           %>
           <label for="status"></label>
                                <select name="pay" id="hospital">
                                <option value="master">MASTERCARD</option>
                                <option value="visa">VISA</option>
                                </select>
           <%
           out.println("<input type=\"submit\" value=\"PAY\">");
           out.println("</form>");
           out.println("</td>");
           out.println("</tr>"); 
            out.println("</TABLE>");
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
