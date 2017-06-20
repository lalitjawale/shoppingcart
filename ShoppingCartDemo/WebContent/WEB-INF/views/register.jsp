
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




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
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</center>

    