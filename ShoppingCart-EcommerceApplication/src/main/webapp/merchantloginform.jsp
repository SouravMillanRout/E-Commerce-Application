<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Login Form</title>
<style><%@include file="style.css"%></style>
</head>
<body><h1 style="color: red">${msg}</h1>
<div class="login-box">
  <h2>Merchant Login Form</h2>
  <form action="validatemerchant" method="post">
    <div class="user-box">
      <input type="email" name="email" required="">
      <label>Enter Email</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required="">
      <label> Enter Password</label>
    </div>
    <a href="#">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <input type="submit" value="submit" >
    </a>
  </form>
</div>
</body>
</html>