<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>		
		<title> Payroll		</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updatepasswordstyle.css"/>	
		<script type='text/javascript'>
		window.addEventListener("load", function() {
			  document.getElementById("insurance").onchange = function(event) {
			    var reader = new FileReader();
			    console.log(reader.readAsDataURL(event.srcElement.files[0]));
			    //var me = this;
			    //reader.onload = function () {
			     // var fileContent = reader.result;
				//  console.log(fileContent);
			    //}
			}});
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
						<legend><h2>Select your Investment type</h2></legend>
						<br/>
						<form method='post' action='/Payroll_Web/InvestmentController'>
							<table align="center">
								<tr>
									<td><label for="insurance"><b>Insurance </b></label></td>
									<td><input type="file" id="insurance" onchange="getFilePath();" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document" name="insurance"><br><br></td>
								</tr>
								<tr>
									<td><label for="eduloan"><b>Education Loan Interest</b></label></td>
									<td><input type="file" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document" name="eduloan"><br><br></td>
								</tr>
								<tr>
									<td><label for="ppf"><b>Public Provident Fund</b></label></td>
									<td><input type="file" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document" name="ppf"><br><br></td>
								</tr>
								<tr>
									<td><label for="loan"><b>Personal Loan Interest</b></label></td>
									<td><input type="file" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document" name="loan" maxLength='10'><br><br></td>
								</tr>
								<tr>
									<td colspan="2"><input type='submit' value='submit'/></td>
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