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
					<form action="Admin" method=get>
						<select name="drop">
			 					<option value="1">1</option>
								<option value="2">2</option>
			 					<option value="3">3</option>
			 					<option value="4">4</option>
			 					<option value="5">5</option>
								<option value="6">6</option>
			 					<option value="7">7</option>
			 					<option value="8">8</option>
						</select>
						<input type="hidden" name="item_id" value="${item.id }">
						<input type="submit" value="add" name="add"></input>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>