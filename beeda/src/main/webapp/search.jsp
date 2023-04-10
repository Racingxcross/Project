<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xworkz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<a href="index.jsp">home</a>
	<h3>Search</h3>
	<h3>
		<span style="color: green;">${message}</span>
		<span style="color:red;">${message}</span>
	</h3>
	<form action="find" method="get">
		SearchById<input type="text" name="id" /> <input type="submit"
			value="search">
	</form>
	<div>
		<h4>result</h4>
		<h4>StallName:${dto.stallName}</h4>
		<h4>OwnerName:${dto.ownerName}</h4>
		<h4>Type:${dto.type}</h4>
		<h4>Price:${dto.price}</h4>
		<h4>QuantiSty:${dto.quantity}</h4>
	</div>
</body>
</html>