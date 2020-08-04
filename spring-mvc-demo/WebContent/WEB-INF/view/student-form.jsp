<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<f:form action="processForm" modelAttribute="student">

First Name: <f:input path="fName" /> <br><br>
	
Last Name: <f:input path="lName" />	<br><br>

Country: <f:select path="country">
		<f:options items="${student.countryOptions}"/>
		</f:select>	<br><br>
    	
	Country from Prop: <f:select path="pCountry">
		<f:options items="${propOptions}"/>
		</f:select>	<br><br>
		
	<%-- Favorite Language : 
	C++<f:radiobutton path="favLanguage" value="C++"/>
	JAVA<f:radiobutton path="favLanguage" value="JAVA"/>
	PHP<f:radiobutton path="favLanguage" value="PHP"/>
	 --%>
	<br><br>
	
	Favorite Language :<f:radiobuttons path="favLanguage" items="${student.favLanguageOptions }"/>
	
	<br><br>
	
	Operating Systems: Linux <f:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <f:checkbox path="operatingSystems" value="Mac OS"/>
	MS Window <f:checkbox path="operatingSystems" value="MS Window"/>
	
	<br><br>
	
	<input type="submit" value="Submit" />

</f:form>