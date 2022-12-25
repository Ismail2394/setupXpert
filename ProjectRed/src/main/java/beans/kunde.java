<<<<<<< HEAD
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
	private String ort;
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
	public String getOrt() {
		return ort;
	}
	public void setOrt(string ort) {
		this.ort = ort;
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
	
}
=======
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
>>>>>>> branch 'master' of https://github.com/Ismail2394/setupXpert.git
