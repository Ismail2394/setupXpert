<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!-- Stefan Küspert, 17.06.2023 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">
<title>Zahlung erfolgreich</title>
<base href="${pageContext.request.requestURI}" />
</head>
<body>
	<%@include file="00_header.html"%>
	<h2>Zahlungsbestätigung</h2>
	<%-- Auslesen der Formularfelder --%>
	<%
	final String bezahlen = request.getParameter("bezahlen");
	%>

	<%-- Ausgabe der Formulardaten --%>
	<h3>Ihre Bezahlung mit:</h3>
	<%=request.getParameter("bezahlen")%>
	<br>
	<h3>war erfolgreich!</h3>
	<%@include file="00_footer.html"%>
</body>
</html>