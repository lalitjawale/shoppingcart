<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



      <center>
	<form:form action="login" method="post" commandName="user">
	<table>
		<tr>
			<td>Enter username</td>
			<td><form:input type="text" name="username" path="username" /></td>
		</tr>
		
		<tr>
			<td>Enter password</td>
			<td><form:input type="password" name="password" path="password"/></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Login"></td>
		</tr>
		
	</table>
	</form:form>
</center>
