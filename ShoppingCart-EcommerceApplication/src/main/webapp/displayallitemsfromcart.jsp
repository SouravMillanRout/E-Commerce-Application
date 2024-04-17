<%@page import="java.util.List"%>
<%@page import="com.jsp.ShoppingCart.dto.Item"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Items From Cart</title>
<style><%@include file="style.css"%></style>

</head>
<body>
<%
	List<Item> items = (List<Item>) request.getAttribute("itemslist");
    double totalprice=(Double)request.getAttribute("totalprice");
	%>
	<table cellpadding="20px" border="1">
		<tr bgcolor="white" >
			<th>brand</th>
			<th>category</th>
			<th>model</th>
			<th>quantity</th>
			<th>price</th>
		</tr>
		<%
		for (Item i : items) {
		%>
		<tr bgcolor="white">
			<td><%=i.getBrand()%></td>
			<td><%=i.getCategory()%></td>
			<td><%=i.getModel()%></td>
			<td><%=i.getQuantity() %></td>
			<td><%=i.getPrice()%></td>
			
		</tr>
		<%
		}
		%>
	</table>
	       <h1 style="color:white">Total price:<%=totalprice %></h1>
	       
	       <br>
	       <%
		if(totalprice<=0)
		{
		%>
				<h1><a href="fetchallproduct">Display All Product</a></h1>
	<%
		}else{
		%>
						<h1><a href="addorder">Buy Now</a></h1>
		
		<%
		}
		%>
</body>
</html>