<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Payroll</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/updatepasswordstyle.css" />
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="heading">
				<h2>Virtusa Payroll Management</h2>
			</div>
			<div id="logo">
				<img id='logo-image' src='C:\Users\admin\Desktop\2.png'
					alt='virtusa logo' />
			</div>
		</div>
		<div id="content">
			<div id="nav">
				<h3>navigation</h3>
				<ul>
					<a href=""><li>update pan and aadhar</li></a>
					<a href=""><li>My Reports</li></a>
					<ul>
						<a href=""><li style="list-style: square;">Investment
								Declaration</li></a>
						<a href=""><li style="list-style: square;">Payslips</li></a>

						<a href=""><li style="list-style: square;">
								Reimbursements</li></a>
						<a href=""><li style="list-style: square;">Benifits</li></a>
					</ul>
					<a href=""><li>My Personal Details</li></a>
					<ul>
						<a href=""><li style="list-style: square;">my personal
								information</li></a>
						<a href=""><li style="list-style: square;">Update
								password</li></a>
						<a href="C:\Users\admin\Downloads\Security1.html"><li
							style="list-style: square;">My CTC</li></a>
					</ul>
				</ul>
			</div>
			<div id="main" style="overflow: scroll;">
				<fieldset>
					<legend>
						<h2>Upload your Investment Declarations here</h2>
					</legend>
					<br />
					<form method='post' action='/Payroll_Web/InvestmentController'>
						<table align="center">
							<tr>
								<td><label for="insurance"><b>Insurance </b></label></td>
								<td><input type="file" name="insurance"><br>
								<br></td>
							</tr>
							<tr>
								<td><label for="eduloan"><b>Education Loan
											Interest</b></label></td>
								<td><input type="file" name="eduloan"><br>
								<br></td>
							</tr>
							<tr>
								<td><label for="ppf"><b>Public Provident Fund</b></label></td>
								<td><input type="file" name="ppf"><br>
								<br></td>
							</tr>
							<tr>
								<td><label for="loan"><b>Personal Loan Interest</b></label></td>
								<td><input type="file" name="loan"><br>
								<br></td>
							</tr>
							<tr>
								<td colspan="2"><input type='submit' value='submit' /></td>
							</tr>
						</table>
					</form>
					</br/>
				</fieldset>
			</div>

		</div>
		<div id="footer">copyright &copy; 2019 batch</div>
	</div>
</body>
</html>