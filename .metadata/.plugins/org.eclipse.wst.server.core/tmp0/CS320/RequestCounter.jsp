<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean class="cs320.counter.counter" id ="ct"  scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Counter jsp</title>
</head>
<body>

 
<jsp:setProperty name="ct" property="c" value="1" />
<jsp:getProperty name="ct" property="c" />

</body>
</html>