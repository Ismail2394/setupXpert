@WebServlet("/erstelleKunde")
public class erstelleKunde extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/ProjectRedDBDS")
<<<<<<< HEAD
	private projectreddb ds;
=======
	private DataSource ds;
>>>>>>> branch 'master' of https://github.com/Ismail2394/setupXpert.git

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
							"INSERT INTO Kunde (KundenID, Vorname, Nachname, Strasse, HNr, PLZ, GebDatum, Geschlecht, EMail, Rolle) VALUES (?,?,?,?,?,?,?,?,?,?)", generatedKeys
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
					pstmt.executeUpdate();
	
					ResultSet rs = pstmt.getGeneratedKeys();				
						while (rs.next()) {
<<<<<<< HEAD
							form.seteMail(getServletInfo());;
=======
							form.setKunden_id(rs.getInt(1));
>>>>>>> branch 'master' of https://github.com/Ismail2394/setupXpert.git
						}
					
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