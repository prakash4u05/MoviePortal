<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Portal Home</title>
<link rel="stylesheet" type="text/css" href="resources/css/basestyle.css">
</head>
<body>
<div id="Portalheader"><h2>MovieList Portal Home</h2>

<div id="UserOption"><a href="../loginpage">Login</a> / <a href="../register">Register</a></div>
</div>
<br><br>
<div id="Poratalbody">
<a href="../home"> Go to Home</a>
<h3> Movie Details </h3>   
<!--<c:if test="${not empty Listmap}">

		<ul>
			<c:forEach var="listValue" items="${Listmap}">
				<li>${listValue.get("movieTitle")}</li>
				<span>Price - ${listValue.get("moviePrice")}</span>
				<a href=""> Rent</a>
			</c:forEach>
		</ul>

	</c:if>

<a href="">${Listmap[0].get("movieTitle")} </a><span>${Listmap[0].get("moviePrice")}</span><br><br>
<a href="">${Listmap[1].get("movieTitle")} </a><span>${Listmap[1].get("moviePrice")}</span><br><br>
<a href="">${Listmap[2].get("movieTitle")} </a><span>${Listmap[2].get("moviePrice")}</span><br><br>
 <a href="">${Listmap[3].get("movieTitle")} </a><span>${Listmap[3].get("moviePrice")}</span><br><br> -->



</div>
<div id="Portalfooter"></div>
</body>
</html>