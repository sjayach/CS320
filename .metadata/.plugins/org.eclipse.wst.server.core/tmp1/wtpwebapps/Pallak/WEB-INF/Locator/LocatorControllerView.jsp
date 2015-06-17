<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Display Search</title>
</head>
<body>
<form action="LocatorController" method="post" >
<input type="text" name="search1" />
<input type="submit" name="search" value="search" />
</form>
<table border="1">
<tr>
<th>zip</th><th>city</th>
</tr>
<c:forEach items="${Searchlist}" var="en">
<tr>
<td>${en.zip}</td>
<td>${en.city}</td>
<td><img alt="Map" src="https://maps.googleapis.com/maps/api/staticmap?&zoom=9&size=300x300&maptype=roadmap&markers=${en.latitude},${ en.longitude}"/></td>
</tr>
</c:forEach>
</table>
<a href = "SearchLocator">Search Airport</a>
</body>
</html>