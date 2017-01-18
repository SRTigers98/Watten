package de.verbund.watten.spiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.karten.Kartendeck;
import de.verbund.watten.regelwerk.Regelwerk;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * Verwaltet ein einzelnes Spiel, weiß was angesagt wurde, wer mitspielt und
 * kennt die einzelnen Spielrunden.
 * 
 * @author Benjamin
 *
 */
public class Spiel {

	private Regelwerk regeln;
	private String schlag;
	private String farbe;
	private List<Karte> deck;
	private List<SpielRunde> runden;
	private List<Spieler> spieler;

	public Spiel() {
		deck = new Kartendeck().getDeck();
		spieler = new ArrayList<>();
	}

	public void teileAus() {
		Collections.shuffle(deck);
		verteileKarten();
		// regelwerk init
		// sp1 Schlag
		// sp2 farbe
		// Regelwerk erzeugt
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

	public void neueRunde() {
		if (runden == null) {
			runden = new ArrayList<>();
		}
		runden.add(new SpielRunde(getRegeln(), spieler.get(0), spieler.get(1)));
	}

	public Regelwerk getRegeln() {
		if (regeln == null && schlag != null && farbe != null) {
			// Schlag: _7 , _8 , _9 , _10 , _Unter , _Ober , _Koenig , _Sau
			regeln = new Regelwerk(farbe, schlag);

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

}
