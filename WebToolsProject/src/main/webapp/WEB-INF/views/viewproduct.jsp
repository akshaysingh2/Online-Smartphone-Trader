<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
<h1>View Product</h1>
<body style="background-color:powderblue;">
<table border="1">
                <tr>
                    <th>SmartphoneId</th>
                    <th>SmartPhoneName</th>
                    <th>SmartPhoneBrand</th>
                    <th>SmartPhonePrice</th>
                    <th>SmartPhoneStock</th>
                </tr> 
           <c:forEach items="${sessionScope.productl}" var="p">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.pname}</td>
                        <td>${p.brand}</td>
                        <td>${p.price}</td>
                        <td>${p.stock}</td>
            
                    </tr> 
                </c:forEach>
            </table>

</body>
</html>