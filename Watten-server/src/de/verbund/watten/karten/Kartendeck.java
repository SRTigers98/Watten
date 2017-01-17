package de.verbund.watten.karten;

import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.karten.Karte;

public class Kartendeck {

	private String[] schlaege;
	private String[] farben;
	private List<Karte> deck;

	public Kartendeck() {
		schlaege = new String[8];
		farben = new String[4];
		deck = new ArrayList<>();
		setzeDesign();
		erzeugeDeck();
	}

	private void setzeDesign() {
		setzeFarben();
		setzeSchlaege();
	}

	private void setzeSchlaege() {
		schlaege[0] = "7";
		schlaege[1] = "8";
		schlaege[2] = "9";
		schlaege[3] = "10";
		schlaege[4] = "Unter";
		schlaege[5] = "Ober";
		schlaege[6] = "Koenig";
		schlaege[7] = "Sau";
	}

	private void setzeFarben() {
		farben[0] = "Schelln";
		farben[1] = "Herz";
		farben[2] = "Blau";
		farben[3] = "Eichel";
	}

	private void erzeugeDeck() {
		for (String f : farben) {
			for (String s : schlaege) {
				deck.add(new Karte(s, f));
			}
		}
	}

	public List<Karte> getDeck() {
		return deck;
	}

	public String[] getSchlaege() {
		return schlaege;
	}

	public String[] getFarben() {
		return farben;
	}

}
