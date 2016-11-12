<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.afdemp.bootcamp.sofos.dao.StudentDAO"%>
<%@ page import="org.afdemp.bootcamp.sofos.domain.Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Student registration page">
<meta name="author" content="sofos@aueb.gr">
<title>Student Registration: register.html</title>
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
	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="register.jsp">LESSON 2</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="register.jsp">Register</a></li>
					<li class="active"><a href="viewstudents.jsp">View</a></li>
					<li><a href="findstudent.jsp">Find</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>LESSON 2</h1>
		</div>

		<div class="page-header">
			<h1>Προβολή Φοιτητών</h1>
		</div>

		<%!StudentDAO studentDAO = new StudentDAO();%>

		<table class="table table-bordered table-contest table-hover">
			<tr style="background-color: #e2c072">
				<td>Αρ. Μητρώου</td>
				<td>Όνομα</td>
				<td>Επώνυμο</td>
			</tr>

			<%
				Student stud;
				try {
					studentDAO.open();
					stud = studentDAO.findStudentByAM(request.getParameter("studentam"));

					if (stud != null) {
			%>
			<tr>
				<td><%= stud.getAm()%></td>
				<td><%= stud.getName()%></td>
				<td><%= stud.getSurname()%></td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td colspan="3">Δεν βρέθηκε κάποια καταχώρηση!</td>
			</tr>
			<%
				}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					studentDAO.close();
				}
			%>
		</table>

			</div>
			<!-- /container -->

			<!-- footer -->
			<footer class="navbar-inverse">
				<div class="container">
					<div class="row">
						<div class="col-xs-12">
							<p class="text-center">&copy; Copyright 2016 by "το
								Ονοματεπώνυμο σας"</p>
						</div>
					</div>
				</div>
			</footer>
			<!-- End footer -->

			<!-- Bootstrap core JavaScript
    ================================================== -->
			<!-- Placed at the end of the document so the pages load faster -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
