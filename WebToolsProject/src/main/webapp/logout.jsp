<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout Page</title>
</head>
<body>
<h3>Hello: <c:out value="${sessionScope.user.username}"/> </h3><br>
	
 	<h3>EmailID: <c:out value="${sessionScope.user.emailId}"/></h3>
 	<form method="POST" action="${pageContext.request.contextPath}/user/logout">
 	<input type="submit" value="submitl" name="submitl"/>
 	</form>


</body>
</html>