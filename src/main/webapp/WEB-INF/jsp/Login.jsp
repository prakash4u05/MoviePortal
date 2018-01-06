<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registered User Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/basestyle.css">
</head>
<body>
<div id="Portalheader"><h2 align="center"><a href="../home">Movie Portal Home</a></h2></div>
<br><br>
<div id="Poratalbody">
<h3> User Login</h3>
<form action="../login" method="POST">

  <div class="container">
    <label><b>Useremail</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <button type="submit">Login</button>
 
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <span class="psw"><a href="#">Forgot password?</a></span>
  </div>
</form>


</div>
<div id="Portalfooter"></div>
</body>
</html>