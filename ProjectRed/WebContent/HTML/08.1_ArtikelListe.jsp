<!--Caglayan, Ismail 24.11.22-->
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="servlet.ArtikelListeServlet"%>
<%@ page import="servlet.*"%>
<%@ page import="beans.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!--Taglibs, werden benötigt für die "forEach" Schleife (siehe ArtikelTabelle.jsp)-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!--Einbinden der CSS muss in diesem Fall über pageContext erfolgen, da sonst das Servlet die CSS dateien nicht "erkennt"-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/gesamt.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/ArtikelListe.css">
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artikel Liste</title>
</head>
<body>
<!--Einbinden der Jquery Bibliothek. Benötigt für den Ajax Code-->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="../Scripts/listenAufruf.js">
		
	</script>
	<div id="ergebnis"></div>
	<%@ include file="00_header.html"%>
	<h1>Artikel Liste</h1>

<!--Hier beginnt das Formular zum Hinzufügen der Artikel-->
	<table class="Artikelformular">

		<form action="../ArtikelHinzufuegenServlet" method="post"
			id="submitform">
			<div class="input-container">
				<div class="input-field">
					<label for="name">ArtikelName:</label> <input type="text" id="name"
						name="name" required>
				</div>
				<div class="input-field">
					<label for="price">Preis:</label> <input type="number" id="price"
						name="price" step="0.01" required>
				</div>
				<div class="input-field">
					<label for="menge">Menge:</label> <input type="number" id="menge"
						name="menge" required>
				</div>
				<div class="input-field">
					<label for="beschreibung">Beschreibung:</label>
					<textarea id="beschreibung" name="beschreibung" rows="4" cols="50"></textarea>
				</div>
				<div class="input-field">
					<label for="ArtikelBild">ArtikelBild:</label> <input type="file"
						id="myFile" name="ArtikelBild">
				</div>
			</div>
			<!--Der Button zum Hinzufügen der Artikel-->
			<input type="submit" value="Hinzufügen" id="submitButton">
		</form>
	</table>

	<!--Die ArtikelListe wird von der anderen JSP eingefügt.-->
	<%@ include file="08.2_ArtikelTabelle.jsp"%>
<!------Der Button zum Löschen von Artikeln, Funktionalität wird noch hinzgefügt, momentan keine Funktion---------->	
	<input type="submit" value="Löschen" id="deleteButton">
	<%@ include file="00_footer.html"%>
</body>
</html>
