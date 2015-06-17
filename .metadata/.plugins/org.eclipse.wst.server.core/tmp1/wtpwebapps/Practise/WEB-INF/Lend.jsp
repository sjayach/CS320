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

Type : ${lend.types} <br />
Name : ${lend.namemedia}<br />

<form action="LendPage" method="post">
	Enter the borrower Name: <input type="text" name="bname">
	<input type="submit" value="Lend">
	<input type = "hidden" name="hiddenid" value="${lend.id}">
</form> 

</body>
</html>