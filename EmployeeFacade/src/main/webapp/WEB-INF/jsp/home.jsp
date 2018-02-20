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
		$('#empgetform').submit(function(event){
			event.preventDefault();
			var empIdData = document.getElementById('empId1').value;
			var searchradio = $('input[name=search]:checked').val();
			alert("value of radio button"+empIdData +searchradio);
			if(searchradio=="dept"){
			$.ajax({
				 // url:"http://localhost:8888/SpringMongoREST/Employees/"+empIdData,
				  url:"http://localhost:8888/SpringMongoREST/Employees/dept/"+empIdData,
					
				  type:"GET",
				  success:function(data,status){
					  
					  var table='<table border="1">';
					  table+='<th>EMP Id</th><th>Emp Name</th><th>Department Id</th><th>Gender</th><th>Age</th>';
					  $.each(data,function(i,value){
						  table+='<tr><td>'+value.empid + '</td><td>'+value.fname + " "+ value.lname+ '</td><td>'+value.department + '</td><td>'+ value.gender + '</td><td>' + value.age+'</td></tr>';		
						//  table+='<tr><td>'+data.empid + '</td><td>'+data.fname + " "+ data.lname+ '</td><td>'+data.department + '</td><td>'+ data.gender + '</td><td>' + data.age+'</td></tr>';	
					  });
					  table+='</table>';
					  
					  $('#tablediv').html(table);
					  
				  }
				
			});}
			if(searchradio=="name"){
				$.ajax({
					 // url:"http://localhost:8888/SpringMongoREST/Employees/"+empIdData,
					  url:"http://localhost:8888/SpringMongoREST/Employees/name/"+empIdData,

					  type:"GET",
					  success:function(data,status){
						  
						  var table='<table border="1">';
						  table+='<th>EMP Id</th><th>Emp Name</th><th>Department Id</th><th>Gender</th><th>Age</th>';
						  $.each(data,function(i,value){
							  table+='<tr><td>'+value.empid + '</td><td>'+value.fname + " "+ value.lname+ '</td><td>'+value.department + '</td><td>'+ value.gender + '</td><td>' + value.age+'</td></tr>';		
							//  table+='<tr><td>'+data.empid + '</td><td>'+data.fname + " "+ data.lname+ '</td><td>'+data.department + '</td><td>'+ data.gender + '</td><td>' + data.age+'</td></tr>';	
						  });
						  table+='</table>';
						  
						  $('#tablediv').html(table);
						  
					  }
					
				});}
			else
				{
				$.ajax({
					 
					url:"http://localhost:8888/SpringMongoREST/Employees/"+empIdData,
					type:"GET",				
					success:function(data,status){
						
						 if(data.empid!=null){
						 var table='<table border="1">';
						 table+='<th>EMP Id</th><th>Emp Name</th><th>Department Id</th><th>Gender</th><th>Age</th>';
						 table+='<tr><td>'+data.empid + '</td><td>'+data.fname + " "+ data.lname+ '</td><td>'+data.department + '</td><td>'+ data.gender + '</td><td>' + data.age+'</td></tr>';							
						 table+='</table>';
						 $('#tablediv').html(table);
						 }
						 else
						{$('#tablediv').html('<h3>Employee not found</h3>');}

					}
						
					});
				}
		});
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
				  url:"http://localhost:8888/SpringMongoREST/Employees",
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
<div id="Portalheader"><h2>Home</h2>
</div>
<br><br>
<div id="Poratalbody">
<h3>Add employees</h3>
<div id="formdiv">
		<form id="empform">
			Enter employee id:<input type="text" id="empId" required><br>
			Enter employee first name:<input type="text" id="fname" required><br>
			Enter employee last name:<input type="text" id="lname" required><br>
			Select age :<input type="text" id="age" required><br>
			Salary : <input type="text" id="salary" required><br> 
		    Department Name:<input type="text" id="deptName" required><br> 
		     Gender:<input type="text" id="gender" required><br> 
		    <input type="submit" id="submit" value="GO">
		</form>
	</div>
	<h3>Search employee Details :</h3>
<div id="SearchDiv">
		<form id="empgetform">
		    Select Search type:<input type="radio" name="search" value="Id" checked> EmpID
  <input type="radio" name="search" value="name"> Emp Name
  <input type="radio" name="search" value="dept"> Emp Department  <br><br>
			Enter employee id:<input type="text" id="empId1"><br><br>
		    <input type="submit" id="submit" value="GO"><br><br>
		</form>
	</div>
	
	<div id="tablediv">
</div>
</div>
<div id="Portalfooter"></div>
</body>
</html>