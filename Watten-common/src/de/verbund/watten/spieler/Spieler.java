package de.verbund.watten.spieler;

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
public class Spieler {

	private int id;
	private String name;
	private List<Karte> hand;
	private int stiche;
	private int punkte;
	private Karte gespielt;

	public Spieler() {
		// default-Konstruktor
	}

	public Spieler(int id, String name) {
		this.id = id;
		this.name = name;
		stiche = 0;
		punkte = 0;
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

}
