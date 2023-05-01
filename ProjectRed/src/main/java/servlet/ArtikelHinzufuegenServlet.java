//Caglayan, Ismail 01.05.23

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

		// Weiterleiten zur Erfolgsseite
		request.setAttribute("form", form);
		response.sendRedirect("./HTML/08.1_ArtikelListe.jsp");
	}

	private void persist(Artikel form) throws ServletException {

		String[] generatedKeys = new String[] { "proID" };

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
