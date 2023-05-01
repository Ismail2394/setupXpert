<!--Caglayan, Ismail 24.11.22-->
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.InitialContext"%>

<%@ page import="javax.sql.DataSource"%>
<%@ page import="servlet.ArtikelListeServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="servlet.*"%>
<%@ page import="beans.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artikel Liste</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/gesamt.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/ArtikelListe.css">

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--<script type="text/javascript" src="Scripts/listenAufruf.js"></script>-->
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="../Scripts/listenAufruf.js">
		
	</script>
	<div id="ergebnis"></div>
	<%@ include file="00_header.html"%>
	<h1>Artikel Liste</h1>

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
			<input type="submit" value="Hinzufügen" id="submitButton">
		</form>
	</table>

	<!--Ab hier beginnt die ArtikelListe-->



	<%@ include file="08.2_ArtikelTabelle.jsp"%>
	<input type="submit" value="Löschen" id="deleteButton">
	<%@ include file="00_footer.html"%>
</body>
</html>
