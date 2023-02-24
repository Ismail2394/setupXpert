<%@ page language="java" contentType="text/html" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HTML-Formularausgabe mittels JSP, Servlet und JavaBean</title>
		<base href="${pageContext.request.requestURI}"/>
	</head>
	<body>
		<%-- Fehler provozieren
		<% String irgendwas = null;	out.println(irgendwas.toString()); %>
		--%>
		
		<h2>HTML-Formularausgabe mittels JSP, Servlet und JavaBean</h2>
		<h3>Ihre Eingaben</h3>
		<br><b>Anrede: </b>${form.anrede}
		<br><b>Vorname </b>${form.firstName}
		<br><b>Nachname: </b>${form.lastName}
		<br><b>E-Mail: </b>${form.email}
		<br><b>Betroffene Produktgruppe(n): </b>${form.checkbox}
		<br><b>Nachricht: </b>${form.custMessage}
	</body>
</html>