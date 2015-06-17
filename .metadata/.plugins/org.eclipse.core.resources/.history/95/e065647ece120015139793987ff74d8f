<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SearchLocator" method="post" >
Zip code<input type="text" name="search2" />
Radius <input type="text" name="radius" />

<input type="submit" name="searchAirport" value="search" />
</form>
<table border="1">
<tr>
<th>Airport</th><th>
</tr>
<c:forEach items="${Airportlist}" var="en">
<tr>
<td>${en.airport}</td>
<td><img alt="Map" src="https://maps.googleapis.com/maps/api/staticmap?&zoom=9&size=300x300&maptype=roadmap&markers=${en.latitude},${ en.longitude}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>