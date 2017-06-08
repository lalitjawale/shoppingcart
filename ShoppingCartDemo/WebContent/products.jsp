<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

Welcome to products list

<p><font size="3" face="Verdana, Arial, Helvetica, sans-serif"><strong>Products
  </strong></font></p>
 
  <a href="viewCart"/><img src="image/cartlogo.jpg" alt="" style="float: right;"/></a>
<!-- <a href="viewCart" >View Cart</a> -->
<p/>    

<table width="75%" border="1">
  <tr>
    <td><form:form name="modelDetail1" method="POST" action="addToCart" commandName="products">
 				<font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model:</strong>
        		TF-Model1</font><form:input type="hidden" name="partNumber"  path="partNumber" value="TF-MODEL1"></form:input>
               <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>modelDescription:</strong>
                Tech-Freaks imaginary model 1. </font>
                <form:input type="hidden" name="modelDescription"  path="modelDescription" value="Tech-Freaks imaginary model 1."></form:input></p>
                 <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Quantity:
                 <form:input type="text" size="2" value="1" name="quantity" path="quantity"></form:input></strong></font></p>
                 <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>unitCost:</strong>$10.00</font>
                 <form:input type="hidden" name="unitCost"  path="unitCost" value="10"></form:input></p>
      <input type="submit" name="addToCart" value="Add To Cart">
      </form:form></td>
      
    <td><form:form name="modelDetail2" method="POST" action="addToCart" commandName="products">
    <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model</strong>:
      TF-Model2 </font><form:input type="hidden" name="partNumber" path="partNumber" value="TF-MODEL2"></form:input>
						<font face="Verdana, Arial, Helvetica, sans-serif">
      <p><font size="2"><strong>modelDescription</strong>: Tech-Freaks imaginary model
        2. </font><form:input type="hidden" name="modelDescription" path="modelDescription" value="Tech-Freaks imaginary model 2."></form:input></p>
      <p><font size="2"><strong>Quantity</strong>: <form:input type="text" size="2" value="1" name="quantity" path="quantity"></form:input></font></p>
      <p><font size="2"><strong>unitCost</strong>: $20.00<form:input type="hidden" name="unitCost"   path="unitCost" value="20"></form:input></font></p>
         
             <input type="submit" name="addToCart" value="Add To Cart">
      </font></form:form></td>
  </tr>
  <tr>
    <td><form:form name="modelDetail3" method="POST" action="addToCart" commandName="products"><p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model:</strong>
        TF-Model3</font><form:input type="hidden" name="partNumber"  path="partNumber" value="TF-MODEL3"></form:input></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>modelDescription:</strong>
        Tech-Freaks imaginary model 3. </font><form:input type="hidden" name="modelDescription"  path="modelDescription" value="Tech-Freaks imaginary model 3."></form:input></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Quantity:</strong></font>
       <form:input type="text" size="2" value="1" name="quantity" path="quantity"></form:input></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>unitCost: $30.00</strong></font>
      <form:input type="hidden" name="unitCost" value="30"  path="unitCost"></form:input></p>  
        <input type="submit" name="addToCart" value="Add To Cart">
</form:form></td>
    <td><form:form name="modelDetail4" method="POST" action="addToCart" commandName="products"><p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model</strong>:
        TF-Model4</font><form:input type="hidden" name="partNumber" path="partNumber" value="TF-MODEL4"></form:input></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>modelDescription</strong>:
        Tech-Freaks imaginary model 4. </font><form:input type="hidden" name="modelDescription" path="modelDescription" value="Tech-Freaks imaginary model 4."></form:input></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Quantity</strong>:</font>
       <form:input type="text" size="2" value="1" name="quantity" path="quantity"></form:input></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>unitCost</strong>: $40.00</font>
      <form:input type="hidden" name="unitCost"   path="unitCost" value="40"></form:input></p>
  <input type="submit" name="addToCart" value="Add To Cart"></form:form></td>
  </tr>
</table>
<%-- <%} %> --%>
<p> </p>






<!-- <a href="addToCart">Add to Cart</a> -->
