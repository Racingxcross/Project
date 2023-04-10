<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Register your order Here</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
      </ul>
      <span class="navbar-text">
        Navbar text with an inline element
      </span>
    </div>
  </div>
</nav><br>

<form action="cm" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter hotel Name</label>
    <input type="text" name="cmname" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We help you to get good food.</div>
  </div><br>
  
  <label for="exampleInputEmail1" class="form-label">Select the dish</label>
  <div>
  <select class="form-select" name="dname" aria-label="Default select example">
  <option selected>Open this select menu</option>
  <option value="pepper">pepper</option>
  <option value="masala">masala</option>
  <option value="dry egg">dry egg</option>
   <option value="eggpuff">eggpuff</option>
    <option value="halfboil">halfboil</option>
     <option value="omlet">omlet</option>
</select></div><br>
  <div>
   take food  :    yes<input type="radio" name="take" value="true" />
		no<input type="radio" name="take" value="false"  /></div><br>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">price</label>
    <input type="text" class="form-control" name="price" id="exampleInputPassword1">
  </div>
 
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">area</label>
    <input type="text" class="form-control" name="area" id="exampleInputPassword1">
  </div>
 
  <input type="submit" class="btn btn-primary" value="order">
</form>
</body>
</html>