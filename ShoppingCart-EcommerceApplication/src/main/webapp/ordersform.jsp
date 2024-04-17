<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Form</title>
<style><%@include file="style.css"%></style>

</head>
<body>
<div class="login-box">
  <h2>Order Form</h2>
  <form:form action="saveorder" modelAttribute="ordersobj">
    <div class="user-box">
      <form:input path="name" />
      <label>Enter Name</label>
    </div>
    <div class="user-box">
      <form:input path="mobno" />
      <label>Enter Mobile-no</label>
    </div>
    <div class="user-box">
      <form:input path="address" />
      <label>Enter Address</label>
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