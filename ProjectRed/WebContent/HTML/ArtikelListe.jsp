<!--Caglayan, Ismail 24.11.22-->
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="servlet.ArtikelListeServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Artikel Liste</title>
<link rel="stylesheet" href="../CSS/gesamt.css">
<link rel="stylesheet" href="../CSS/ArtikelListe.css">
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

</head>

<body>
	<%@ include file="00_header.html"%>
	<h1>Artikel Liste</h1>

<<<<<<< HEAD
	<%
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;

	try {
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup("java:jboss/datasources/ProjectRedDBDS");
		conn = ds.getConnection();

		if (request.getMethod().equalsIgnoreCase("post")) {

			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int menge = Integer.parseInt(request.getParameter("menge"));
			String beschreibung = request.getParameter("beschreibung");
			String ArtikelBild = request.getParameter("ArtikelBild");

			stmt = conn.prepareStatement(
			"INSERT INTO products (proName, proMenge, proDesc, proPic, preis) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setInt(2, menge);
			stmt.setString(3, beschreibung);
			stmt.setString(4, ArtikelBild);
			stmt.setDouble(5, price);
			stmt.executeUpdate();
		}

		stmt = conn.prepareStatement("SELECT * FROM products");
		rs = stmt.executeQuery();
	%>
=======
>>>>>>> branch 'master' of https://github.com/Ismail2394/setupXpert.git
	
	<table class="Artikelformular">
		<form action="../ArtikelListeServlet" method="post">
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
  <tbody class="ListenInhalt">
  
  <%-- Prüft ob was im Objekt ist und gibt wenn nicht den Satz "Artikel-Liste ist nicht im Request-Objekt vorhanden." aus--%>
  <c:if test="${not empty artikelListe}">
<p>Artikel-Liste ist im Request-Objekt vorhanden.</p>
<p>Anzahl der Artikel: ${fn:length(artikelListe)}</p>
</c:if>
<c:if test="${empty artikelListe}">
<p>Artikel-Liste ist nicht im Request-Objekt vorhanden.</p>
</c:if>
  
  
<%-- Iterieren über die Liste und Ausgabe der Werte --%>
<c:forEach var="artikel" items="${artikelListe}">
<p> Test </p>
     ${artikel.id}
    
</c:forEach>

<<<<<<< HEAD


					<%
					while (rs.next()) {
						int id = rs.getInt("proID");
						String name = rs.getString("proName");
						double price = rs.getDouble("preis");
						int menge = rs.getInt("proMenge");
						String beschreibung = rs.getString("proDesc");
						String ArtikelBild = rs.getString("proPic");
					%>
					<tr>
						<td><%=id%></td>
						<td><%=name%></td>
						<td><%=price%></td>
						<td><%=menge%></td>
						<td><%=beschreibung%></td>
						<td><%=ArtikelBild%></td>
					</tr>
					<%
					}

					} catch (Exception e) {
					e.printStackTrace();
					} finally {
					try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					} catch (SQLException e) {
					e.printStackTrace();
					}
					}
					%>
				</tbody>
			</table>
=======
			
  </tbody>
</table>
>>>>>>> branch 'master' of https://github.com/Ismail2394/setupXpert.git
			
		</div>
	
	</div>
		
	</div>
	<input type="submit" value="Löschen" id="deleteButton">
	<%@ include file="00_footer.html"%>
</body>
</html>

