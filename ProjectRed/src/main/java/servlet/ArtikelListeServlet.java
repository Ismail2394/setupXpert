//Caglayan, Ismail 17.03.2023

package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Artikel;

@WebServlet("/ArtikelListeServlet")
public class ArtikelListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Deklaration der Liste aus der Methode public List<Artikel> weiter unten
		List<Artikel> artikelListe;
		try {
			artikelListe = getArtikelListe();
		} catch (SQLException e) {
			throw new ServletException("Datenbank-Abfrage fehlgeschlagen", e);
		}
// Nur ein kurzer Test, ob überhaupt was in den einzelnen Attributen drinenn steht. In der Konsole sollten die werte ausgegen werden
		for (Artikel artikel : artikelListe) {
			System.out.println("ID: " + artikel.getId());
			System.out.println("Name: " + artikel.getName());
			System.out.println("Preis: " + artikel.getPrice());
			System.out.println("Menge: " + artikel.getMenge());
			System.out.println("Beschreibung: " + artikel.getBeschreibung());
			System.out.println("Artikel Bild: " + artikel.getArtikelBild());
		}
//Dem request wird nun das Attribut artikelListe weitergegeben
		request.setAttribute("artikelListe", artikelListe);
//Übergibt das request an die JSP, wo eigentlich auch die Werte der Liste beinhaltet sein sollten
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArtikelListe.jsp");
		dispatcher.forward(request, response);
	}

// Hier wird die Liste erstellt, die in der Tabelle der JSP ausgegeben werden soll
	public List<Artikel> getArtikelListe() throws SQLException {
		String query = "SELECT proID, proName, proPrice, proMenge, proDesc, proPic FROM products"; //Select Abfrage der Datenbank
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			try (ResultSet rs = stmt.executeQuery()) {
				List<Artikel> artikelListe = new ArrayList<>();
				while (rs.next()) {  //Die Werte aus dem Select werden nun einzeln in die Attribute übergeben.
					int id = rs.getInt("proID");
					String name = rs.getString("proName");
					double price = rs.getDouble("proPrice");
					int menge = rs.getInt("proMenge");
					String beschreibung = rs.getString("proDesc");
					String ArtikelBild = rs.getString("proPic");
					Artikel artikel = new Artikel();
					artikel.setId(id);
					artikel.setName(name);
					artikel.setPrice(price);
					artikel.setMenge(menge);
					artikel.setBeschreibung(beschreibung);
					artikel.setArtikelBild(ArtikelBild);
					artikelListe.add(artikel);  //Die Liste wird nun dem Objekt artikel zugeordnet
				}
				return artikelListe;
			}
		}
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
