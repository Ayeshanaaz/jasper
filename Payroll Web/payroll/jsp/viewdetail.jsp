<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Payroll</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/updatepasswordstyle.css" />
<script>
	var validatePassword = function() {
		if (document.getElementById('pass1').value == document
				.getElementById('pass2').value) {
			document.getElementById('message').innerHTML = 'matching';
			document.getElementById('message').style.color = 'green';
		} else {
			document.getElementById('message').innerHTML = 'not matching';
			document.getElementById('message').style.color = 'red';
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
				<img id='logo-image' src='C:\Users\admin\Desktop\2.png'
					alt='virtusa logo' />
			</div>
		</div>
		<div id="content">
			<div id="nav">
				<h3>Quick links</h3>
				<ul>
					<a href='${pageContext.request.contextPath}/jsp/welcome.jsp'><li>Home page</li></a>
					<li>My Reports</li>
					<ul>
						<a
							href='${pageContext.request.contextPath}/jsp/investdeclaration.jsp'><li
							style="list-style: square;">Investment Declaration</li></a>
						<a href='${pageContext.request.contextPath}/jsp/selectpayroll.jsp'><li
							style='list-style: square;'>Payslips</li></a>
						<a
							href="${pageContext.request.contextPath}/jsp/claimreimbursement.jsp"><li
							style="list-style: square;">Reimbursements</li></a>
						<a
							href="${pageContext.request.contextPath}/BenefitRequestController"><li
							style="list-style: square;">Planner</li></a>
					</ul>
					<li>My Personal Details</li>
					<ul>
						<a href="${pageContext.request.contextPath}/ViewController"><li
							style="list-style: square;">My Personal Information</li></a>
						<a
							href="${pageContext.request.contextPath}/jsp/updatepassword.jsp"><li
							style="list-style: square;">Update password</li></a>
						<a href="${pageContext.request.contextPath}/CTCController"><li
							style="list-style: square;">My CTC</li></a>
					</ul>
				</ul>
			</div>
			<div id="main" style="overflow: scroll;">
				<fieldset>
					<legend>
						<h2>View Details</h2>
					</legend>
					<br />
					<form action="/Payroll_Web/UpdateController" method="post">
						<table align='center'>
							<tr>
								<td colspan="2" align="center"><h1>employee details</h1></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><hr /></td>
							</tr>

							<!--  db element -->

							<tr>
								<td>employee id:</td>
								<td><input type="text" name="emp_id"
									value="${requestScope.empid}" placeholder="Enter emp no"
									required readonly></td>
							</tr>
							<tr>
								<td>Enter Name</td>
								<td><input type="text" id="name"
									value="${requestScope.ename }" name="Name"
									placeholder="Enter User Name" required="required" /></td>
							</tr>
							<tr>
								<td>Select gender</td>


								<%
									String x = request.getAttribute("gender").toString();
								%>
								<td>
									<%
										if (x.equalsIgnoreCase("Male")) {
									%> Male<input type="radio" name="emp_gender" value="Male"
									checked /> Female <input type="radio" name="emp_gender"
									value="Female" /> <%
 	}
 %> <%
 	if (x.equalsIgnoreCase("Female")) {
 %> Male<input type="radio" name="emp_gender" value="Male" /> Female <input
									type="radio" name="emp_gender" value="Female" checked /> <%
 	}
 %>



								</td>
							</tr>


							<tr>
								<td>Enter address</td>
								<td><input type="text" name="emp_address"
									id="customerAddress" value="${requestScope.address }"></td>
							</tr>
							<tr>
								<td>Enter contact</td>
								<td><input type="number"  name="emp_contact" id="contact"
									value="${requestScope.contact}" placeholder="Enter contact"
									 maxlength='9' required="required"></td>
							</tr>
							<tr>
								<td>Enter pan</td>
								<td><input type="text" name="emp_pan" id="employee pan"
									value="${requestScope.pan }" placeholder="Enter pan" required></td>
							</tr>
							<tr>
								<td>Enter Email Id</td>
								<td><input type="email" id="employeeEmail"
									value="${requestScope.mail }" name="empEmail"
									placeholder="Enter emp email" required="required" readonly></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									name="register" value="Update"></td>
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