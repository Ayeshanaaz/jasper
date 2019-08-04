<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Payroll</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/updatepasswordstyle.css" />
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
			<div id="logout">
				<a href="${pageContext.request.contextPath}/LogOutController">Logout</a>
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
						<h2>Home page</h2>
					</legend>

					<p align="justify" style="margin-left: 3%; margin-right: 3%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;At
						Virtusa we accelerate business outcomes for our clients through
						our expert information technology consulting and outsourcing
						services. We support a wide variety of Forbes Global 2000 firms
						with services that span the entire spectrum of the IT services
						lifecycle. Our industry-leading solutions transform businesses not
						only for a better today, but also for a better future.</p>
					<p align="justify"">
					<h3 style="margin-left: 3%; margin-right: 3%;">Our values</h3>
					<ul>

						<li><i>Passion</i></li>
						</br>
						<li><i>Innovation</i></li>
						</br>
						<li><i>Respect</i></li>
						</br>
						<li><i>LeaderShip</i></li>
						</br>
					</ul>
					</p>


				</fieldset>
			</div>

		</div>
		<div id="footer">copyright &copy; 2019 batch</div>
	</div>
</body>
</html>