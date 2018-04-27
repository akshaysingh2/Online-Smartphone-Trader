<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Thank You ${sessionScope.user.username}</h1>
<a href="${pageContext.request.contextPath}/final.htm">View Cart</a>
<body>
<body style="background-color:powderblue;">
 Product Id:${cartitem.cartItemId}<br><br>
 Product Name:${productabc.pname}<br><br>
 Product Price:${sessionScope.tp}<br><br>                   
</body>
</html>