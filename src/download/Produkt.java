package download;

import java.io.Serializable;


public class Produkt implements Serializable {

	private static int id = 0;
	private String nazwa;
	private String marka;
	private double cena;
	
	static {
		id=id++;
	}
	
	public Produkt(String nazwa, String marka, double cena) {
		this.nazwa = nazwa;
		this.marka = marka;
		this.cena = cena;
	}

	public static int getId() {
		return id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String getMarka() {
		return marka;
	}

	public double getCena() {
		return cena;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item id: ");
		sb.append(id);
		sb.append("|");
		sb.append("Nazwa: ");
		sb.append(getNazwa());
		sb.append("|");
		sb.append("Marka: ");
		sb.append(getMarka());
		sb.append("|");
		sb.append("Cena: ");
		sb.append(getCena());
		sb.append("|");
		return sb.toString();
	}
}
