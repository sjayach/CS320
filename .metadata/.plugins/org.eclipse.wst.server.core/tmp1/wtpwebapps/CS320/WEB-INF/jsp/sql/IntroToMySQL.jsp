<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Intro to MySQL</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<div class="jumbotron">
		<h1>CS320 DB Users</h1>
	</div>
	<form action="IntroToDatabases" method=get>
	Search:
	<input type="text" name="search">
	<input type="submit" value="Search">
	</form>
	
	<c:if test="${empty users}">
		<h3>There are no Users to display.</h3>
	</c:if>
	
	
	<c:forEach items="${users}" var="user">
		<c:choose>
		<c:when test="${(empty param.search) || (param.search == user.first) || (param.search == user.last)}">
		<div class="well">
			<h3>
				<small>Name: </small> ${ user.first } ${ user.last }
			</h3>
			<h3>
				<small>Email: </small>
				<a href="mailto:${user.email}"> 
					${ user.email }
				</a>
			</h3>
			<h3>
				<small>Password (MD5): </small> ${ user.password }
			</h3>
		</div>	
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
	</c:forEach>

</div>
</body>
</html>



