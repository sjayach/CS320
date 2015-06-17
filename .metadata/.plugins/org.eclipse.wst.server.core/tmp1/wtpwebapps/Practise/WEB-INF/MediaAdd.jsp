<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddMedia" method="post">
Name/Title:<input type ="text" name="title"><br />
<select name="mediatype">
<option value="CD">CD</option>
<option value="DVD">DVD</option>
<option value ="BlueRay">BlueRay</option>
</select>
<br /><input type="submit" value="Add">
</form>

</body>
</html>