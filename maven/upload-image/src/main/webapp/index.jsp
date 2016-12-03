<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upload Image</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Custom theme -->
<link rel='stylesheet' href='style.css' type='text/css' media='all' />
</head>
<%
	String message = (String) request.getAttribute("message");
	String status = (String) request.getAttribute("status");
	String uploadedFile = (String) request.getAttribute("uploaded");
%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4 panel panel-default">
				<div class="panel-body">
					<form method="POST" action="upload" enctype="multipart/form-data"
						class="form-signup">
						<h2 class="form-signin-heading login-or-signup text-center">Upload
							your image</h2>
						<input type="text" class="form-control"
							placeholder="enter your name" name="name" required autofocus>
						<input type="file" name="image" class="form-control"> <br>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Upload</button>
					</form>
				</div>
			</div>
		</div>
		<%
			if (null != message) {
		%>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<%="<div class='" + status + "'><p>" + message + "</p></div>"%>
			</div>
		</div>
		<%
			if (status.equals("success")) {
		%>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<img alt="User Pic"
					src=<%=request.getContextPath() + "/uploaded_images/" + uploadedFile%>
					class="img-circle img-responsive">
			</div>
		</div>
		<%
			}
			}
		%>
	</div>
</body>
</html>