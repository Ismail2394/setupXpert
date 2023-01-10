package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import beans.kunde;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/erstelleKunde")
public class erstelleKunde extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 
		kunde form = new kunde();

		
		
		persist(form);
		request.setAttribute("form", form);

		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/1_outputdataRegistration.jsp");
		dispatcher.forward(request, response);
	}
	private void persist(kunde form) throws ServletException {
		
		   String[] generatedKeys = new String[] {"id"};
			
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO Kunde (KundenID, Vorname, Nachname, Strasse, HNr, PLZ, GebDatum, Geschlecht, EMail, Rolle, passwort) VALUES (?,?,?,?,?,?,?,?,?,?,?)", generatedKeys
							)){
                        
				pstmt.setInt(1, form.getKunden_id());	
			 	pstmt.setString(2, form.getVorname());
			 	pstmt.setString(3, form.getNachname());
			 	 pstmt.setString(4, form.getStrasse()); 
			    pstmt.setString(5, form.getHausnummer());
			    pstmt.setString(6, form.getPlz());
			    pstmt.setString(7, form.getGeburtsdatum());
			    pstmt.setString(8, form.getGeschlecht());
			    pstmt.setString(9, form.geteMail());
			    pstmt.setInt(10, form.getRolle());
			    pstmt.setString(11, form.getPasswort());
					pstmt.executeUpdate();
	
					
				} catch (Exception ex) {
					throw new ServletException(ex.getMessage());
				}
		
			
			}
		
		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

	}