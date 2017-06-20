

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	Hi, ${pageContext.request.userPrincipal.name},please fill up billing information
	<br>
	
	<%-- <c:url var="logoutAction" value="/j_spring_security_logout"></c:url>
	<tr>
			<td><form:input path="userId"  value="<%= session.getAttribute("userId") %>"/></td>
			</tr>
	<form action="${logoutAction}" method="post">
		<input type="submit" value="Logout" />
		<input type="text" value="">
	</form> --%>
	</c:if>

<% int id=(Integer)session.getAttribute("userId");
/* out.println(id); */
%>
  <h1>Billing information</h1>
  
        <center>
        
	<form:form action="saveOrderAddress"  method="post" commandName="billing">
		<table>
			<tr>
			<td><input type="hidden" name="id"  value="<%= session.getAttribute("userId") %>"/></td>
			</tr>
			<tr>
				<td>Enter FirstName</td>
				<td><form:input path="firstName"/></td>
				</tr>
			
			<tr>
				<td>Enter LastName </td>
				<td><form:input path="LastName"/></td>
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
				<td>Enter Address </td>
				<td><form:input path="address"/></td>
			</tr>
			
			
			<tr>
				<td>Enter City </td>
				<td><form:input path="city"/></td>
			</tr>
			
			
			<tr>
				<td>Enter State</td>
				<td><form:input path="state"/></td>
			</tr>
			
			
			<tr>
				<td>Enter Postal Code </td>
				<td><form:input path="postalCode"/></td>
			</tr>
			
			
			
			<tr>
				<td>Enter Payment Option</td>
				<td><form:radiobutton path="paymentOption" value="cash"></form:radiobutton>Cash On Delivery</td>
				<td><form:radiobutton path="paymentOption" value="paypal"></form:radiobutton>Use Paypal</td>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Place Order"></td>
			</tr>
		</table>
	</form:form>
</center>

