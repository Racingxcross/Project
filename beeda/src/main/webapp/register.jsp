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
				<a href="index.jsp">home</a><br>
				
				

			</div>

		</nav>
		<h1>welcome to beeda registering</h1>
		<pre>
	<c:forEach items="${errors}" var="e">
		<span style="color: red;">${e.message}</span>
	</c:forEach>
</pre>
	<form action="eat" method="post">
		<pre>
		stallName<input type="text" name="stallName" required="required"/>
		ownerName<input type="text" name="ownerName" required="required"/>
		price<input type="number" name="price" required="required"/>
		Type<select name="type" required="required">
		<option value="">select</option>
		<c:forEach items="${type}" var="t">
		<option value="${t}">${t}</option>
		</c:forEach>
		</select>
		quantity<input type="text" name="quantity" required="required"/>
		<input type="submit" value="save"/>
		</pre>
	</form>

	

</body>
</html>