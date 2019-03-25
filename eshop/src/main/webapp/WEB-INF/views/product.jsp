<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="adminheader.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sf:form   action="addproduct"  method="post" modelAttribute="pr"   enctype="multipart/form-data">
ProdutcName <sf:input path="productName" />
ProdutcPrice <sf:input path="productPrice"  />
<sf:input path="image"   type="file"  />
<input type="submit" value="SaveProduct" />
</sf:form>
</body>
</html>