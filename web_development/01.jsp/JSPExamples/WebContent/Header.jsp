<%--
/**
 * A header to be included in top of jsp pages.
 *
 * Gets and prints "exampleNumber" parameter from request.
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table style="width: 80%; border: 0; margin-left: auto; margin-right: auto;">
	<tr>
		<td width="9%" align="center"><img src="images/det_logo_70.jpg">
		</td>
		<td width="91%" bgcolor="#FFFFCA" align="center"><font size="6"
			face="Verdana, Arial, Helvetica, sans-serif">Examples on <strong>JSP</strong>
		</font></td>
	</tr>
</table>
<p align="center">
	<font color="#000033" size="4"
		face="Verdana, Arial, Helvetica, sans-serif"> 
		
		<%-- Gets & Prints the parameter "exampleNumber" from the request --%>
		<%=request.getParameter("exampleNumber")%>
	</font>
</p>