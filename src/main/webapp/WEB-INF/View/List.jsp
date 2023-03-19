<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
<%
	HttpSession s = request.getSession(false);
	if(s.getAttribute("email")!=null){
%>
	<h2>All Registrations</h2>
	
	<table border = '1'>
	<tr>
	<th>NAME</th>
	<th>CITY</th>
	<th>EMAIL</th>
	<th>MOBILE</th>
	<th>DELETE</th>
	<th>UPDATE</th>
	</tr>
	
	<%
		ResultSet result = (ResultSet)request.getAttribute("result");
		while(result.next()) {
	%>
	<tr>	
		<td><%=result.getString(1) %></td>
		<td><%=result.getString(2) %></td>
		<td><%=result.getString(3) %></td>
		<td><%=result.getString(4) %></td>
		<td><a href="Delete?email=<%=result.getString(3)%>">Delete</a></td>
		<td><a href="Update?email=<%=result.getString(3)%> &mobile=<%=result.getString(4)%>">Update</a></td>
	</tr>
	
	<%}%>
	
	</table>
	<%}else {
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		
	} %>
</body>
</html>