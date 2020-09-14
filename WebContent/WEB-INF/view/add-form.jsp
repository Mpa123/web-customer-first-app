<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Save Customer</title>

<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/mojiResursi/css/style.css"/>
		
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/mojiResursi/css/add-customer-style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="processFormAdd" modelAttribute="customerAttr" method="POST">
			
			<!-- need to associate this data with customer id by adding hidden form data
			and providing customer id -->
			<form:hidden path="id" /> <!-- when this form is loaded, it will call customer.getId, place it here in
									hidden form field, and when doing submit it will call customer.setId -->
			
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					
					<tr>
					    <td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email" /></td>
				    </tr>
				    
				    <tr>
				    	<td><label></label></td>
				    	<td><input type="submit" value="Save" class="save" /></td>
				    </tr>
				    
				</tbody>
			
			
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	</div>

</body>


</html>