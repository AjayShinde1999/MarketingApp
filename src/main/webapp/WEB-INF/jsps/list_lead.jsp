<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead List</title>
</head>
<body>
	<h2>List Of Leads</h2>
	<table border='1'>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mobile Number</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach items="${leads }" var="leads">
			<tr>
				<td>${leads.firstName }</td>
				<td>${leads.lastName }</td>
				<td>${leads.email }</td>
				<td>${leads.mobile }</td>
				<td><a href="delete?id=${leads.id }">delete</a></td>
				<td><a href="update?id=${leads.id }">update</a></td>
			</tr>


		</c:forEach>
	</table>
</body>
</html>