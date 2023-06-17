package beans;

public class Artikel {
	public int id;
	public String name;
	public double price;
	public int menge;
	public String beschreibung;
	public String artikelBild;

	public Artikel() {
		super();
	}

	public Artikel(Integer id, String name, Double price, Integer menge, String beschreibung, String artikelBild) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.menge = menge;
		this.beschreibung = beschreibung;
		this.artikelBild = artikelBild;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getArtikelBild() {
		return artikelBild;
	}

	public void setArtikelBild(String artikelBild) {
		this.artikelBild = artikelBild;
	}
}
