<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>		
		<title> Payroll		</title>
		<link rel="stylesheet" type="text/css" href="../css/updatepasswordstyle.css"/>			
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
					<h3>navigation</h3>
					<ul>
						<a href=""><li> update pan and aadhar </li></a>
						<a href=""><li> My Reports	</li></a>
							<ul>
								<a href="..\jsp\investment.jsp" ><li style=" list-style:square;"> Investment Declaration	</li></a>
								<a href=""><li style=" list-style:square;"> Payslips</li></a>
								<a href=""><li style=" list-style:square;"> Planner</li></a>
								<a href=""><li style=" list-style:square;"> Reimbursements	</li></a>
								<a href=""><li style=" list-style:square;"> Benifits	</li></a>
							</ul>
						<a href=""><li> My Personal Details</li></a>
							<ul>
								<a href=""><li style=" list-style:square;">my personal information</li></a>
								<a href=""><li style=" list-style:square;"> Update password	</li></a>
								<a href="C:\Users\admin\Downloads\Security1.html"><li style=" list-style:square;"> My CTC	</li></a>
							</ul>
					</ul>
				</div>
			
				<div id="main" style="overflow:scroll;">
					<fieldset>
						<legend>
							<h2>Login Form</h2>
						</legend>
						
				
								<form action='/Payroll_Web/LoginController' method='post'>
								<table align="center">
									<tr>
										<td> Username </td>
										<td> <input type="text" placeholder="Enter Username" name="uname" required> </td>
										
									</tr>
									<tr>
										<td> password </td>
										<td><input type="password" placeholder="Enter Password" name="password" required></td>
									</tr>
									<tr>
										<td> <a href='../jsp/security.jsp'>forgot password </a></td>
										<td align='center'>
										 	<input type='submit' value='login'>
										</td>
									</tr>
								</table>								
								</form>
					</fieldset>
												
				</div>
			</div>
			<div id="footer">
			
				copyright &copy;	2019 batch
			</div>
		</div>
	</body>
</html>