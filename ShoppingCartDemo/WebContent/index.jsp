<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 <tiles:insertDefinition name="defaultTemplate"> 
 <tiles:putAttribute name="menu">
<table>
<tr>
	<td><a href="login" style="color: black">Login</a></td></tr>
    <tr><td><a href="register" style="color: black">Register Me</a></td>
</tr>
</table>
</tiles:putAttribute>
  </tiles:insertDefinition> 
<!-- </body>
</html> -->