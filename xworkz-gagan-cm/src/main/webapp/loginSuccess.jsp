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
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
      <a href="SignIn.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
     <span style="color: white;">Welcome:${userName}</span>
       <img src="download?fileName=${dtoPic}" height="50" width="80">
		</div>
	</nav>
		<div align="center">
	   User Name:${userName}
	 <h1 style="color: green;">LOGIN SUCESSFULLY</h1>
	  <a href="profileUpdate.jsp">Update profile</a> <br> 
	  <a href="add.jsp">add</a><br>
	  Search <input type="search"> 
	</div> 
</body>
</html>