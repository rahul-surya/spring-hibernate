<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
<title>Home Page</title>
</head>

<body>
<h2>Home Page</h2>
<hr>

<p>Welcome to the home page</p>

<hr>

<!-- Display User name and Role -->

User: <security:authentication property="principal.username"/>
<br><br>
Role(s): <security:authentication property="principal.authorities"/>

<security:authorize access="hasRole('MANAGER')">

<p>

<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
(Only for Manager peoples)

</p>

</security:authorize>

<security:authorize access="hasRole('ADMIN')">

<p>

<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
(Only for Admin peoples)

</p>

</security:authorize>

<hr>

<!-- add logout button -->

<form:form  action="${pageContext.request.contextPath}/logout"
			   method="POST">
			   
<input type="submit" value="Logout"/>

</form:form>

</body>

</html>



