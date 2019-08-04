<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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