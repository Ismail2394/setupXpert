//Caglayan, Ismail 01.05.23
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
 * Servlet implementation class ProdukteUebersichtServlet
 */
@WebServlet("/ArtikelListeServlet")
public class ArtikelListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;

	public ArtikelListeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		List<Artikel> lp = produkteAbfragen();
		/**/
		request.setAttribute("Produktliste", lp);

		RequestDispatcher dispatcher = request.getRequestDispatcher("HTML/08.2_ArtikelTabelle.jsp");
		dispatcher.forward(request, response);

	}

	public List<Artikel> produkteAbfragen() throws ServletException {

		List<Artikel> lp = new ArrayList<>();
		try (Connection con = ds.getConnection();
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
