<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee UI</title>
<link rel="stylesheet" type="text/css" href="resources/css/basestyle.css">
<script>
	$(document).ready(function() {
		$('#empform').submit(function(event){
			event.preventDefault();
			var empId = document.getElementById('empId').value;
			var deptName = document.getElementById('deptName').value;
			var fname = document.getElementById('fname').value;
			$.ajax({
				  url:"http://localhost:8080/SpringMongoREST/employees",
				  type:"POST",
				  data:"{\"empid\":\""+empId+"\",\"fname\":\""+fname+"\",\"department\":\""+deptName+"\"}",
				  contentType:"application/json;",
				  success:function(data){
					alert(data);
				  }
			});
		});
	});
</script>
</head>
<body>
<div id="Portalheader"><h2>Home</h2>
</div>
<br><br>
<div id="Poratalbody">
<h3>Add employees</h3>
<div id="formdiv">
		<form id="empform">
			Enter employee id:<input type="text"id="empId"><br>
			Enter employee first name:<input type="text" id="fname"><br>
			Enter employee last name:<input type="text" id="lname"><br>
			Select age :<input type="text" id="age"><br>
			Salary : <input type="text" id="salary"><br>
		    Department Name:<input type="text" id="deptName"><br> 
		    Gender:<input type="text" id="gender"><br> 
		    <input type="submit" id="submit" value="GO">
		</form>
	</div>
</div>
<div id="Portalfooter"></div>
</body>
</html>