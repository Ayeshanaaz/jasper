<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>		
		<title> Payroll		</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updatepasswordstyle.css"/>			
		<script>
		var validatePassword=function(){
			if(document.getElementById('pass1').value==document.getElementById('pass2').value){
				document.getElementById('message').innerHTML='matching';
				document.getElementById('message').style.color='green';
			}
			else{
				document.getElementById('message').innerHTML='not matching';
				document.getElementById('message').style.color='red';
			}
			var x=document.getElementById('pass1').value.length;
			if(x<=10){
				document.getElementById('message2').innerHTML='max length should be 10 characters';
			}
			else{
				document.getElementById('message2').innerHTML='hai';
			}
			
		}
		</script>
	</head>
	<body>
	<c:if test="${empty sessionScope.user}">
		
		<jsp:forward page="${PageContext.request.contextPath}/jsp/error.jsp"></jsp:forward>
		
	</c:if>
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
						<legend><h2>Change Password</h2></legend>
						<br/>
						<form method='post' action='/Payroll_Web/SecurityUpdateController'>
							<table align="center">
							<tr><td> Enter your password:</td>
							<td>
								<input type='password'  name="password" onkeyup='validatePassword();' maxlength="10" id='pass1' placeholder='Enter Password' required/>
							</td>
							<tr>
								<td>Confirm your password:</td>
								<td>
									<input type='password' name="confirmpasssword" onkeyup='validatePassword();' maxlength="10" id='pass2' placeholder='Confirm your password' required/>
									<span id='message'></span>
									<span id='message2'></span>
								</td>
							</tr>
							<tr>
								
								<td colspan="2" align='center'> 
									<input type='submit' value='Submit'/>
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