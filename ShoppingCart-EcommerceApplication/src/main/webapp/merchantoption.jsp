<%@page import="com.jsp.ShoppingCart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Options</title>
<style><%@include file="style.css"%></style>
</head>
<body>
	<h1 style="color: red">${msg}</h1>
	<div class="login-box">
  <h2>Merchant Options</h2>
  <form>
	<%
	Merchant m = (Merchant) session.getAttribute("merchantinfo");
	if (m != null) {
	%>
    <div class="user-box">
      <h1><a href="addproduct">Add Product</a></h1>
    </div>
    <div class="user-box">
      <h1><a href="viewallproduct">View All Product</a></h1>
    </div>
    <%
	} else {
	%>
	<div class="user-box">
      <h1 style="color: white">login first to add and view products</h1>
      <h1><a href="merchantloginform.jsp">Login Here</a></h1>
	<%
	}
	%>
    </div>
    
  </form>
</div>

</body>
</html>