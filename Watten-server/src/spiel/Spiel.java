package spiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import karten.Karte;
import karten.Kartendeck;
import regelwerk.Regelwerk;
import spieler.Spieler;

public class Spiel {

	private Regelwerk regeln;
	private List<Karte> deck;
	private List<SpielRunde> runden;
	private List<Spieler> spieler;

	public Spiel() {
		deck = new Kartendeck().getDeck();
	}

	public void teileAus() {
		Collections.shuffle(deck);
		verteileKarten();
	}

	private void verteileKarten() {
		for (int i = 0; i < spieler.size(); i++) {
			gibKartenAus(spieler.get(i), 3);
		}
		for (int i = 0; i < spieler.size(); i++) {
			gibKartenAus(spieler.get(i), 2);
		}
	}

	private void gibKartenAus(Spieler spieler, int anzahl) {
		for (int i = 0; i < anzahl; i++) {
			spieler.getHand().add(deck.get(0));
			deck.remove(0);
		}
	}

	public void werteAus() {
		// TODO Gespielte Karten vergleichen
	}

	public Regelwerk getRegeln() {
		if (regeln == null) {
			regeln = new Regelwerk();
		}
		return regeln;
	}

	public List<Karte> getDeck() {
		// TODO Wenn null, dann Exception
		return deck;
	}

	public List<SpielRunde> getRunden() {
		if (runden == null) {
			runden = new ArrayList<>();
		}
		return runden;
	}

	public List<Spieler> getSpieler() {
		if (spieler == null) {
			spieler = new ArrayList<>();
		}
		return spieler;
	}

}
