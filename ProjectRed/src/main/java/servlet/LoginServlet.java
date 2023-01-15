package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import beans.kunde;
import java.sql.ResultSet;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup = "java:jboss/datasources/ProjectRedDBDS")
	private DataSource ds;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        //Eingegebene Daten werden in Strings gespeichert
        String enteredEmail = request.getParameter("EingabeEmail");
		String enteredPasswort = request.getParameter("EingabePasswort");
        
		//DataSource aus dem ServletContext abrufen
		
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con
						.prepareStatement("SELECT passwort FROM kunde WHERE email= ?")) {

			pst.setString(1, enteredEmail);
			
      
            ResultSet rs = (ResultSet) pst.executeQuery();
            if (rs != null && rs.next()) {
                //Passwort aus der Datenbank abfragen
                String storedPassword = rs.getString("passwort");
                //Passwort vergleichen
               
                if (storedPassword.equals(enteredPasswort)) {
                    //Session für den angemeldeten Benutzer erstellen
                    HttpSession session = request.getSession();
                    session.setAttribute("EingabeEmail", enteredEmail);
                    response.sendRedirect("./HTML/Index_JSP.jsp");
                } else {
                    //Anmeldedaten waren falsch, Fehlermeldung anzeigen und zur Anmeldeseite zurückleiten
                    request.setAttribute("errorMessage", "E-mail Adresse oder Passwort ist falsch. ");
                  
                    response.sendRedirect("./HTML/Login.jsp");
                   
                }
            } else {
            	 request.setAttribute("errorMessage", "E-mail Adresse oder Passwort ist falsch. ");
                 request.setAttribute("enteredPasswort", enteredPasswort);
                
                 response.sendRedirect("./Login.jsp");
               
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
	}
	}