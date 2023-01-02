package servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import beans.kunde;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendError(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
//LOGIN
		String email = request.getParameter("email");
		String passwort = request.getParameter("password");

		
//ABFRAGE DER LOGIN DATEN
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM kunde WHERE email= ?")) {

			pstmt.setString(1, email);
		

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					
					kunde checkout = new kunde();
					checkout.setVorname(rs.getString("vorname"));
					checkout.setNachname(rs.getString("nachname"));
					checkout.setStrasse(rs.getString("strasse"));
					checkout.setPlz(rs.getString("plz"));
					checkout.setHausnummer(rs.getString("hausnummer"));
					checkout.setGeburtsdatum(rs.getString("geburtsdatum"));
					checkout.setGeschlecht(rs.getString("geschlecht"));
				
				// LOGIN DATEN FALSCH
				} else {
					response.sendRedirect("index.html");
				}
			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}

}
