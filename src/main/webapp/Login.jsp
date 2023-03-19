<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body><h2>Enter Login Details</h2>
	
	<form action="verifyLogin" method="post">
	<table>
	<tr><td>Email<td><input type="email" name="email"/></td></tr>
	<tr><td>Password<td><input type="password" name="password"/></td></tr>
	<tr><td><input type="reset"/><td><input type="submit" value="Login"/></td></tr>
	</table>
	</form>
		
	<%
	if(request.getAttribute("error")!=null)
	{
		out.println(request.getAttribute("error"));
	}
	%>
	
</body>
</html>