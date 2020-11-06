<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>List of Customers</title>
	
	<!-- reference our style sheets  -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="Wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- put on a new button: add customer -->
			<input type="button" value="Add Customer"
				   onClick="window.location.href='showFormForAdd';return false;"
				   class="add-button"
			/>
			
			<!-- add our table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				
				<c:forEach var="tempCustomers" items="${customers}">
					
					<!-- construct the "Update" link -->
					<!--<c:url var="updateLink" value="/customer/showFormForAdd">
						<c:param name="customerId" value="${tempCustomers.id}"/>
					</c:url>-->
					
					<tr>
						<td> ${tempCustomers.firstName} </td>
						<td> ${tempCustomers.lastName} </td>
						<td> ${tempCustomers.email} </td>
						<td><!-- add the customer ""update link --><a href="${updateLink}">Update</a></td>
					</tr>	
				</c:forEach>

			</table>
			
		</div>
	</div> 
</body>
</html>
