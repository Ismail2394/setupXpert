<!--Caglayan, Ismail 24.11.22-->
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="servlet.ArtikelListeServlet" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Artikel Liste</title>
	<link rel="stylesheet" href="../CSS/gesamt.css">
		<link rel="stylesheet" href="../CSS/ArtikelListe.css">
	
</head>
<body>
<%@ include file="00_header.html" %>
	<h1>Artikel Liste</h1>

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

			
			stmt = conn.prepareStatement("INSERT INTO products (proName, proPrice, proMenge, proDesc, proPic) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setInt(3, menge);
			stmt.setString(4, beschreibung);
			stmt.setString(5, ArtikelBild);
			stmt.executeUpdate();
		}

		
		stmt = conn.prepareStatement("SELECT * FROM products");
		rs = stmt.executeQuery();
	%>

		<table>
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
			<tbody>
				<form action="ArtikelListe.jsp" method="post">
					<div class="input-container">
						<div class="input-field">
							<label for="name">ArtikelName:</label>
							<input type="text" id="name" name="name" required>
						</div>
						<div class="input-field">
							<label for="price">Preis:</label>
							<input type="number" id="price" name="price" step="0.01" required>
						</div>
						<div class="input-field">
							<label for="menge">Menge:</label>
							<input type="number" id="menge" name="menge" required>
						</div>
						<div class="input-field">
							<label for="beschreibung">Beschreibung:</label>
							<textarea id="beschreibung" name="beschreibung" rows="4" cols="50"></textarea>
						</div>
						<div class="input-field">
							<label for="ArtikelBild">ArtikelBild:</label>
							  <input type="file" id="myFile" name="filename">
						</div>
					</div>
					<input type="submit" value="Hinzufügen">
				</form>


				<%
				while (rs.next()) {
				    int id = rs.getInt("proID");
				    String name = rs.getString("proName");
				    double price = rs.getDouble("proPrice");
				    int menge = rs.getInt("proMenge");
				    String beschreibung = rs.getString("proDesc");
				    String ArtikelBild = rs.getString("proPic");
				    %>
				        <tr>
				            <td><%= id %></td>
				            <td><%= name %></td>
				            <td><%= price %></td>
				            <td><%= menge %></td>
				            <td><%= beschreibung %></td>
				            <td><%= ArtikelBild %></td>
				        </tr>
				    <%
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			%>
			</tbody>
		</table>
	<%@ include file="00_footer.html" %>
</body>
</html>
					
