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

		// Check if form was submitted
		if (request.getMethod().equalsIgnoreCase("post")) {
			// Get values from form
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int menge = Integer.parseInt(request.getParameter("menge"));
			String beschreibung = request.getParameter("beschreibung");

			// Insert new product into database
			stmt = conn.prepareStatement("INSERT INTO products (proName, proPrice, proMenge, proDesc) VALUES (?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setInt(3, menge);
			stmt.setString(4, beschreibung);
			stmt.executeUpdate();
		}

		// Retrieve products from database
		stmt = conn.prepareStatement("SELECT * FROM products");
		rs = stmt.executeQuery();
	%>

		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Menge</th>
					<th>Beschreibung</th>
				</tr>
			</thead>
			<tbody>
				<form action="ArtikelListe.jsp" method="post">
					<label for="name">ArtikelName:</label>
					<input type="text" id="name" name="name" required>

					<label for="price">Preis:</label>
					<input type="number" id="price" name="price" step="0.01" required>

					<label for="menge">Menge:</label>
					<input type="number" id="menge" name="menge" required>

					<label for="beschreibung">Beschreibung:</label>
					<textarea id="beschreibung" name="beschreibung" rows="4" cols="50"></
					</textarea>

					<input type="submit" value="Submit">
				</form>

				<%
				while (rs.next()) {
				    int id = rs.getInt("proID");
				    String name = rs.getString("proName");
				    double price = rs.getDouble("proPrice");
				    int menge = rs.getInt("proMenge");
				    String beschreibung = rs.getString("proDesc");
				    %>
				        <tr>
				            <td><%= id %></td>
				            <td><%= name %></td>
				            <td><%= price %></td>
				            <td><%= menge %></td>
				            <td><%= beschreibung %></td>
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
					
