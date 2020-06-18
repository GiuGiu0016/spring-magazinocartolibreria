<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
<div align="center">
	<h2>Search Result</h2>
	<table border="1" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Quantita</th>
			<th>Categoria</th>
		</tr>
		<c:forEach items="${result}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.quantita}</td>
			<td>${p.categoria}</td>
		</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>