<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></h1>iew All Product Merchant</title>
<style><%@include file="style.css"%></style>
</head>
<body>
	<%
	List<Product> product = (List<Product>) request.getAttribute("productlist");
	%>
	<table cellpadding="20px" border="1">
		<tr bgcolor="white">
			<th>id</th>
			<th>brand</th>
			<th>category</th>
			<th>model</th>
			<th>price</th>
			<th>stock</th>
		</tr>
		<%
		for (Product p : product) {
		%>
		<tr bgcolor="white">
			<td><%=p.getId()%></td>
			<td><%=p.getBrand()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getModel()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getStock()%></td>
			<td><a href="update?id=<%=p.getId()%>">Update</a></td>
			<td><a href="delete?id=<%=p.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
		<h1><a href="addproduct">Add Product</a></h1>
	</table>

</body>
</html>