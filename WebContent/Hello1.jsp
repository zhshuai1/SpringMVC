<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
taglib:
<c:choose>
	<c:when test="${requestScope.hello eq 'world'}" >hello</c:when>
</c:choose><br>
expression:<%=request.getAttribute("hello") %><br>
EL:${requestScope.hello}<br>
	This is hello1.
	<% out.print("<h1>Bye</h1>"); %>
	<form method="post">
		<input name="${'hello'}" value="${hello}">
		<button type="submit">提交</button>
	</form>
</body>
</html>