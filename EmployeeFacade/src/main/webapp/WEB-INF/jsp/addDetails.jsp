<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee UI</title>
<link rel="stylesheet" type="text/css" href="../resources/css/basestyle.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#empform').submit(function(event){
			event.preventDefault();
			var empId = document.getElementById('empId').value;
			var deptName = document.getElementById('deptName').value;
			var fname = document.getElementById('fname').value;
			var lname = document.getElementById('lname').value;
			var age = document.getElementById('age').value;
			var salary = document.getElementById('salary').value;
			var gender = document.getElementById('gender').value;
			alert("Inside submit"+empId+" Name "+fname);
			$.ajax({
				  url:"${home}addEmployees",
				  type:"POST",
				  data:"{\"empid\":\""+empId+"\",\"fname\":\""+fname+"\",\"department\":\""+deptName+"\",\"gender\":\""+gender+"\",\"lname\":\""+lname+"\",\"age\":\""+age+"\",\"salary\":\""+salary+"\"}",
				  contentType:"application/json;",
				  success:function(data){
					alert("Employee Record inserted");
				  }
			});
		});
	});
</script>
</head>
<body>
<div id="Portalheader"><h2><a href="../EmpFacade/index">Home</a></h2>
</div>
<br><br>
<div id="Poratalbody">
<h3>Add employees</h3>
<div id="formdiv">
		<form id="empform">
		<table>
		<tr><td>Enter employee id:</td><td><input type="text" id="empId" required></td></tr>
		<tr><td>Enter employee first name:</td><td><input type="text" id="fname" required></td></tr>
		<tr><td>Enter employee last name:</td><td><input type="text" id="lname" required></td></tr>
		<tr><td>Select age :</td><td><input type="text" id="age" required></td></tr>
		<tr><td>Salary : </td><td><input type="text" id="salary" required></td></tr>
		<tr><td>Department Name:</td><td><input type="text" id="deptName" required></td></tr>
		<tr><td>Gender:</td><td><input type="text" id="gender" required></td></tr>
		<tr><td colspan="1"><input type="submit" id="submit" value="Register">&nbsp<input type="reset" id="reset" value="Clear"></td></tr>
			
		    
		    </table>
		</form>
	</div>
	<div id="tablediv">
</div>
</div>
<div id="Portalfooter"></div>
</body>
</html>