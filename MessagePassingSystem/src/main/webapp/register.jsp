<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title> 
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Register</h2> 
<form action="RegisterServlet" method="post"> 
<div class="mb-3"> 
<label for="fname" class="form-label">First Name</label> 
<input type="text" class="form-control" id="fname" name="fname" required> 
</div> 
<div class="mb-3"> 
<label for="lname" class="form-label">Last Name</label> 
<input type="text" class="form-control" id="lname" name="lname" required> 
</div> 
<div class="mb-3"> 
<label for="email" class="form-label">Email</label> 
<input type="email" class="form-control" id="email" name="email" required> 
</div> 
<div class="mb-3"> 
<label for="mobile" class="form-label">Mobile</label> 
<input type="text" class="form-control" id="mobile" name="mobile" required> 
</div> 
<button type="submit" class="btn btn-primary">Register</button> 
</form> 
</div>
</body>
</html>