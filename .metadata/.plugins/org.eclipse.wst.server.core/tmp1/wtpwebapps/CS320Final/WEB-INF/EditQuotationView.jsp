<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EditQuotationController" method="post">
Author <input type="text" name="author" value="${editItem.author }"/> <br />
Quotes<input type="text" name="quotes" value="${editItem.quotes}"/> <br />
<input type="hidden" name="id" value="${editItem.id}"><br />
${error}<br/>
<input type="submit" value="Edit">
</form>
</body>
</html>