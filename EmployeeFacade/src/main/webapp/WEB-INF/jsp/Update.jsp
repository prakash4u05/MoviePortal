<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee UI</title>
<link rel="stylesheet" type="text/css" href="/resources/css/basestyle.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
$(document).on('submit', '#empform', function(evt){
    evt.preventDefault();
    //alert("inside put");
    var empId = document.getElementById('empId').value;
	var deptName = document.getElementById('deptName').value;
	var fname = document.getElementById('fname').value;
	var lname = document.getElementById('lname').value;
	var age = document.getElementById('age').value;
	var salary = document.getElementById('salary').value;
	var gender = document.getElementById('gender').value;
	//alert("Inside submit"+empId+" Name "+fname);
	$.ajax({
		  url:"${home}updateEmployees",
		  type:"PUT",
		  data:"{\"empid\":\""+empId+"\",\"fname\":\""+fname+"\",\"department\":\""+deptName+"\",\"gender\":\""+gender+"\",\"lname\":\""+lname+"\",\"age\":\""+age+"\",\"salary\":\""+salary+"\"}",
		  contentType:"application/json;",
		  success:function(data){
			alert("Employee Record Updated");
		  }
	});
});
	$(document).ready(function() {
			$('#empgetform').submit(function(event){
			event.preventDefault();
			var empIdData = document.getElementById('empId1').value;
			
			//alert("value of Emplid"+empIdData);
			$.ajax({
				 
				  url:"${home}getEmployee/"+empIdData,
				  type:"GET",
				  success:function(data,status){					
					  if(data.empid!=null){
						  var table='<form id="empform">';
					  
							 table+='<table border="1">';
							 //table+='<th>EMP Id</th><th>Emp Name</th><th>Department Id</th><th>Gender</th><th>Age</th>';
							 //table+='<tr><td>'+data.empid + '</td><td>'+data.fname + " "+ data.lname+ '</td><td>'+data.department + '</td><td>'+ data.gender + '</td><td>' + data.age+'</td></tr>';							
							 
							 
							table+='<tr><td>Enter employee id:</td><td><input type="text" id="empId" value='+data.empid+' readonly></td></tr>';
							table+='<tr><td>Enter employee first name:</td><td><input type="text" id="fname" value='+data.fname+'></td></tr>';
								table+='<tr><td>Enter employee last name:</td><td><input type="text" id="lname" value='+data.lname+'></td></tr>';
									table+='<tr><td>Select age :</td><td><input type="text" id="age" value='+data.age+'></td></tr>';
										table+='<tr><td>Salary : </td><td><input type="text" id="salary" value='+data.salary+'></td></tr>';
											table+='<tr><td>Department Name:</td><td><input type="text" id="deptName" value='+data.department+'></td></tr>';
												table+='<tr><td>Gender:</td><td><input type="text" id="gender" value='+data.gender+'></td></tr>';
													table+='<tr><td colspan="2"><input type="submit" id="submit" value="Update"></td></tr>';
								table+='</table>';
								table+='</form>';
							 $('#tablediv').html(table);
							 }
							 else
							{$('#tablediv').html('<h3>Employee not found</h3>');}
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
	<h3>Search employee for update :</h3>
<div id="SearchDiv">
		<form id="empgetform">
			Enter Employee Id: <input type="text" id="empId1" required><br><br>
		    <input type="submit" id="submit" value="GO"><br><br>
		</form>
	</div>
	
	<div id="tablediv">
</div>
</div>
<div id="Portalfooter"></div>
</body>
</html>