<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ include  file="guestheader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function () {
	  $('#dtsurya').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
</script>
</head>
<body>



<table id="dtsurya" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">ProductName

      </th>
      <th class="th-sm">ProductPrice

      </th>
      <th class="th-sm">TotalPrice

      </th>
      <th class="th-sm">Quantity

      </th>
      
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${cartList}"  var="cart">

    <tr>
      <td>${cart.productName}</td>
       <td>${cart.productPrice}</td>
      <td>${cart.totalPrice}</td>
      <td>${cart.quantity}</td>
      
    </tr>
    





</c:forEach>
     
  </tbody>
  <tfoot>
    <tr>
      <th>ProductName
      </th>
      <th>ProductPrice
      </th>
      <th>TotalPrice
      </th>
      <th>Quantity
      </th>
      
    </tr>
  </tfoot>
</table>

</body>
</html>