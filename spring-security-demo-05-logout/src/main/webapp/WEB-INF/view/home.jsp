<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>Hello.....</h3>

<form:form  action="${pageContext.request.contextPath}/logout"
			   method="POST">
			   
<input type="submit" value="Logout"/>

</form:form>