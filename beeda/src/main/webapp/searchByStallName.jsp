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
	
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<div class="container-fluid">
				<nav class="navbar navbar-light bg-light">
					<div class="container">
						<a class="navbar-brand" href="#"> <img
							src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
							alt="" width="88" height="48">
						</a>
					</div>
					
				</nav>

<div>
<h3>Search</h3>
	<h3>
		<span style="color: red;">${message}</span>
		<span style="color:red;">${message}</span>
	</h3>
	<form action="pan" method="get">
		SearchByStallName<input type="text" name="stallName" /> <input type="submit"
			value="search">
	</form>
	<div>
	<br>
	<table>
	<tr>
		<th class="bg-primary">ID</th>
<th class="bg-success">StallName</th>
<th class="bg-warning">ownerName</th>
<th class="bg-danger">Type</th>
<th class="bg-info">Price</th>
<th class="bg-info">quantity</th>
<th class="bg-info">Edit</th>
<th class="bg-info">delete</th>
</tr>
		<c:forEach items="${list}" var="t">
			<tr>
  <td class="bg-primary">${t.id}</td>
  <td class="bg-success">${t.stallName}</td>
  <td class="bg-warning">${t.ownerName}</td>
  <td class="bg-danger">${t.type}</td>
  <td class="bg-info">${t.price}</td>
  <td class="bg-info">${t.quantity}</td>
  <td><a href="update?id=${t.id}">Edit</a></td>
   <td><a href="delete?id=${t.id}">delete</a></td>
  
</tr>
		</c:forEach>

	</table>
	</div>

</body>
</html>