<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quotation View</title>
</head>
<body>

<a href="AddQuotationController">Add Quotation</a>
<form action="QuotationController" method =get>
<input type="text" name="search"><br />
<input type="submit" value="Search">
</form>
<table border="1">
	<tr>
		<th>Author</th>
		<th>Quotes</th>
		<th></th>
		<th></th>
	</tr>
	
	
	<c:forEach items="${quotation}" var="item">
		<tr>
			<td>${item.author}</td>
			<td>${item.quotes}</td>
			<td><a href="EditQuotationController?edit=${item.id}">Edit</a></td>
			<td><a href="QuotationController?delete=${item.id}">Delete</a></td>
		</tr>
	</c:forEach>	
</table>


</body>
</html>