<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
<body style="background-color:snow;">
<h1><b>List of Registered Users</b></h1>
  <table border="1">
                <tr>
                    <th>userId</th>
                    <th>address</th>
                    <th>city</th>
                    <th>country</th>
                    <th>emailID</th>
                     <th>enabled</th>
                     <th>mobileno</th>
                     <th>password</th>
                     <th>zipcode</th>
                     <th>username</th>
                </tr> 
           <c:forEach items="${sessionScope.userl}" var="u">
                    <tr>
                        <td>${u.userId}</td>
                        <td>${u.address}</td>
                        <td>${u.city}</td>
                        <td>${u.country}</td>
                        <td>${u.emailId}</td>
                       <td>${u.enabled}</td>
                       <td>${u.mobileno}</td>
                       <td>${u.password}</td>
                       <td>${u.zipcode}</td>
                       <td>${u.username}</td>
                    </tr> 
                </c:forEach>
            </table>

</body>
</html>