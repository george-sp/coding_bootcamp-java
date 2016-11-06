<%-- Reads and prints data (parameters name and surname) from an http request.--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>A Simple JSP Example - JSP</title>
<meta http-equiv="Content-Type"
	content="text/html; charset=Windows-1253">
</head>
<body>

	<%--   We need this line in order to pass parameters in greek, we can use UTF-8 charset as well.
      Try to comment out ("//") this line to see the difference.
    --%>
	<%
		request.setCharacterEncoding("ISO-8859-7");
	%>

	<h1>
		<font color="#000066"><strong>"ReadForm.jsp" is
				running...</strong></font>
	</h1>
	<br />

	<%--   Gets the results from the request --%>
	<%
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		if ((name == null) || (surname == null) || !(name.length() > 0) || !(surname.length() > 0)) {
	%>
	<h2>You have not filled in all fields!</h2>
	<%
		} else {
	%>
	<h2>Your filled in fields:</h2>
	<b>Name: </b><%=name%>
	<br>
	<b>Surname: </b><%=surname%>
	<br>
	<%
		}
	%>
</body>
</html>