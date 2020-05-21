<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="full-background">
	<div class="full-page">
	<div class="inside-container">
	<!--header-->
        <div class="container-fluid w-auto">
            <div class="row h-27">
                <div class="col col-lg-5 col-sm-6 bg-dark">
                    <div class="header-img">
                        <img src="image/body2.gif" class="img-fluid h-100" style="max-width: 100%; height:auto;" alt="responsive image">
                    </div>
                </div>
                <div class="col col-lg-7 col-sm-6 bg-dark">
                    <h2 class="my-header-title text-white">Tribe Online Banking</h2>
                    <p class="blockquote-footer my-para">Your way of banking</p>
                </div>
                
            </div>
        </div>
        <!--naviagtion bar-->
        <div class="row">
            <div class="col-12">
                <nav class="navbar navbar-expand-sm navbar-dark navbar-custom">
                   <a href="#" class="navbar-brand">Tribe Banking</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarMenu">
                        <ul class="navbar-nav mx-right">
                            <li class="nav-item">
                                <a href="#" class="nav-link">Contact IT Department</a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">Send Emails</a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">Services</a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">About</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    <!--end of naviagtion bar-->
	
	<%
		String accNo = request.getParameter("id");
		String nic = request.getParameter("nic");
	%>
	<div class="text-center pt-5">
				<h1>Make Your Payment</h1>
			</div>

	<form action="payment" method="post" class="pt-3">
		<input type="hidden" name="nic" value="<%= nic %>">
		<div class="form-group">
		    <label for="formGroupExampleInput">Account Number</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" name="accNo" value="<%= accNo %>" readonly>
	  	</div>
	  	<div class="row">
		    <div class="col-6">
		      <label for="formGroupExampleInput">First Name</label>
		      <input type="text" class="form-control" placeholder="First name" name="fname" required>
		    </div>
		    <div class="col-6">
		      <label for="formGroupExampleInput">Last Name</label>
		      <input type="text" class="form-control" placeholder="Last name" name="lname" required>
		    </div>
	  	</div>
	  	<br>
	  	<div class="form-group">
		    <label for="formGroupExampleInput">Email</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" name="email" placeholder="Enter your email" required>
	  	</div>
	  	<div class="form-group">
		    <label for="cc-number" class="control-label mb-1">Card number</label>
	        <input id="cc-number" name="cardnumber" type="tel" class="form-control cc-number identified visa" pattern="[0-9]{16}" placeholder="XXXX-XXXX-XXXX-XXXX" required>
	        <span class="invalid-feedback">Enter a valid 16 digit card number</span>
	  	</div>
	  	<div class="row">
		    <div class="col-6">
		      <label for="formGroupExampleInput">Security Code</label>
		      <input type="text" class="form-control" placeholder="CVV" name="scode" required>
		    </div>
		    <div class="col-6">
		      <label for="formGroupExampleInput">Postal Code</label>
		      <input type="text" class="form-control" placeholder="Enter postal code" name="pcode" required>
		      <br>
		    </div>
	  	</div>
	  	<div class="form-group">
		    <label for="formGroupExampleInput">Amount</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" name="amount" placeholder="Enter amount" required>
	  	</div>
	  	<br>		
		<button type="submit" class="btn btn-primary btn-md btn-block btn-primary">Make My Payment</button>
	</form>
	<br>
	<br>

	<!-- footer -->
	<!-- Site footer -->
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>About</h6>
            <p class="text-justify">Tired of misplacing your paperwork? Or are your financial files fit to burst? Switch to online statements and you'll never have to file your bank statements again. 
            Once you opt-in, you can quickly and securely access digital copies of your statements any time. Digital bank statements are in the same format as hardcopies. The only thing that changes is the way you receive them. And if you ever need a 
            paper copy of a statement, you can give us a call or visit us at your local branch to request one.</p>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Categories</h6>
            <ul class="footer-links">
              <li><a href="#">Online Bill Payments</a></li>
              <li><a href="#">Money Transactions</a></li>
              <li><a href="#">Apply for Cards</a></li>
            </ul>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Quick Links</h6>
            <ul class="footer-links">
              <li><a href="#">About Us</a></li>
              <li><a href="#">Contact Us</a></li>
              <li><a href="#">Contribute</a></li>
              <li><a href="#">Privacy Policy</a></li>
              <li><a href="#">Sitemap</a></li>
            </ul>
          </div>
        </div>
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2020 All Rights Reserved by 
         <a href="#">Tribe Online Banking</a>.
            </p>
          </div>

          <div class="col-md-4 col-sm-6 col-xs-12">
            <ul class="social-icons">
              <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
              <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>   
            </ul>
          </div>
        </div>
      </div>
	</footer>
	<!-- end of footer -->

	</div>
	</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>