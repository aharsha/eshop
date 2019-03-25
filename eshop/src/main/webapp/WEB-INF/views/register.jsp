<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form action="addUser" method="post"  modelAttribute="user" >
UserName <sf:input path="username"  /></br>
Email <sf:input path="email"  /></br>
Password <sf:input path="password"  /></br>
Mobile <sf:input path="mobile"  /></br>
Role <sf:input path="role"  /></br>
Enabled <sf:input path="enabled"  /></br>
<input type="submit" value="AddUser" /></br>
</sf:form>

</body>
</html>