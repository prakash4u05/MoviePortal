<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Portal Home</title>
<link rel="stylesheet" type="text/css" href="../resources/css/basestyle.css">
</head>
<body>
<div id="Portalheader"><h2>MovieList Portal Home</h2>

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
<a href="../home"> Go to Home</a>
<h3>Choose The Movie for Rent :</h3>   
<%if(!strname.equals("")) {%>
					<span>30% discount for registered Users</span>
					
				<%}%>

<c:if test="${not empty Listmap}">

		<ul>
			<c:forEach var="listValue" items="${Listmap}">
			<form action="../Rent/${listValue.get("movieTitle")}" method="post">
				<li><a href="../Movies/${listValue.get("movieTitle")}">${listValue.get("movieTitle")}</a></li>
				
				<%if(strname.equals("")) {%>
					<span>Price - ${listValue.get("moviePrice")}</span>
					
				<%}else{%>
				<span>Price - <s>&#8377;${listValue.get("moviePrice")}</s></span><span>  Discounted Price - &#8377; ${listValue.get("moviePrice")*0.7}</span> 
				<% }%>
				<input type="submit" value="Rent">
				</form>
			</c:forEach>
			
		</ul>

	</c:if>
	

<!--<a href="">${Listmap[0].get("movieTitle")} </a><span>${Listmap[0].get("moviePrice")}</span><br><br>
<a href="">${Listmap[1].get("movieTitle")} </a><span>${Listmap[1].get("moviePrice")}</span><br><br>
<a href="">${Listmap[2].get("movieTitle")} </a><span>${Listmap[2].get("moviePrice")}</span><br><br>
 <a href="">${Listmap[3].get("movieTitle")} </a><span>${Listmap[3].get("moviePrice")}</span><br><br> -->



</div>
<div id="Portalfooter"></div>
</body>
</html>