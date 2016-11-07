<%--
/**
 * Prints the login form.
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<%-- 
		Include the "header.jsp" page, passing the parameter "exampleNumber" 
		via jsp:include action.
	--%>
	<jsp:include page="Header.jsp">
		<jsp:param name="exampleNumber" value="1st Example" />
	</jsp:include>

	<div style="height: 500px; text-align: center;">
		<h1>
			<font color="#000066"><strong>"LoginForm.jsp" <small>is
						running...</small></strong></font>
		</h1>
		<br />
		<h2>
			<font color="#000066"><strong>Please enter username
					and password to register in the database:</strong></font>
		</h2>
		<form name="form1" method="post" action="Login">
			<br /> <br />
			<table width="31%" border="0" align="center">
				<tr>
					<td width="35%">
						<div align="right">
							<font size="3" face="Georgia, Times New Roman, Times, serif"><strong>username:</strong></font>
						</div>
					</td>
					<td width="65%"><input name="USER_NAME" type="text"
						id="USER_NAME"></td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<font size="3" face="Georgia, Times New Roman, Times, serif"><strong>password:</strong></font>
						</div>
					</td>
					<td><input name="PASSWORD" type="password" id="PASSWORD">
					</td>
				</tr>
			</table>
			<p>
				<input type="submit" name="Submit" value="Submit for Registration">
				<input type="reset" name="Clear" value="Clear Fields">
			</p>
		</form>
		<h3>Please try the options below!!!</h3>
		<p>
			<strong><font color="#990000"
				face="Georgia, Times New Roman, Times, serif">Username: test
					<br /> Password : 111
			</font></strong>
		</p>
	</div>

	<%-- Include the footer html page "footer.html" --%>
	<%@ include file="footer.html"%>
</body>
</html>