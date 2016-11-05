<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Colored</title>
</head>
<body>
	<h1 style="color: <%= request.getParameter("color") %>;">Hello, <%= request.getParameter("color") %> World!</h1>
</body>
</html>