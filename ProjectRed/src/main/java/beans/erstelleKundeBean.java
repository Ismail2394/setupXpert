/*Küspert, Stefan 13.12.22 */
package beans;

import java.io.Serializable;

public class erstelleKundeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String vorName;
	private String nachName;
	private String strasse;
	private String hausNummer;
	private String plz;
	private String email;
    private String geschlecht;
	public String getVorName() {
		return vorName;
	}
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getHausNummer() {
		return hausNummer;
	}
	public void setHausNummer(String hausNummer) {
		this.hausNummer = hausNummer;
	}
	public String getNachName() {
		return nachName;
	}
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

