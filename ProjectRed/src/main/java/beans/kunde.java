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
	private String rolle;
	private String hausnummer;
	private String strasse;
	private String vorname;
	private String nachname;
	
	public int getKunden_id() {
		
		return kunden_id;
	}
	public void setKunden_id(int kunden_id) {
		this.kunden_id = kunden_id;
	}
	public String getPasswort() {
		
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
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
	public String getGeburtsdatum() {
		
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getPlz() {
		
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getRolle() {
		
		return rolle;
	}
	
	public void setRolle(String string) {
		rolle = "1";
		this.rolle = string;
	}
	public String getHausnummer() {
		
		return hausnummer;
	}
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getStrasse() {
		
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getVorname() {
		
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
}

