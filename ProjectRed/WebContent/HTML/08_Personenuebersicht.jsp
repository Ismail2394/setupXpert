<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personenuebersicht</title>
<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">
</head>
<body>
<%@ include file="00_header.html" %>
	<%
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;

	try {
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup("java:jboss/datasources/ProjectRedDBDS");
		conn = ds.getConnection();

		if (request.getMethod().equalsIgnoreCase("post")) {

			String id = request.getParameter("KundenID");
			String vname = request.getParameter("vorname");
			String nname = request.getParameter("nachname");
			String strasse = request.getParameter("strasse");
			String ord = request.getParameter("ort");

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
	
	
<%@ include file="00_footer.html" %>
</body>
</html>