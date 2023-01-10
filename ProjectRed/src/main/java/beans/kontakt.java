/*Küspert, Stefan 13.12.22 */
package beans;

import java.io.Serializable;

public class kontakt implements Serializable {
	private static final long serialVersionUID = 1L;
	private int kontakt_id;
	private String eMail;
	private String geschlecht;
	private String vorName;
	private String nachName;
	private String custmessage;
	private int bestID;

	public int getKontakt_id() {
		return kontakt_id;
	}

	public void setKontakt_id(int kontakt_id) {
		this.kontakt_id = kontakt_id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getCustmessage() {
		return custmessage;
	}

	public void setCustmessage(String custmessage) {
		this.custmessage = custmessage;
	}

	public int getBestID() {
		return bestID;
	}

	public void setBestID(int bestID) {
		this.bestID = bestID;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
}
