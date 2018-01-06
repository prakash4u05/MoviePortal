<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Portal Home</title>
<link rel="stylesheet" type="text/css" href="../resources/css/basestyle.css">
</head>
<body>
<div id="Portalheader"><h2><a href="../home">MovieList Portal</a></h2>
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
<div id="Poratalbody">
<h3>User details:</h3>
<span>User name : ${User.getFirstName()} ${User.getLastName()}</span><br><br>
<span>User email: ${User.getEmailAddr()}</span><br><br>
<span>User Credit card : **** - **** - **** - ${User.getCardNumber().substring(12, 16)}</span>
</div>
<div id="Portalfooter"></div>
</body>
</html>