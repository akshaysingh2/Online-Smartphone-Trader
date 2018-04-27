<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<body style="background-color:powderblue;">
<a href="${pageContext.request.contextPath}/cart ">Buy more product</a>
<table border="1">
                <tr>
                    <th>OrderId</th>
                    <th>ProductName</th>
                    <th>UserName</th>
                    <th>CustomerId</th>
                    <th>Quantity</th>
                    <th>price</th>
                    
                </tr> 
           <c:forEach items="${orderlist}" var="u">
                    <tr>
                        <td>${u.orderid}</td>
                        <td>${u.productname}</td>
                        <td>${u.username}</td>
                        <td>${u.userid}</td> 
                        <td>${u.orderquantity}</td>
                        <td>${u.price}</td>
      
                    </tr> 
                </c:forEach>
            </table>


</body>
</html>