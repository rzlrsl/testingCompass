<%-- 
    Document   : login
    Created on : Jan 16, 2021, 12:23:49 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style/index.css">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Login Page</title>
  </head>
  <body>
         <script>
            function validateform(){
                var username=document.loginForm.username.value;
                var password =document.loginForm.userpass.value;
                 
                if(username===null||username==="")
                {
                    alert("Please Fill the Username Fill");
                    return false;
                }
                
                else if(password===null||password==="")
                {
                    alert("Please Enter your password");
                    return false;
                }
                
            }
        </script>

            <header>
                <h1><b><i>MyRetro's</i></b>  Store</h1>
                <div class="header_menu">
                    <a href="index.jsp">Homepage</a> 
                    
                </div>
            </header>
        
        
  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/retro.png');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Login to <strong>MyRetro</strong></h3>
            <p class="mb-4">We bring you to old lanes memories. Item that make your heart familiar.</p>
            <form action="login_validation" method="post" name="loginForm" id="loginForm" class="loin_form" onsubmit="return  validateform()">
              <div class="form-group first">
                <label for="username">Username</label>
                <input type="text" name="username" class="form-control" placeholder="your-email@gmail.com" id="username">
              </div>
              <div class="form-group last mb-3">
                <label for="password">Password</label>
                <input type="password" name="userpass" class="form-control" placeholder="Your Password" id="password">
              </div>
              
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="register_page.jsp" class="forgot-pass">Register</a></span> 
              </div>

              <input type="submit" value="Log In" class="btn btn-block btn-primary">

            </form>
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <footer>Copyright &copy; <b><i>MyRetro's@UTM</i></b>  Store</footer>
  </body>
</html>
