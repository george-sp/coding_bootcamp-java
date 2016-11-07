<%-- 
/**
 * Prints current date and time. 
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--   Import necessary libs --%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PrintDate.jsp</title>
<link rel="stylesheet" href="css/print_date_style.css" type="text/css" />
</head>
<body>
	<div id="page">
		<p>
			<img src="images/aueb_logo.jpg" alt="aueb_logo">
		</p>
		<h1>Athens University of Economics and Business</h1>
		<p>
			<strong>Date & Time:</strong> <i><%=getCurrentDate()%></i>
		</p>
	</div>
</body>
</html>

<%!/**
		 * This method returns current date in String.
		 *
		 * @return String.
		 */
	public String getCurrentDate() {
		Date now = new Date();
		String date_formatted = "EEEE, d MMM yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(date_formatted);
		return simpleDateFormat.format(now);
	}%>