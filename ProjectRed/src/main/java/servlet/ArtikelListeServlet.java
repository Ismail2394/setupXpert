//Caglayan, Ismail 24.11.22
package servlet;

import java.sql.Connection;
import java.sql.SQLException;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import javax.sql.DataSource;
import jakarta.servlet.Servlet;

@WebServlet("/ArtikelListeServlet")
public class ArtikelListeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(lookup="java:jboss/datasources/ProjectRedDBDS")
    private DataSource ds;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection conn = ds.getConnection();
            conn.close();
            System.out.println("Datenbank erfolgreich initialisiert.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
