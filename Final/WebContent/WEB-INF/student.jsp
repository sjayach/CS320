<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RequestController" method="post">
	CIN :<input type ="text" name="cin" placeholder="Enter your CIN"> <br/>
	Name: <input type="text" name="name" placeholder="Enter your name"> <br />
	Subject:<input type="text" name="subject" placeholder="Enter your subject here"> <br />
	Message: <textarea rows="4" cols="50" name="message" placeholder="Enter your message here"></textarea><br />
	<input type="submit" name="requestSubmit" value="Submit Request">
</form>


</body>
</html>