<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify OTP</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container"> 
<h2>Verify OTP</h2> 
<form action="VerifyOtpServlet" method="post"> 
<div class="mb-3"> 
<label for="otp" class="form-label">Enter OTP</label> 
<input type="text" class="form-control" id="otp" name="otp" required> 
</div> 
<input type="hidden" name="email" value="<%= request.getParameter("email") %>"> 
<button type="submit" class="btn btn-primary">Verify</button> 
</form> 
</div>
</body>
</html>