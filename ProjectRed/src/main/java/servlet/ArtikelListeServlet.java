//Caglayan, Ismail 01.05.23
/**
 * Servlet welches benutzt wird, um die Artikel aus der Datenbank auszulesen und dann in der JSP "08.2_ArtikelTabelle.jsp
 * anzuzeigen. Die Anzeige läuft über einen Ajax Code, welche in der Script-Datei "listeAufruf.js" definiert ist.
 */

package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import beans.Artikel;

/**
 * Implementierung des Servlets "ArtikelListeServlet"
 */
@WebServlet("/ArtikelListeServlet")
public class ArtikelListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//Einbinden der Datenbank aus dem JBoss Server
	@Resource(lookup = "java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;

	public ArtikelListeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
//Aufrufen der Funktion "produkteAbfragen" und Zuweisung der Artikel an die Liste "lp"
		
		List<Artikel> lp = produkteAbfragen();
		System.out.println("Anzahl der Artikel: " + lp.size()); // Konsolenausgabe
		/*
		Das Objekt wird per Request an die JSP übergeben, in der JSP muss(!) das Objekt "Produktliste" genutzt werden, um die Attribute (name,price,usw.)
		abzufragen.
		*/
		request.setAttribute("Produktliste", lp);
		/*
		Aufruf der JSP "ArtikelTabelle.jsp" bei Aufruf des Servlets.
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("HTML/08.2_ArtikelTabelle.jsp");
		dispatcher.forward(request, response);

	}
	/*
	Hier beginnt die Methode zum Auslesen der Artikel aus der Datenbank
	*/
	public List<Artikel> produkteAbfragen() throws ServletException {

		List<Artikel> lp = new ArrayList<>();
		try (Connection con = ds.getConnection();
				/*
				SQL Abfrage zum selektieren des Produktes aus der Datenbank. Die Attribute werden anschließend in einer Schleife
				in das Objekt "produkt" übergeben. Das Objekt "produkt" wird dann anschließend der liste "lp" hinzugefügt. So erhaltn
				wir am Ende der Funktion eine Liste mit unseren Produkten. Am Ende der Funktion wird die Liste per return übergeben,
				und in der doGet Methode weiter oben nutzen wir dann diese Rückgabe, um die Liste per Request an die JSP weiterzugeben.
				*/
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM products")) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs != null && rs.next()) {
					Artikel produkt = new Artikel();

					produkt.setId(rs.getInt("proID"));
					produkt.setName(rs.getString("proName"));
					produkt.setPrice(rs.getDouble("proPrice"));
					produkt.setMenge(rs.getInt("proMenge"));
					produkt.setBeschreibung(rs.getString("proDesc"));
					produkt.setArtikelBild(rs.getString("proPic"));
					lp.add(produkt);
				}

			}

			return lp;
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(405);
	}

}
