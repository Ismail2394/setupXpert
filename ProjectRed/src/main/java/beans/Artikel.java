package beans;

public class Artikel {
  public int id;
  public String name;
  public double price;
  public int menge;
  public String beschreibung;
  public String ArtikelBild;



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
    return ArtikelBild;
  }

  public void setArtikelBild(String ArtikelBild) {
    this.ArtikelBild = ArtikelBild;
  }
}
