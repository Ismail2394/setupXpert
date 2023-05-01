<!--Caglayan, Ismail 01.05.23-->
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.InitialContext"%>
<jsp:useBean id="ArtikelListeServlet"
	class="servlet.ArtikelListeServlet" scope="page" />
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
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="../Scripts/listenAufruf.js">
		
	</script>

	<!--Ab hier beginnt die ArtikelListe-->

	<div id="border">
		<div id="table-wrapper">
			<div id="table-scroll">
				<table id="artikelliste" class="Artikelliste">
					<thead>

						<tr>
							<th>ID</th>
							<th>Artikel</th>
							<th>Preis</th>
							<th>Menge</th>
							<th>Beschreibung</th>
							<th>Bildpfad</th>
						</tr>
					</thead>
					<tbody class="ListenInhalt" id="ListenInhalt">


						<%-- Iterieren über die Liste und Ausgabe der Werte --%>
						<c:forEach var="artikel" items="${Produktliste}">

							<tr>
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


</body>
</html>


