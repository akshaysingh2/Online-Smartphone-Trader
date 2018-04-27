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
<p> Add Product</p>
<form action="addp" method="post">
<input type="text" name="pname" value="pname" required />
<input type="text" name="brand" value="brand" required />
<input type="text" name="price" value="price" required />
<input type="text" name="stock" value="stock" required />
<input type="submit" name="submitproduct" value="submitproduct"/>
</form>
</body>
</html>