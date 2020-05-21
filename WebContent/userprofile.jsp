<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>My Profile</title>
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
                	<c:forEach var="cus" items="${cusDetails}">
                    	<a href="#" class="navbar-brand" >Welcome, ${cus.name}</a>
                    </c:forEach>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarMenu">
                        <ul class="navbar-nav mx-right">
                            <li class="nav-item">
                                <a href="insertcustomer.jsp" class="nav-link">Create new account</a>
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
	
	<div class="row">
		<div class="col-12 col-lg-9 col-sm-12 col-xs-12">
		<div class="pl-5 pt-5">
			<h1>My Information</h1>
			<br>
			<h3>My Account Balance  &nbsp;  &nbsp; <b>Rs. <c:out value="${accountBalance}" /></b></h3>
			<div class="table-responsive">
				<table class="table my-table">
				<tbody>
				<c:forEach var="cus" items="${cusDetails}">
					<tr>
						<th scope="row">Account Number</th>
						<td>${cus.accNumber}</td>
					</tr>
					<tr>
						<th scope="row">Customer ID</th>
						<td>${cus.nic}</td>
					</tr>
					<tr>
						<th scope="row">Name</th>
						<td>${cus.name}</td>
					</tr>
					<tr>
						<th scope="row">Email</th>
						<td>${cus.email}</td>
					</tr>
					<tr>
						<th scope="row">Customer Address</th>
						<td>${cus.address}</td>
					</tr>
					<tr>
						<th scope="row">Phone Number</th>
						<td>${cus.phone}</td>
					</tr>
					<tr>
						<th scope="row">Date of birth</th>
						<td>${cus.dob}</td>
					</tr>
					<tr>
						<th scope="row">Your Gender</th>
						<td>${cus.gender}</td>
					</tr>
					
					<c:set var="id" value="${cus.accNumber}" />
					<c:set var="nic" value="${cus.nic}" />
					<c:set var="name" value="${cus.name}" />
					<c:set var="email" value="${cus.email}" />
					<c:set var="address" value="${cus.address}" />
					<c:set var="phone" value="${cus.phone}" />
					<c:set var="dob" value="${cus.dob}" />
					<c:set var="gender" value="${cus.gender}" />
					<c:set var="password" value="${cus.password}" />
				</c:forEach>
				</tbody>
				</table>
			</div>
			
			<!-- this is for testing if statement -->
			<!-- this table is for displaying card details of customer and it will display
			only if condition is true -->
			
			<c:set var="number" value="${sendNumber}" />
			<c:if test="${number == true}">
			<h1>Card Details</h1>
			<div class="table-responsive">
				<table class="table my-table">
				<tbody>
				<c:forEach var="card" items="${cardDetails}">
					<tr>
						<th scope="row">Account Number</th>
						<td>${card.accountNumber}</td>
					</tr>
					<tr>
						<th scope="row">Customer NIC</th>
						<td>${card.nic}</td>
					</tr>
					<tr>
						<th scope="row">Name</th>
						<td>${card.name}</td>
					</tr>
					<tr>
						<th scope="row">Email</th>
						<td>${card.email}</td>
					</tr>
					<tr>
						<th scope="row">Customer Address</th>
						<td>${card.address}</td>
					</tr>
					<tr>
						<th scope="row">Phone Number</th>
						<td>${card.phone}</td>
					</tr>
					<tr>
						<th scope="row">Your Monthly Salary</th>
						<td>${card.salary}</td>
					</tr>
					<tr>
						<th scope="row">Your Occupation</th>
						<td>${card.occupation}</td>
					</tr>
					<tr>
						<th scope="row">Card  Type</th>
						<td>${card.cardType}</td>
					</tr>
					
					<c:set var="cardid" value="${card.accountNumber}" />
					<c:set var="cardnic" value="${card.nic}" />
					<c:set var="cardname" value="${card.name}" />
					<c:set var="cardemail" value="${card.email}" />
					<c:set var="cardaddress" value="${card.address}" />
					<c:set var="cardphone" value="${card.phone}" />
					<c:set var="cardsalary" value="${card.salary}" />
					<c:set var="cardoccupation" value="${card.occupation}" />
					<c:set var="cardtype" value="${card.cardType}" />
					
				</c:forEach>
				</tbody>
				</table>
			</div>
			</c:if>
			
			<c:set var="loandata" value="${loanTrue}" />
			<c:if test="${loandata == true}">
				<h1>Loan Details</h1>
				<div class="table-responsive">
					<table class="table my-table table-bordered">
						<thead>
						<tr>
							<th scope="col">Loan ID</th>
							<th scope="col">Loan Amount</th>
							<th scope="col">Approval</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="loan" items="${loanDetails}">
						<tr>
							<td>${loan.loanId}</td>
							<td>${loan.loanamount}</td>
							<td>
								<c:if test="${loan.approve < 1}">
									<i>Your Loan is Processing</i>
								</c:if>
								<c:if test="${loan.approve >= 1}">
									<i>Loan Approved</i>
								</c:if>
							</td>
						</tr>				
						</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
			
		</div>
		</div>
		<div class="col-12 col-lg-3 col-sm-12 col-xs-12">
		<div class="pt-5 pr-0 pr-sm-0 pr-lg-5 pr-xs-0 pr-md-5 pl-md-5">
			<c:url value="transfermoney.jsp" var="transfer">
				<c:param name="id" value="${id}" />
				<c:param name="nic" value="${nic}" />
			</c:url>
			<a href="${transfer}" style="text-decoration: none">
				<input type="button" class="btn btn-success btn-block" name="transfer" value="Transfer Money" style="text-decoration: none">
			</a>
			<br>
			<c:url value="payment.jsp" var="payment">
				<c:param name="id" value="${id}" />
				<c:param name="nic" value="${nic}" />
			</c:url>
			<a href="${payment}" style="text-decoration: none">
				<input type="button" class="btn btn-success btn-block" name="bill" value="Online Bill Payment">
			</a>
			<br>
			<c:set var="number" value="${sendNumber}" />
			<c:if test="${number == false}">
			<c:url value="requestcard.jsp" var="newcard">
				<c:param name="id" value="${id}" />
			    <c:param name="name" value="${name}" />
			    <c:param name="email" value="${email}" />
			    <c:param name="address" value="${address}" />
			    <c:param name="phone" value="${phone}" />
			    <c:param name="nic" value="${nic}" />
			</c:url>	
			<a href="${newcard}" style="text-decoration: none">
				<input type="button" class="btn btn-primary btn-block" name="credit" value="Apply for Credit Card">
			</a>
			<br>
			</c:if>
			<c:set var="number" value="${sendNumber}" />
			<c:if test="${number == true}">
			<c:url value="updatecard.jsp" var="updatecard">
				<c:param name="accNo" value="${cardid}" />
			    <c:param name="name" value="${cardname}" />
			    <c:param name="email" value="${cardemail}" />
			    <c:param name="address" value="${cardaddress}" />
			    <c:param name="phone" value="${cardphone}" />
			    <c:param name="nic" value="${cardnic}" />
			    <c:param name="salary" value="${cardsalary}" />
			    <c:param name="occupation" value="${cardoccupation}" />
			    <c:param name="type" value="${cardtype}" />
			</c:url>	
			<a href="${updatecard}" style="text-decoration: none">
				<input type="button" class="btn btn-primary btn-block" name="credit" value="Change Card Details">
			</a>
			<br>
			<c:url value="deletecard.jsp" var="deletecard">
				<c:param name="accNo" value="${cardid}" />
			    <c:param name="name" value="${cardname}" />
			    <c:param name="email" value="${cardemail}" />
			    <c:param name="address" value="${cardaddress}" />
			    <c:param name="phone" value="${cardphone}" />
			    <c:param name="nic" value="${cardnic}" />
			    <c:param name="salary" value="${cardsalary}" />
			    <c:param name="occupation" value="${cardoccupation}" />
			    <c:param name="type" value="${cardtype}" />
			</c:url>	
			<a href="${deletecard}" style="text-decoration: none">
				<input type="button" class="btn btn-primary btn-block" name="credit" value="Delete My Card">
			</a>
			<br>
			</c:if>
			
			<c:url value="sendmessage.jsp" var="sendmessage">
				<c:param name="id" value="${id}" />
			    <c:param name="name" value="${name}" />
			    <c:param name="email" value="${email}" />
			    <c:param name="phone" value="${phone}" />
			    <c:param name="salary" value="${salary}" />
			</c:url>
			<a href="${sendmessage}" style="text-decoration: none">
				<input type="button" class="btn btn-info btn-block" name="message" value="Send Message to Manager">
			</a>
			<br>
			<c:url value="loanrequest.jsp" var="loanrequest">
				<c:param name="id" value="${id}" />
			    <c:param name="name" value="${name}" />
			    <c:param name="nic" value="${nic}" />
			    <c:param name="email" value="${email}" />
			    <c:param name="phone" value="${phone}" />
			    <c:param name="salary" value="${cardsalary}" />
			</c:url>
			<a href="${loanrequest}" style="text-decoration: none">
				<input type="button" class="btn btn-info btn-block" name="loan" value="Request a Loan">
			</a>
			<br>
			<c:url value="updatecustomer.jsp" var="cusup">
				<c:param name="id" value="${id}" />
			    <c:param name="nic" value="${nic}" />
			    <c:param name="name" value="${name}" />
			    <c:param name="email" value="${email}" />
			    <c:param name="address" value="${address}" />
			    <c:param name="phone" value="${phone}" />
				<c:param name="dob" value="${dob}" />
				<c:param name="gender" value="${gender}" />
			    <c:param name="password" value="${password}" />
			</c:url>	
			<a href="${cusup}" style="text-decoration: none">
				<input type="button" class="btn btn-info btn-block" name="edit" value="Edit My Details">
			</a>
			<br>
			<c:url value="deletecustomer.jsp" var="cusdel">
				<c:param name="id" value="${id}" />
			    <c:param name="nic" value="${nic}" />
			    <c:param name="name" value="${name}" />
			    <c:param name="email" value="${email}" />
			    <c:param name="address" value="${address}" />
			    <c:param name="phone" value="${phone}" />
				<c:param name="dob" value="${dob}" />
				<c:param name="gender" value="${gender}" />
			</c:url>	
			<a href="${cusdel}" style="text-decoration: none">
				<input type="button" class="btn btn-warning btn-danger btn-block" name="delete" value="Delete My Account">
			</a>
			<br>
			<a href="cusout" style="text-decoration: none">
				<input type="button" class="btn btn-warning btn-block" name="credit" value="Logout">
			</a>
		</div>
		</div>
		
	</div>
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