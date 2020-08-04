<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


The Student is confirmed: ${student.fName} ${student.lName}

<br>
<br>

Country: ${student.country}

<br>
<br>

Country From Property: ${student.pCountry}

<br>
<br>

Favorite Language : ${student.favLanguage}


<br>
<br>

Operating Systems:
<ul>
	<c:forEach var="os" items="${student.operatingSystems }">
		<li>${os}</li>
	</c:forEach>


</ul>

