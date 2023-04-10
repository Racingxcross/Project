<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>x-workz</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> </a><img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
			<li class="active"><a href="index.jsp">Home</a></li> <a
				href="SignUp.jsp"><span class="glyphicon glyphicon-user"></span>
				Sign Up</a> <a href="SignIn.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Login</a>
		</div>
	</nav>
	<h1><div align="center">User Name:${userName}</div></h1>

	<h1 style="color: green;">LOGIN SUCESSFULLY</h1>
</body>
</html>