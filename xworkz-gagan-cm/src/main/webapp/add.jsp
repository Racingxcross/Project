<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xworkz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
				<li class="active"><a href="index.jsp">Home</a></li> <a
				href="SignUp.jsp"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a> <a href="SignIn.jsp"><span
					class="glyphicon glyphicon-log-in"></span> Login</a> <span
				style="color: white;">Welcome:${userName}</span> <img
				src="download?fileName=${dtoPic}" height="50" width="80">
		</div>
	</nav>
</body>
</html>