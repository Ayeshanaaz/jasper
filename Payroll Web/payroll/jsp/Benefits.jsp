<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>		
		<title> Payroll		</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updatepasswordstyle.css"/>	
		<script>
		function enableEdit(change) {
		  var childfee=document.getElementById("childfee");
		  var lta=document.getElementById("lta");
		  var phone=document.getElementById("phone");
		  var foodcoupon=document.getElementById("foodcoupon");
		  var submit=document.getElementById("submit");
		  childfee.disabled=change.checked?false:true;
		  lta.disabled=change.checked?false:true;
		  phone.disabled=change.checked?false:true;
		  foodcoupon.disabled=change.checked?false:true;
		  submit.disabled=change.checked?false:true;
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
						<a href='${pageContext.request.contextPath}/jsp/investdeclaration.jsp'><li style="list-style: square;">InvestmentDeclaration</li></a> 
						<a href='${pageContext.request.contextPath}/jsp/selectpayroll.jsp' ><li style='list-style: square;'>Payslips</li></a>
						<a href="${pageContext.request.contextPath}/jsp/claimreimbursement.jsp"><li style="list-style: square;">Reimbursements</li></a>
						<a href="${pageContext.request.contextPath}/BenefitRequestController"><li style="list-style: square;">Planner</li></a>
					</ul>
					<li>My Personal Details</li>
					<ul>
						<a href="${pageContext.request.contextPath}/ViewController"><li style="list-style: square;">my personal information</li></a>
						<a href="${pageContext.request.contextPath}/jsp/updatepassword.jsp"><li style="list-style: square;">Update password</li></a>
						<a href="${pageContext.request.contextPath}/CTCController"><li style="list-style: square;">My CTC</li></a>
					</ul>
				</ul>
				</div>
				<div id="main" style="overflow:scroll;">
					<fieldset>
						<legend><h2>Benefits</h2></legend>
						<br/>
							<form action="/Payroll_Web/BenifitController" method="post">
							<table align='center'>
								<tr>
								<th>S.No</th>
								<th>Bonus Type</th>
								
								<th>Amount</th>
								
								</tr>
								<tr>
									<td>1</td>
									<td>Child Fee</td>
									
									<td>
										<select name="childfee" id="childfee" value="0" disabled="disabled"  required >
											<option  selected>${requestScope.childfee}</option>
											<option>0</option>
											<option>100</option>
											<option>200</option>
										</select>
									</td>
									
								</tr>
								<tr>
									<td>2</td>
									
									<td>Food Coupons</td>
									
									<td>
										<select name="foodcoupon" id="foodcoupon" value="0" disabled="disabled">
											<option  selected>${requestScope.food}</option>
											<option>0</option>
											<option>1100</option>
											<option>2200</option>
										</select>
									</td>
									
								</tr>
								<tr>
									<td>3</td>
									<td>LTA</td>
									
									<td>
										<select name="lta" value="0" id="lta" disabled="disabled">
											<option  selected>${requestScope.lta}</option>
											<option>0</option>
											<option>1000</option>
											<option>2000</option>
										</select>
									</td>
									
								</tr>
								<tr>
									<td>4</td>
									<td>Phone</td>
									
									<td>
										<select name="phone"  id="phone" disabled>
										<option  selected>${requestScope.phone}</option>
											<option>0</option>
											<option>500</option>
											<option>600</option>
										</select>
									</td>
									
								</tr>
								
								<tr>
									
									<td colspan="3" align="center"> <input type="submit" id="submit" value="submit" disabled > </td>
									<td ><input type="checkbox" name="change" value="change" onclick="enableEdit(this)"/>Change</td>
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