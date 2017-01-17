package de.verbund.watten.spieler;

import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.karten.Karte;

public class Spieler {

	private String name;
	private List<Karte> hand;
	private int stiche;
	private int punkte;

	public Spieler() {
		// default-Konstruktor
	}

	public Spieler(String name) {
		this.name = name;
		stiche = 0;
		punkte = 0;
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

}
