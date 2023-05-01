//Caglayan, Ismail 01.05.23
/**
 * Servlet welches genutzt wird um in der JSP "08.1_ArtikelListe.jsp" Artikel hinzufügen. Die Artikel werden anschließend in Echtzeit
 * in einer Tabelle angezeigt.
 */
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Artikel;
/**
 * Implementieren des Servlets "ArtikelHinzufuegenServlet"
 */
@WebServlet("/ArtikelHinzufuegenServlet")
public class ArtikelHinzufuegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Daten aus der JSP extrahieren
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int menge = Integer.parseInt(request.getParameter("menge"));
		String beschreibung = request.getParameter("beschreibung");
		String artikelBild = request.getParameter("artikelBild");

		// Neue Artikel-Instanz erstellen
		Artikel form = new Artikel();
		form.setName(name);
		form.setPrice(price);
		form.setMenge(menge);
		form.setBeschreibung(beschreibung);
		form.setArtikelBild(artikelBild);

		// Persistieren der Daten in der Datenbank
		persist(form);

		/**
		 * Das Formular wird hier an die JSP weitergegeben. In de JSP wird dann das Atribut "form" benutzt und damit weitergearbeitet.
		 */
		
		request.setAttribute("form", form);
		/**
		 * Nach dem drücken auf den "Hinzufügen" button soll der Nutzer weiterhin auf der ArtikelListe.jsp bleiben, daher wird hier ein 
		 * "sendDirect" definiert und auf die "08.1_ArtikelListe.jsp" hingewiesen.
		 */
		response.sendRedirect("./HTML/08.1_ArtikelListe.jsp");
	}
	/**
	 * Hier beginnt die Methode zum Einfügen der Inhalte in die Datenbank.
	 */
	private void persist(Artikel form) throws ServletException {

		String[] generatedKeys = new String[] { "proID" };
		/**
		 * Per SQL-Insert Anweisung werden die Attribute per getter-Methode in die Datenbank geschrieben. Die Attribute werden
		 *  aus dem Formular "08.1_ArtikelListe.jsp" entnommen.
		 */
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO products (proName, proPrice, proMenge, proDesc, proPic) VALUES (?, ?, ?, ?, ?)",
						generatedKeys);) {

			pstmt.setString(1, form.getName());
			pstmt.setDouble(2, form.getPrice());
			pstmt.setInt(3, form.getMenge());
			pstmt.setString(4, form.getBeschreibung());
			pstmt.setString(5, form.getArtikelBild());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int generatedId = rs.getInt(1);
				form.setId(generatedId);
			}
			rs.close();
		} catch (SQLException e) {
			throw new ServletException("Error persisting article data", e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
