<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>x-workz</title>


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
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
			</a>
		</div>
	</nav>
	<a href="index.jsp">Home</a>
	<div>
		<a href="SignUp.jsp">SignUp as New User</a>
	</div>
	<div align="center">
		<h5 style="color: red">${match}</h5>

		<form action="signin" method="post">
			<table>
				<tr>
					<td>User Name</td>

					<td><input type="text" name="userName" id="userName"
						onchange="ValideName()"> <span id="nameError"
						style="color: red"></span> <span id="displayUserName"
						style="color: red"></span></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="userPassword"
						onblur="ValidePassword()"> <span id="passwordError"
						style="color: red"></span> <input type="checkbox"
						onclick="myFunction()">Show Password</td>
				</tr>


			</table>
			<div>
				<button type="submit" class="btn btn-success">SignIn</button>
			</div>
		</form>
		<a href="resetPassword.jsp">forgot password</a>

	</div>
	<script>
		function ValideName() {
			var user = document.getElementById('user_Name');
			var uservalue = user.value;
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 3
					&& uservalue.length < 30) {
				console.log('valide name');
				document.getElementById('nameError').innerHTML = '';
			} else {
				console.log('invalide name');
				document.getElementById('nameError').innerHTML = 'Plese enter valide name min 4 and max 30 character';
			}
		}
		function myFunction() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>