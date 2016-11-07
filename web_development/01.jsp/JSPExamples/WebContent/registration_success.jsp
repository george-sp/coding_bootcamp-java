<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.Student"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Registration Succeeded</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="css/mystyle.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container theme-showcase" role="main">
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>Registration</h1>
		</div>
		<div class="page-header">
			<h1>Registration Successfully</h1>
		</div>
		<%
			Student student = (Student) request.getAttribute("student");
			if (student == null) {
				request.setAttribute("errormessage", "Bad request");
		%>
		<jsp:forward page="registration_error.jsp" />
		<%
			} else {
		%>

		<div class="alert alert-success" role="alert">
			<ol>
				<li><b>Registration Number:</b> <%=student.getRn()%></li>
				<li><b>Name:</b> <%=student.getName()%></li>
				<li><b>Surname:</b> <%=student.getSurname()%></li>
				<li><b>Username:</b> <%=student.getUsername()%></li>
				<li><b>Password:</b> <%=student.getPassword()%></li>				
			</ol>
		</div>
		<%
			}
		%>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>