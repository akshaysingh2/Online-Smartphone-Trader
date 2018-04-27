<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Product View</h1>
<a href="${pageContext.request.contextPath}/final.htm">View Your Cart</a><br><br>
<a href="${pageContext.request.contextPath}/">Return Home</a><br><br>
<form action="cart/{productu.productId}" method="GET">
<body style="background-color:powderblue;">
<table border="1">
                <tr>
                    <th>SmartphoneId</th>
                    <th>SmartPhoneName</th>
                    <th>SmartPhoneBrand</th>
                    <th>SmartPhonePrice</th>
                    <th>Value</th>
                </tr> 
                
           <c:forEach items="${productu}" var="p">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.pname}</td>
                        <td>${p.brand}</td>
                        <td>${p.price}</td>
                   <td><a href="cart/view?val=${p.productId}">View Product and Add to cart</a> </td>    
            
                    </tr> 
                    
                </c:forEach>
               
              
            </table>
 </form>

</body>
</html>