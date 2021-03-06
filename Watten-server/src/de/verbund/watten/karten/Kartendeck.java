package de.verbund.watten.karten;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Erstellt ein vollständiges Kartendeck in einer Liste von Karten.
 * 
 * @author Benjamin
 *
 */
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
		schlaege[0] = "_7";
		schlaege[1] = "_8";
		schlaege[2] = "_9";
		schlaege[3] = "_10";
		schlaege[4] = "_Unter";
		schlaege[5] = "_Ober";
		schlaege[6] = "_Koenig";
		schlaege[7] = "_Sau";
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
				deck.add(new Karte(f, s));
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
