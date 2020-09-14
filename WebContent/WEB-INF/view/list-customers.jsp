<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List customers</title>

<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/mojiResursi/css/style.css">
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new Add customer button  -->
			<input type="button" value="Add customer" onclick="window.location.href='showFormAdd'; return false;"
			class="add-button" 
			/>
			
			<!-- add new Search form and button -->
			<form:form action="searchForm" method="GET">
			 Search customer: <input type="text" name="theSearchName" placeholder="Enter first name" />
			 <input type="submit" value="Search" class="add-button" />
			 </form:form>
			
			<!-- add html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print out customers -->
				<c:forEach var="tempCustomer" items="${customeri}">
					
					<!-- construct an update link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<c:url var="deleteLink" value="/customer/showFormForDelete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a>
						 | 
						<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
				
				
				
				
				
			</table>
		
		</div>
	</div>

</body>


</html>