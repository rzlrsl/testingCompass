<%-- 
    Document   : AD_CheckAvailability
    Created on : Feb 1, 2021, 5:43:14 PM
    Author     : User
--%>

<%@page import="bean.AD_ItemAvailability"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
   
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Admin Item Availability Page</title>
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
                <h1>Item Availability</h1>
            </div>
            <!-- #/ container -->
            
        <%

            ///table start here	
           out.println("<TABLE border='1'>");
           out.println("<tr>");
           out.println("<th align=\"center\"><strong>ID</strong></th>");
           out.println("<th align=\"center\"><strong>IMAGE</strong></th>");
           out.println("<th align=\"center\"><strong>NAME</strong></th>");
           out.println("<th align=\"center\"><strong>STATUS</strong></th>");
           out.println("</tr>"); 
           
           Vector itemList = (Vector)session.getAttribute("List");
           Vector itemList1 = (Vector)session.getAttribute("List1");
           Vector itemList2 = (Vector)session.getAttribute("List2");
                
               for(int i=0; i<itemList.size(); i++)
               {    
                 AD_ItemAvailability List = (AD_ItemAvailability)itemList.get(i);
                 out.println("<tr>");
                 out.println("<td align=\"center\">" + List.getId() + "</td>");
                 out.println("<td align=\"center\"><img src="+ List.getPic() +"></td>");
                 out.println("<td align=\"center\">" + List.getName() + "</td>");
                 out.println("<td align=\"center\">" + List.getStatus() + "</td>");
                 out.println("<td><a href='AD_UpdateCheckAvailability.jsp?id="+List.getId()+"&type=cassete'>update</a></td>");
                 out.println("</td>");
                 out.println("</tr>");
                 
            }
               for(int i=0; i<itemList1.size(); i++)
               {    
                 AD_ItemAvailability List = (AD_ItemAvailability)itemList1.get(i);
                 out.println("<tr>");
                 out.println("<td align=\"center\">" + List.getId() + "</td>");
                 out.println("<td align=\"center\"><img src="+ List.getPic() +"></td>");
                 out.println("<td align=\"center\">" + List.getName() + "</td>");
                 out.println("<td align=\"center\">" + List.getStatus() + "</td>");
                 out.println("<td><a href='AD_UpdateCheckAvailability.jsp?id="+List.getId()+"&type=dvd'>update</a></td>");
                 out.println("</td>");
                 out.println("</tr>");
                 
            }
               for(int i=0; i<itemList2.size(); i++)
               {    
                 AD_ItemAvailability List = (AD_ItemAvailability)itemList2.get(i);
                 out.println("<tr>");
                 out.println("<td align=\"center\">" + List.getId() + "</td>");
                 out.println("<td align=\"center\"><img src="+ List.getPic() +"></td>");
                 out.println("<td align=\"center\">" + List.getName() + "</td>");
                 out.println("<td align=\"center\">" + List.getStatus() + "</td>");
                 out.println("<td><a href='AD_UpdateCheckAvailability.jsp?id="+List.getId()+"&type=comic'>update</a></td>");
                 out.println("</td>");
                 out.println("</tr>");
                 
            }

            out.println("</TABLE>"); 
            //END OF THE TABLE
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

