<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
<style><%@include file="style.css"%></style>
</head>
<body>
<div class="login-box">
  <h2>Product Form</h2>
  <form:form action="saveproduct" modelAttribute="productobj">
    <div class="user-box">
      <form:input path="brand" />
      <label>Enter Brand</label>
    </div>
    <div class="user-box">
      <form:input path="category" />
      <label>Enter Category</label>
    </div>
    <div class="user-box">
      <form:input path="model" />
      <label>Enter Model</label>
    </div><div class="user-box">
      <form:input path="price" />
      <label>Enter Price</label>
    </div><div class="user-box">
      <form:input path="stock" />
      <label>Enter Stock</label>
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