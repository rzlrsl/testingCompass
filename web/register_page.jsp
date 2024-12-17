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
    
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@1,600&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/a81368914c.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Register Page</title>
  </head>
  <body>
        <script>
            function validateform(){
                var fullname=document.RegisterForm.fullname.value;
                var aemail=document.RegisterForm.email.value;
                var username=document.RegisterForm.username.value;
                var password =document.RegisterForm.password.value;
                var repassword=document.RegisterForm.repassword.value;
                var address=document.RegisterForm.address.value;
                var contact=document.RegisterForm.contact.value;
                
                 
                var atposition=aemail.indexOf("@");  
                var dotposition=aemail.lastIndexOf(".");  
                
                if(fullname===null||fullname==="")
                {
                    alert("Please Fill the Fullname Fill");
                    return false;
                }
                
                else if(aemail===null||aemail==="")
                {
                    alert("Please Enter your email");
                    return false;
                }
                
                 else if(username===null||username==="")
                {
                    alert("Please Enter your username");
                    return false;
                }
                
                else if(password===null||password==="")
                {
                    alert("Please Enter your password");
                    return false;
                }
                
                else if(repassword===null||repassword==="")
                {
                    alert("Please Reenter password ");
                    return false;
                }
                
                else if(address===null||address==="")
                {
                    alert("Please Enter your Address ");
                    return false;
                }
                
                else if(contact===null||contact==="")
                {
                    alert("Please Enter your Contact no");
                    return false;
                }
                
                else if(password!==repassword)
                {
                    alert("Password do not match!Please reenter again");
                    document.RegisterForm.repassword.focus();
                    return false;
                }
               
               if (atposition<1 || dotposition<atposition+2 || dotposition+2>=aemail.length){  
                alert("Please enter a valid e-mail address ");  
                    return false;  
                }  
                
                if (isNaN(contact)){  
                alert("Please only number in contact section"); 
                    return false;  
                }  
                
            }
        </script>

            <header>
                <h1><b><i>MyRetro's</i></b>  Store</h1>
                <div class="header_menu">
                    <a href="login.jsp">Sign-in</a> | 
                    <a href="#">Cart</a> | 
                    <a href="#">My orders</a> 
                    
                </div>
            </header>
        
        
  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/logo2.png');"></div>
    <div class="contents order-1 order-md-2">
         <div class="container">
  <h1>MyRetro Registration Form:</h1>
  <div class="card">
   <div class="card-body">
       
       
    <form action="register_servlet" method="post" name="RegisterForm" onsubmit="return  validateform()">

     <div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">Full
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="fullname"
        placeholder="Enter first name">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="email"
        placeholder="Enter last name">
      </div>
     </div>

     <div class=" form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">User
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="username"
        placeholder="Enter user name">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="password"
        placeholder="Enter Password">
      </div>
     </div>
        
     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">reEnter Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="repassword"
        placeholder="reEnter Password">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Address</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="address"
        placeholder="Enter Address">
      </div>
     </div>

     <div class="form-group row">
      <label for="contact" class="col-sm-2 col-form-label">Contact
       No</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="contact"
        placeholder="Enter Contact Number">
      </div>
     </div>

     <button type="submit" class="btn btn-primary">Submit</button>
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
