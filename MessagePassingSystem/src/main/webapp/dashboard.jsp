<%@ page import="com.demo.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title> 
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Dashboard</h2> 
<% User user = (User) session.getAttribute("user"); 
if (user != null) { 
%> <p>Welcome, <%= user.getFname() %> 
<%= user.getLname() %>!</p> 
<a href="editProfile.jsp" class="btn btn-primary">Edit Profile</a> 
<a href="sendMsg.jsp" class="btn btn-primary">Send Message</a> 
<a href="ViewMessagesServlet" class="btn btn-primary">View Messages</a> 
<a href="LogoutServlet" class="btn btn-danger">Logout</a> <% } else { %> 
<p>Please 
<a href="login.jsp">login</a> to access your dashboard.</p> 
<% } %> </div>
</body>
</html>