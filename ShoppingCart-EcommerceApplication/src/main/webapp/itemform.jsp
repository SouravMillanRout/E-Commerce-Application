<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>
<style><%@include file="style.css"%></style>

</head>
<body>
<div class="login-box">
  <h2>Item Form</h2>
  <form:form action="additemtocart" modelAttribute="itemobj">
  <form:hidden path="pid" />
    <div class="user-box">
  <form:input path="brand" readonly="true" />
      <label>Brand</label>
    </div>
    <div class="user-box">
      <form:input path="category" readonly="true" />
      <label>Category</label>
    </div>
    <div class="user-box">
      <form:input path="model" readonly="true" />
      <label>Model</label>
    </div><div class="user-box">
      <form:input path="price" readonly="true" />
      <label>Price</label>
    </div><div class="user-box">
      <form:input path="quantity" />
      <label>Quantity</label>
    </div>
    <a href="#">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <input type="submit" value="Submit">
    </a>
  </form:form>
</div>

</body>
</html>