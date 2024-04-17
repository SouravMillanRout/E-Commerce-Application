<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Form</title>
<style><%@include file="style.css"%></style>

</head>
<body>
<div class="login-box">
  <h2>Merchant Form</h2>
	<form:form action="savemerchant" modelAttribute="merchantobj">
    <div class="user-box">
      <form:input path="name" />
      <label>Enter Username</label>
    </div>
    <div class="user-box">
      <form:input path="mobno" />
      <label>Enter Mobno</label>
    </div>
    <div class="user-box">
      <form:input path="email" />
      <label>Enter Email</label>
    </div><div class="user-box">
      <form:input type="password" path="password" />
      <label>Enter Password</label>
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