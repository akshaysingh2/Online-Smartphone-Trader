<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>

</head>
<body>
<h1><b>Register User Page</b></h1>
<body style="background-color:lavender;">
<form:form commandName="user" action="user/add" method="POST">
                <p><b>Enter UserName </b><form:input path="username"/><form:errors path="username"/></p>
                <p><b>Enter EmailId </b><form:input path="emailId"/><form:errors path="emailId"/></p>
                <p><b>Enter Password <form:input type="password" path="password" /><form:errors path="password"/></p>
                
                <p><b>Enter City </b><form:input path="city"/><form:errors path="city"/></p>
                <p><b>Enter Address </b><form:input path="address"/><form:errors path="address"/></p>
                <p><b>Enter ZipCode </b><form:input path="zipcode"/><form:errors path="zipcode"/></p>
                <p><b>Enter Country </b><form:input path="country"/><form:errors path="country"/></p>  
                <p><b>Enter Mobile Number <form:input path="mobileno"/><form:errors path="mobileno"/></p>
                
                           
                <input type="submit" class="btn btn-info" value="Register">
        
            </form:form>
		<!-- Validating Password -->
	

</body>
</html>