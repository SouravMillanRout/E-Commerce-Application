<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Products</title>
<style><%@include file="style.css"%></style>
</head>
<body>
	<%
	List<Product> product = (List<Product>) request.getAttribute("productlist");
	%>
	<h1><a href="viewitemsfromcart">View Cart</a></h1>
	<table cellpadding="20px" border="1">
		<tr bgcolor="white" >
			<th>brand</th>
			<th>category</th>
			<th>model</th>
			<th>price</th>
			<th>add</th>
		</tr>
		<%
		for (Product p : product) {
		%>
		<tr bgcolor="white">
			<td><%=p.getBrand()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getModel()%></td>
			<td><%=p.getPrice()%></td>
			<td><a href="additem?id=<%=p.getId()%>">Add To Cart</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>