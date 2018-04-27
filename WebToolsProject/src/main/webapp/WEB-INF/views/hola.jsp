<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<table class="table table-hover" id="productList">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total Price</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="cart in carts.cartItem">
							<td>{{cart.product.productName}}</td>
							<td>{{cart.quality}}</td>
							<td>{{cart.product.productPrice}}</td>
							<td>{{cart.price}}</td>
							<td><a href="#" class="btn btn-danger"
								ng-click="removeFromCart(cart.cartItemId)"
								style="margin-top: 0px;"><span
									class="glyphicon glyphicon-trash"></span>remove</a></td>
					</tbody>
				</table>
	
</body>
</html>