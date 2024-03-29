<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		
		<div id="container">
			<div id="content">
			
				<input type="button" value="Add Customer"
						onclick="window.location.href='showFormForAdd'; return false"
						class="add-button"/>
				
				<form:form action="search" method="GET">
	                Search customer: <input type="text" name="searchName" />
	                <input type="submit" value="Search" class="add-button" />
            	</form:form>
			
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}">
					
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
					
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href="${updateLink}">Update</a> | 
								<a href="${deleteLink}" onclick="if(!(confirm('Sure to delete?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>