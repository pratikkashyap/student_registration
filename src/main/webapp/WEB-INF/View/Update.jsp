<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<form action="Update" method="post">
	Email<input type="email" name="email" value="<%=request.getAttribute("email")%>"/>
	Mobile<input type="tel" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
	<input type="submit" value="Update"/>
	</form>
</body>
</html>