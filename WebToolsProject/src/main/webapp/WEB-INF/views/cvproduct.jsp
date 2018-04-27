<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Cart View Product</h1>
<body>
<body style="background-color:powderblue;">

 
                    ProductId:${productdekh.productId}<br><br>
                    Product Name:${productdekh.pname}<br><br>
                    Product Price:${productdekh.price}<br><br>
                    No of mobile unit available :${productdekh.stock}<br><br> 
                   <form action="${pageContext.request.contextPath}/cart/confirmbooking" method="post">
                   Enter Quantity <input type="text" name="quantity" value=""><br><br>
                   <input type="submit" name="productsubmit" value="Purchase">
                    
               </form>
            
</body>
</html>