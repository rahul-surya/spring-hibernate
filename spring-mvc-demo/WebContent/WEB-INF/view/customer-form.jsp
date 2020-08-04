<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<head>

<style type="text/css">
.error {
	color: red
}
</style>
</head>

<body>

	<font color="blue">* Indicates required fields.</font><br><br>

	<f:form action="processForm" modelAttribute="customer">

First Name: <f:input path="firstName" />

		<br>
		<br>

*Last Name: <f:input path="lastName" />
		<f:errors path="lastName" cssClass="error" />

		<br>
		<br>

Free Passes: <f:input path="freePasses"/>
<f:errors path="freePasses" cssClass="error"/>
	<br>
		<br>
		
		Postal Code: <f:input path="postalCode"/>
        <f:errors path="postalCode" cssClass="error"/>
	<br>
		<br>
		
		Course Code: <f:input path="courseCode"/>
        <f:errors path="courseCode" cssClass="error"/>
	<br>
		<br>

		<input type="submit" value="Submit" />


	</f:form>

</body>

