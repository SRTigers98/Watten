package de.verbund.watten.karten;

import java.io.Serializable;

public class Karte implements Serializable {

	private String schlag;
	private String farbe;
	private int wert;
	private String link;

	public Karte() {
		// default-Konstruktor
	}

	public Karte(String farbe, String schlag) {
		this.schlag = schlag;
		this.farbe = farbe;
	}

	public String getSchlag() {
		return schlag;
	}

	public void setSchlag(String schlag) {
		this.schlag = schlag;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public String getLink() {
		if (link == null) {
			link = farbe + schlag + ".png";
		}
		return link;
	}

	@Override
	public String toString() {
		return new StringBuffer().append(farbe).append(schlag).toString();
	}

}
