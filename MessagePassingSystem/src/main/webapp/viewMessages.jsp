<%@ page import="java.util.List" %>
<%@ page import="com.demo.model.Message" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Messages</title> 
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Received Messages</h2> 
<% List<Message> messages = (List<Message>) request.getAttribute("messages"); 
if (messages != null && !messages.isEmpty()) { %> 
<table class="table table-striped"> 
<thead> 
<tr> <th>From</th> 
<th>Message</th> </tr>
 </thead> 
 <tbody> <% for (Message message : messages) { %> 
 <tr> <td><%= message.getFrom() %></td> 
 <td><%= message.getMsg() %></td> </tr> 
 <% } %> </tbody> </table> <% } else { %> 
 <p>No messages received.</p> 
 <% } %>
  <a href="dashboard.jsp" class="btn btn-primary">Back to Dashboard</a> 
  </div>
</body>
</html>