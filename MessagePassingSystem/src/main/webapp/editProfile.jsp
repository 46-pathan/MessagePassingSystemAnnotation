<%@ page import="com.demo.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title> 
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Edit Profile</h2> 
<% User user = (User) session.getAttribute("user"); 
if (user != null) {
	%> <form action="EditProfileServlet" method="post"> 
	<input type="hidden" name="uid" value="<%= user.getUid() %>"> 
	<div class="mb-3"> 
	<label for="fname" class="form-label">First Name</label> 
	<input type="text" class="form-control" id="fname" name="fname" value="<%= user.getFname() %>" required> 
	</div> 
	<div class="mb-3"> 
	<label for="lname" class="form-label">Last Name</label> 
	<input type="text" class="form-control" id="lname" name="lname" value="<%= user.getLname() %>" required> 
	</div> 
	<div class="mb-3"> 
	<label for="email" class="form-label">Email</label> 
	<input type="email" class="form-control" id="email" name="email" value="<%= user.getEmail() %>" required> 
	</div> 
	<div class="mb-3"> 
	<label for="mobile" class="form-label">Mobile</label> 
	<input type="text" class="form-control" id="mobile" name="mobile" value="<%= user.getMobile() %>" required> 
	</div> 
	<button type="submit" class="btn btn-primary">Update</button> 
	</form> <% } else { %> 
	<p>Please <a href="login.jsp">login</a> to edit your profile.</p> 
	<% } %> 
	</div>
</body>
</html>