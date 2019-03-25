<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="adminheader.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function () {
	  $('#dtadminpro').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
</script>
</head>
<body>

<table id="dtadminpro" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">ProductName

      </th>
      <th class="th-sm">ProductPrice

      </th>
      <th class="th-sm">Image

      </th>
      <th class="th-sm">delete

      </th>
      
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${productList}"  var="product">

    <tr>
      <td> ${product.productName}</td>
       <td>${product.productPrice} </td>
        
      <td><img src="resources/proimg/${product.productId}.png"  width="50" height="50" /></td>
      <td><a href="#">delete </a></td>
      
    </tr>
    





</c:forEach>
     
  </tbody>


<tfoot>
    <tr>
      <th>ProductName
      </th>
      <th>ProductPrice
      </th>
      <th>Image
      </th>
      <th>delete
      </th>
      
    </tr>
  </tfoot>
</table>
      
     
</body>
</html>