<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee list</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/viewCust.css"/>  	
</head>
<body>
<h1 >Employee List</h1>
<table  style=border:1px >
<thead>
   <tr>
   <th>e_id</th>
   <th>e_fname</th>
   <th>e_lname</th>
   <th>e_mobileno</th>
   <th> Edit</th>
   <th>Delete</th>
   </tr>
</thead>
<tbody>
   <c:if test="${emplist!=null }">
				<c:forEach items="${emplist}" var="employee">
				
				<c:url var="updateLink" value="/updateEmp">
					<c:param name="empId" value="${employee.id}"></c:param>
				</c:url>
				
				<c:url var="deleteLink" value ="/deleteEmp">
				     <c:param name="empId" value="${employee.id}"></c:param>				   
				</c:url>
						<tr>
						<td>${employee.id}</td>
						<td>${employee.firstname}</td>
						<td>${employee.lastname}</td>
						<td>${employee.mobileno}</td> 
						<td><a href="${updateLink}">Edit</a>
						</td>
						<td><a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> </td>
					   </tr>			
				</c:forEach>
			</c:if>
</tbody>
</table>
</body>
</html>