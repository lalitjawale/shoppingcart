<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate"><tiles:putAttribute name="body">
<h1>Welcome to  shipping</h1>
<center>
	<form action="shippingAndBillingAction" method="post">
		<table>
			<tr>
				<td>Enter your email id</td>
				<td><input type="text" name="emaiID"> </td>
			</tr>
			<tr><td><h3>Enter Shipping Information</h3></td></tr>
			<tr>
				<td>Enter FirstName</td>
				<td><input type="text" name="firstName"> </td>
			</tr>
			
			<tr>
				<td>Enter LastName</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			<tr>
				<td>Enter Address</td>
				<td><textarea name="address"></textarea></td>
			</tr>
			
			<tr>
				<td>Enter City</td>
				<td><input type="text" name="city"></td>
			</tr>
			
			<tr>
				<td>Enter state</td>
				<td><input type="text" name="state"></td>
			</tr>
			
			<tr>
				<td>Enter ZipCode</td>
				<td><input type="text" name="zipcode"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Next"></td>
			</tr>
		</table>
	</form>
</center>
</tiles:putAttribute>
</tiles:insertDefinition>