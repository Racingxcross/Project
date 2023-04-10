<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
<body>
<a href="index.jsp">home</a>
	<h3>Search</h3>
	<h3>
		<span style="color: green;">${message}</span>
		<span style="color:red;">${message}</span>
	</h3>
	<form action="find" method="get">
		SearchByuserName<input type="text" name="userName" /> <input type="submit"
			value="search">
	</form>
	<form action="find" method="get">
		SearchByemailID<input type="text" name="emailId" /> <input type="submit"
			value="search">
	</form>
	<form action="find" method="get">
		SearchBymobileID<input type="number" name="mobileId" /> <input type="submit"
			value="search">
	</form>
	<div>
		<h4>result</h4>
		
	</div>
</body>
</html>