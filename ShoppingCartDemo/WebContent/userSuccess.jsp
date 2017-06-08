<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
  <%--   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <tiles:insertDefinition name="defaultTemplate" role="ROLE_User">
 
    <tiles:putAttribute name="body">
         <br>Hi User....
 </tiles:putAttribute>
    <tiles:putAttribute name="menu">
        <ul>
    <li><a href="">My Profile</a></li>
    <li><a href="">Products</a></li>
   
</ul>
    </tiles:putAttribute>
   <%-- 
    <tiles:putAttribute name="footer">
        Copyright &copy; Neosoft Technologies 2017
    </tiles:putAttribute> --%>
 
</tiles:insertDefinition> 
</body>
</html>