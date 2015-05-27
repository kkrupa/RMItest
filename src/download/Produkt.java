package download;

import java.io.Serializable;


public class Produkt implements Serializable {

	private static int increment = 0;
	private int id;
	private String nazwa;
	private String marka;
	private double cena;
	
	public Produkt(String nazwa, String marka, double cena) {
		this.nazwa = nazwa;
		this.marka = marka;
		this.cena = cena;
		id=++increment;
	}

	public int getId() {
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
		sb.append("\n");
		sb.append(id);
		sb.append("|");
		sb.append(getNazwa());
		sb.append("|");
		sb.append(getMarka());
		sb.append("|");
		sb.append(getCena());
		return sb.toString();
	}
}
