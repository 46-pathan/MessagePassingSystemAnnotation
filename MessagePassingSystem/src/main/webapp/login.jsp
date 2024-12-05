<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title> 
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Login</h2> 
<form action="LoginServlet" method="post"> 
<div class="mb-3"> 
<label for="email" class="form-label">Email</label> 
<input type="email" class="form-control" id="email" name="email" required> 
</div> 
<button type="submit" class="btn btn-primary">Login</button> 
</form> 
</div>
</body>
</html>