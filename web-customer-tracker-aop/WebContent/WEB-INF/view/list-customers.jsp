<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>

<html>
<head>
<title>Customer List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Customer" class="add-button"
				onclick="window.location.href='showFormForAdd'; return false;" />

			<f:form action="search" method="GET">
		Search Customer: <input type="text" name="theSearchName" />
				<input type="submit" value="Search" class="add-button">
			</f:form>

			<table>
				<tr>
					<th>First Name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCust" items="${customers }">

					<!-- update link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCust.id}"></c:param>
					</c:url>

					<!-- delete link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCust.id}"></c:param>
					</c:url>

					<tr>
						<td>${tempCust.firstName}</td>
						<td>${tempCust.lastName}</td>
						<td>${tempCust.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>


			</table>

		</div>
	</div>

</body>
</html>