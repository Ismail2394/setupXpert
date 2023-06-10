<!--Caglayan, Ismail 01.05.23-->
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="servlet.*"%>
<%@ page import="beans.Artikel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="servlet.ArtikelListeServlet"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!--Taglibs, werden benötigt für die "forEach" Schleife -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--Zuweisung an die JSP, welches Servlet genutzt werden soll -->


<!DOCTYPE html>
<html>
<head>
<!--<script src="../Scripts/artikelLoeschen.js" type="text/javascript"></script>-->
<meta charset="UTF-8">
<title>Artikel Liste</title>
<!--Einbinden der CSS muss in diesem Fall über pageContext erfolgen, da sonst das Servlet die CSS dateien nicht "erkennt"-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/gesamt.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/ArtikelListe.css">
</head>
<body>
<!--Einbinden der Jquery Bibliothek. Benötigt für den Ajax Code-->
	
	<script type="text/javascript" src="../Scripts/listenAufruf.js">
		
	</script>

	<!--Ab hier beginnt die ArtikelListe-->
	<div id="random">
	<div id="border">
		<div id="table-wrapper">
			<div id="table-scroll">
				<table id="artikelliste" class="Artikelliste">
					<thead>

						<tr>
						<!--Definition der Spaltennamen-->
							<th>ID</th>
							<th>Artikel</th>
							<th>Preis</th>
							<th>Menge</th>
							<th>Beschreibung</th>
							<th>Bildpfad</th>
						</tr>
					</thead>
					<tbody class="ListenInhalt" id="ListenInhalt">
						<!--Schleife geht jedes Produkt durch und gibt die Attribute "id,name,price,menge,beschreibung,artikelBild" aus-->
							<!--"Produktliste ist das Attribut, was in "ArtikelListeServlet.java" an die JSP übergeben wird, siehe:-->
							<!--"request.setAttribute("Produktliste", lp);-->
						<c:forEach var="artikel" items="${Produktliste}">	

							<tr onclick="selectRow(this.parentNode)">
								<td>${artikel.id}</td>
								<td>${artikel.name}</td>
								<td>${artikel.price}</td>
								<td>${artikel.menge}</td>
								<td>${artikel.beschreibung}</td>
								<td>${artikel.artikelBild}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
	<input type="submit" value="Löschen" id="deleteButton">
	</div>
	
</body>

</html>


