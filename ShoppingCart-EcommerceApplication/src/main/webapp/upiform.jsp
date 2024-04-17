<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPI Form</title>
<style><%@include file="style.css"%></style>
</head>
<body>
<div class="login-box">
		<h2>Customer Form</h2>
		<form action="customerbilldetails">
			<div class="user-box">
				<input path="name" />
				<label>Enter Username</label>
			</div>
			
			<div class="user-box">
				<input path="mobno" />
				<label>Enter Mobno</label>
			</div>
			<div class="user-box">
				<input path="email" />
				<label>Enter UPI id</label>
			</div>
			<div class="user-box">
				<input type="password" path="password" />
				<label>Enter Password</label>
			</div>
			<a href="#">
			<span></span>
		    <span></span>
		    <span></span>
		    <span></span>
			<input type="submit" value="paynow">
			</a>
		</form>
	</div>
</body>
</html>