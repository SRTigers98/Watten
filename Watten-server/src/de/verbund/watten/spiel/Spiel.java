package de.verbund.watten.spiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.verbund.watten.exception.WattenException;
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
		runden = new ArrayList<>();
		spieler = new ArrayList<>();
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

	public int werteAus() throws WattenException {
		SpielRunde runde = new SpielRunde(regeln, spieler.get(0), spieler.get(1));
		runden.add(runde);
		int sieger = runde.werteAus();
		if (sieger == 0 || sieger > spieler.size()) {
			throw new WattenException("Fehler in der Auswertung!");
		}
		spieler.get(sieger - 1).gewonnen();
		Spieler sp1 = spieler.get(0);
		Spieler sp2 = spieler.get(1);
		if (sp1.getStiche() + sp2.getStiche() == 5) {
			if (sp1.getStiche() > sp2.getStiche()) {
				sp1.spielGewonnen();
			} else {
				sp2.spielGewonnen();
			}
			sp1.setStiche(0);
			sp2.setStiche(0);
		}
		int siegerID = 0;
		for (Spieler s : spieler) {
			if (s.isKommtRaus()) {
				siegerID = s.getId();
			}
		}
		if (spieler.get(0).getStiche() + spieler.get(1).getStiche() == 5) {
			List<Spieler> spieler = new ArrayList<>();
			spieler.add(runden.get(0).getSp2());
			spieler.add(runden.get(0).getSp1());
			this.spieler = spieler;
		}
		return siegerID;
	}

	public Regelwerk getRegeln() {
		if (regeln == null && schlag != null && farbe != null) {
			// Schlag: _7 , _8 , _9 , _10 , _Unter , _Ober , _Koenig , _Sau
			regeln = new Regelwerk(farbe, schlag);

		}
		return regeln;
	}

	public List<Karte> getDeck() {
		if (deck == null) {
			deck = new Kartendeck().getDeck();
		}
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
