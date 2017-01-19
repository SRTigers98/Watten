package de.verbund.watten.spieler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.karten.Karte;

/**
 * 
 * Datenhaltungsklasse für die Spieler, die am Spiel teilnehmen.
 * 
 * @author Benjamin
 *
 */
public class Spieler implements Serializable {

	private int id;
	private String name;
	private List<Karte> hand;
	private int stiche;
	private int punkte;
	private Karte gespielt;
	private boolean kommtRaus;

	public Spieler() {
		// default-Konstruktor
		stiche = 0;
		punkte = 0;
		kommtRaus = false;
	}

	public Spieler(int id, String name) {
		this.id = id;
		this.name = name;
		stiche = 0;
		punkte = 0;
		kommtRaus = false;

	}

	public void gewonnen() {
		stiche++;
		punkte += 20;
	}

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

	public List<Karte> getHand() {
		if (hand == null) {
			hand = new ArrayList<>();
		}
		return hand;
	}

	public int getStiche() {
		return stiche;
	}

	public void setStiche(int stiche) {
		this.stiche = stiche;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public Karte getGespielt() {
		return gespielt;
	}

	public void setGespielt(Karte gespielt) {
		this.gespielt = gespielt;
	}

	public boolean isKommtRaus() {
		return kommtRaus;
	}

	public void setKommtRaus(boolean kommtRaus) {
		this.kommtRaus = kommtRaus;
	}

}
