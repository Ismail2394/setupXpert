/*Küspert, Stefan 13.12.22 */
package beans;

import java.io.Serializable;

public class kontakt implements Serializable {
	private static final long serialVersionUID = 1L;
	private int kontakt_id;
	private String productType1;
	private String productType2;
	private String productType3;
	private String eMail;
	private String geschlecht;
	private String firstName;
	private String lastName;
	private String custmessage;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustmessage() {
		return custmessage;
	}

	public void setCustmessage(String custmessage) {
		this.custmessage = custmessage;
	}

	public String getProductType1() {
		return productType1;
	}

	public void setProductType1(String productType1) {
		this.productType1 = productType1;
	}

	public String getProductType3() {
		return productType3;
	}

	public void setProductType3(String productType3) {
		this.productType3 = productType3;
	}

	public String getProductType2() {
		return productType2;
	}

	public void setProductType2(String productType2) {
		this.productType2 = productType2;
	}

	
}
