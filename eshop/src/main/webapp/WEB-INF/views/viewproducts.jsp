<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jscore"%>
<%@ include file="guestheader.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<div class="cont">
    
    <jscore:forEach items="${productList}"    var="product">
     
       <img src="abc.jpg"  width="50" height="50" /> </br> 
        ${product.productName} 
${product.productPrice} 
      <a href="viewproduct?proid= ${product.productId}">viewdetails </a>
      </jscore:forEach>
    
      
     
</body>
</html>