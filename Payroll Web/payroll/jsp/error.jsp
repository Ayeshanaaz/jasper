<%@ page isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
	<head>		
		<title> Payroll		</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updatepasswordstyle.css"/>			
	</head>
	<body>
		<div id="container">
			<div id="header">
				<div id="heading">
					<h2>Virtusa Payroll Management</h2>
				</div>
				<div id="logo">
					<img id='logo-image' src='C:\Users\admin\Desktop\2.png' alt='virtusa logo'/>
				</div>
			</div>
			<div id="content">
				<div id="nav">
					<h3>Quick links</h3>
				<ul>
					<a href='${pageContext.request.contextPath}/jsp/welcome.jsp'><li>Home page</li></a>
					<li>My Reports</li>
					<ul>
						<a href='${pageContext.request.contextPath}/jsp/investdeclaration.jsp'><li style="list-style: square;">Investment Declaration</li></a> 
						<a href='${pageContext.request.contextPath}/jsp/selectpayroll.jsp' ><li style='list-style: square;'>Payslips</li></a>
						<a href="${pageContext.request.contextPath}/jsp/claimreimbursement.jsp"><li style="list-style: square;">Reimbursements</li></a>
						<a href="${pageContext.request.contextPath}/BenefitRequestController"><li style="list-style: square;">Planner</li></a>
					</ul>
					<li>My Personal Details</li>
					<ul>
						<a href="${pageContext.request.contextPath}/ViewController"><li style="list-style: square;">My Personal Information</li></a>
						<a href="${pageContext.request.contextPath}/jsp/updatepassword.jsp"><li style="list-style: square;">Update password</li></a>
						<a href="${pageContext.request.contextPath}/CTCController"><li style="list-style: square;">My CTC</li></a>
					</ul>
				</ul>
				</div>
				<div id="main" style="overflow:scroll;">
					<fieldset>
						<legend><h2>Sorry...!</h2></legend>
						<br/>
							<h2 align='center'> You didn't login yet..! Login now <a href="${PageContext.request.contextPath}/Payroll_Web/html/login.html">Go to Login</a></h2>
						</br/>
					</fieldset>
					
				</div>
										
			</div>
			<div id="footer">
			
				copyright &copy;	2019 batch
			</div>
		</div>
	</body>
</html>