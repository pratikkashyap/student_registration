<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
	<%
	HttpSession s = request.getSession(false);
	if(s.getAttribute("email")!=null){
	%>
	<h3>Enter Your Details Here</h3>
	<form action="Save" method="post">
	<pre>
	Name   <input type="text" name="name"/>
	City   <input type="text" name="city"/>
	Email  <input type="email" name="email"/>
	Mobile <input type="text" name="mobile"/>
	
	<input type="submit" value="Save"/>
	</pre>	
	</form>
	
	<%
	if(request.getAttribute("msg")!=null)
	{
		out.println(request.getAttribute("msg"));
	}
	%>
	<%}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response); 
		}
	%>
</body>
</html>