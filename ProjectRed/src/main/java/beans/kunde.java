package beans;

import java.io.Serializable;

public class kunde implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int kunden_id;
	private String passwort;
	private String eMail;
	private String geschlecht;
	private String geburtsdatum;
	private String plz;
	private int rolle;
	private String hausnummer;
	private String strasse;
	private String vorname;
	private String nachname;
	
	public int getKunden_id() {
		kunden_id=123456789;
		return kunden_id;
	}
	public void setKunden_id(int kunden_id) {
		this.kunden_id = kunden_id;
	}
	public String getPasswort() {
		passwort="1";
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String geteMail() {
		eMail="1";
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getGeschlecht() {
		geschlecht="m";
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	public String getGeburtsdatum() {
		geburtsdatum = "23.12.1994";
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getPlz() {
		plz="86666";
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public int getRolle() {
		rolle=1;
		return rolle;
	}
	public void setRolle(int rolle) {
		this.rolle = rolle;
	}
	public String getHausnummer() {
		hausnummer="12356";
		return hausnummer;
	}
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getStrasse() {
		strasse="12356str.";
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getVorname() {
		vorname="ismail";
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		nachname="cag";
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
}

