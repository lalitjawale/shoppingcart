//prakash changes
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<tiles:insertDefinition name="defaultTemplate" > 
 <tiles:insertAttribute name="menu" ignore="true">
  <ul>
    <li><a href="login">About us</a></li>
   <!--  <li><a href="register">Register Me</a></li> -->
   </ul>
 </tiles:insertAttribute>
 <tiles:putAttribute name="body">
        <br><h1>${msg}</h1>
    </tiles:putAttribute>
    <tiles:putAttribute name="menu"> 
    <tiles:putAttribute name="menu">
       

</tiles:putAttribute>
    <tiles:putAttribute name="body" > 
  
 <tiles:putAttribute name="body" > 
 
 --%>
      <center>
	<form:form action="login" method="post" commandName="users">
	<table>
		<tr>
			<td>Enter username</td>
			<td><form:input path="username" /></td>
		</tr>
		
		<tr>
			<td>Enter password</td>
			<td><form:password path="password"/></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Login"></td>
		</tr>
		
	</table>
	</form:form>
</center>
<%-- 
 </tiles:putAttribute> 
 </tiles:putAttribute>
 </tiles:insertDefinition>  

  </body>
 --%>
<!-- </html> -->