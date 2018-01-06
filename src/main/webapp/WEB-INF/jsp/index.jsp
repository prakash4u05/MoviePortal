<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Portal For Rent</title>
<link rel="stylesheet" type="text/css" href="resources/css/basestyle.css">
</head>
<body>
<div id="Portalheader"><h2>${message} Home</h2>
<% String strname="";
 
 if(!(session==null)){
	System.out.println("inside"+session.getAttributeNames());
   strname= (String)session.getAttribute("uname"); }
 if(strname.equals("")){
%>
<div id="UserOption"><a href="../loginpage">Login</a> / <a href="../register">Register</a></div>
<%}else{  %>
<div id="UserOption"><span>Welcome <a href="../users/<%=strname %>"><%=strname %></a></span><a href="../logout">Logout</a></div>
<%} %>
</div>
<br><br>
<div id="Poratalbody">
<h3>Choose The category</h3>
<a href="../movielist/english">English Movies </a><br><br>
<a href="../movielist/hindi">Hindi Movies</a><br><br>
<a href="../movielist/Anim">Animation Movies</a><br><br>
<a href="../movielist">All Movies</a>

</div>
<div id="Portalfooter"></div>
</body>
</html>