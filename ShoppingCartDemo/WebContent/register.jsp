<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<!-- <tiles:insertDefinition name="defaultTemplate">
 
    <tiles:putAttribute name="body"> -->
    <h1>${msg}</h1>
        <center>
	<form:form action="create" commandName="users" method="post">
		<table>
			<tr>
				<td>Enter username</td>
				<td><form:input path="username"/></td>
				</tr>
			
			<tr>
				<td>Enter password </td>
				<td><form:password path="password"/></td>
			</tr>
			
			<tr>
				<td>Enter emailId</td>
				<td><form:input path="emailId"/></td>
			</tr>
			
			<tr>
				<td>Enter contact number</td>
				<td><form:input path="contactNumber" /></td>
			</tr>
			
			<tr>
				<td>Enter User Role</td>
				<td><form:select path="user_Role">
					<form:option value="Select Role">Select Role</form:option>
					<form:option value="ROLE_User">User</form:option>
					<%-- <form:option value="ROLE_Manager">Manager</form:option>
					<form:option value="ROLE_TL">TL</form:option>
					 --%><%-- <form:option value=""></form:option> --%>
				</form:select></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</center>

    <!-- </tiles:putAttribute>
    <tiles:putAttribute name="menu">
        <ul>
    <li><a href="logint">Login</a></li>
    <li><a href="register">Register Me</a></li>
   
</ul>
    </tiles:putAttribute>
   
    <tiles:putAttribute name="footer">
        Copyright &copy; Neosoft Technologies 2017
    </tiles:putAttribute>
 
</tiles:insertDefinition> -->
</body>
</html>