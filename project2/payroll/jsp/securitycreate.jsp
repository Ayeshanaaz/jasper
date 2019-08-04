<%@ page language="java" contentType="text/html; "
    pageEncoding="ISO-8859-1"%>

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
								<a href="" ><li style=" list-style:square;"> Investment Declaration	</li></a>
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
						<legend><h2>Choose a Security question</h2></legend>
						<br/>
						<form method='post' action='/Payroll_Web/CreateSecurityController'>
							<table align="center">
								<tr><td> Choose your question:</td>
								<td>
									<select id='security' name='securityquestion' required>
										<option selected disabled hidden>Choose here</option>
										<option>What is your first school name</option>
										<option>What is your favourite sport</option>
										<option>What is your nick name</option>
										<option>What is your pet name</option>
										<option>What is your favourite city</option>
									</select>
								</td>
								<tr>
									<td>Enter your answer:</td>
									<td>
										<input type='text' placeholder='Write your answer' name='securityanswer' required/>
									</td>
								</tr>
								<tr>
									
									<td colspan="2" align='center'> 
										<input type='submit' value='next'/>
									</td>
								</tr>
								</table>
						</form>
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