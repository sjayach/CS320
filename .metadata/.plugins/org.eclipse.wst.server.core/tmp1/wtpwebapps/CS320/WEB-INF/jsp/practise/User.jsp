<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="User" method=get>
	<table border = "1">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>Quantity</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${Items}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.description} </td>
				<td>${item.quantity} </td>
				<td>${item.price} </td>
				<td>
					<input type="checkbox" name="pick" value="${item.id}">
				</td>
			</tr>
		</c:forEach>
	</table>

	<input type="submit" value="add" name="add_cart"></input>
	</form>
	${MoreItems}
</body>
</html>