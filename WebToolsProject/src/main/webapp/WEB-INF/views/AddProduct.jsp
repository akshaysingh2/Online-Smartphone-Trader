<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<body style="background-color:seashell;">
<h2><b> Add Product<b></h2>
<form action="addp" method="POST">
SmarthPhone Name <input type="text" name="pname" value="" required/><br><br>
SmartPhone Brand <input type="text" name="brand" value="" required /><br><br>
Price <input type="text" name="price" value="" required /><br><br>
Available Stock<input type="text" name="stock" value="" required /><br><br>
<input type="submit" name="submitproduct" value="AddProduct"/>
</form>
</body>
</html>