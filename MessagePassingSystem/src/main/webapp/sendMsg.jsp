<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Message</title> 
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Send Message</h2> 
<form action="SendMsgServlet" method="post"> 
<div class="mb-3"> 
<label for="from" class="form-label">From</label> 
<input type="email" class="form-control" id="from" name="from" required> 
</div> 
<div class="mb-3"> 
<label for="to" class="form-label">To</label> 
<input type="email" class="form-control" id="to" name="to" required> 
</div> 
<div class="mb-3"> 
<label for="msg" class="form-label">Message</label> 
<textarea class="form-control" id="msg" name="msg" required>
</textarea> 
</div> 
<button type="submit" class="btn btn-primary">Send</button> 
</form> 
</div>
</body>
</html>