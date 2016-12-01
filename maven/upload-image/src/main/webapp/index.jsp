<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
</head>
<body>
	<br>
	<div class="col-sm-4 col-sm-offset-4 panel panel-default">
		<div class="panel-body">
			<form class="form-signin" method="POST" action="login_simple"
				enctype="multipart/form-data" class="form-signup">
				<h2 class="form-signin-heading login-or-signup text-center">Upload
					your image</h2>
				<input type="text" class="form-control"
					placeholder="enter your name" name="name" required autofocus>
				<input type="file" name="image" class="form-control"> <br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Upload</button>
			</form>
		</div>
	</div>
</body>
</html>