<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addCust.css"> 
<script type="text/javascript">

 function validate()
{
    //alert("hello");
	
	document.getElementById('ierror').innerHTML="";
	document.getElementById('ferror').innerHTML="";
	document.getElementById('lerror').innerHTML="";
	document.getElementById('merror').innerHtml="";
	
	var id = document.getElementById('id').value;
	var fname = document.getElementById('firstname').value;
	var lname = document.getElementById('lastname').value;
	var mobileno = document.getElementById('mobileno').value;
	
	if(id=='')
	{
	 document.getElementById('ierror').innerHTML="Please Enter Id.";
	 return false;
	}
	
	if(fname=='')
	{
	 document.getElementById('ferror').innerHTML="Please Enter First Name.";
	 return false;
	}
	
	if(lname=='')
	{
	  document.getElementById('lerror').innerHTML="please Enter Last Name.";
	  return false;
	}
	
	if(mobileno=='')
	{
	  document.getElementById('merror').innerHTML="please Enter Contact No.";
	  return false;
	}
	
}
function lettersValidate(key) 
{
	  // alert("hello 1");
	    
	    var keycode = (key.which) ? key.which : key.keyCode;
	
	    if ((keycode > 64 && keycode < 91) || (keycode > 96 && keycode < 123))  
	    {     
	           return true;    
	    }
	    else
	    {
	        return false;
	    }
} 
function isNumber1(evt) 
{
	       // alert("hello 1");
	        
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) 
		    {
		        return false;
		    }
		    else
		    {
		        return true;
		    }   
} 
</script>

</head>
<body>
<form:form  action="addEMPDATA" modelAttribute="employee" onsubmit="return validate()">
<form:hidden path="id"/>
	    <div  align="center">
		      <h1>Registration Form</h1>
			  <table style="colspan:3"  >
                
                <tr>
					 <td>Id</td>
					 <td>
					 <form:input path="id" type="text" name="id" placeholder="Enter id" id="id" onkeypress="return isNumber(evt)"/>
					 <span style="color: red;" id="ierror"></span>
					 </td>
				</tr>
               
				<tr>
					 <td>First Name</td>
					 <td>
					 <form:input path="firstname"  type="text" name="firstname" placeholder="Enter FirstName" id="firstname" onkeypress="return lettersValidate(event)"/>
					 <span style="color: red;" id="ferror"></span>
					 </td>
				</tr>
         
				<tr>	
					 <td>Last Name</td>
					 <td>
					 <form:input path="lastname" type="text" name="lastname" placeholder="Enter LastName" id="lastname" onkeypress="return lettersValidate(event)"/>
					  <span style="color: red;" id="lerror"></span>
					 </td>
				</tr>

                <tr>
					<td>Mobile No</td>
					<td>
					<form:input path="mobileno" type="number" name="mobileno" maxlength="10" placeholder="Enter Contact No" id="mobileno" onkeypress="return isNumber1(evt)"/>
					 <span style="color: red;" id="merror"></span>
					</td>
				</tr>
			
				<tr>
				    <td>
				    <input type="submit" value="submit">
				    </td>
				    
				     <td>
				    <input type="reset" value="reset">
				    </td>
				</tr>
		</table>	
		</div>
</form:form>
</body>
</html>