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
		System.out.println("erzeuge neuen spieler (default)");
	}

	public Spieler(int id, String name) {
		this.id = id;
		this.name = name;
		stiche = 0;
		punkte = 0;
		kommtRaus = false;
		System.out.println("erzeuge neuen spieler");

	}

	public void gewonnen() {
		stiche++;
		System.out.println("Stiche wurden erhöht und sind jetzt " + stiche);
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
		System.out.println("get Stiche:" + stiche);
		return stiche;
	}

	public void setStiche(int stiche) {
		System.out.println("set stich " + stiche);
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

	@Override
	public String toString() {
		return "Spieler [id=" + id + ", name=" + name + ", hand=" + hand + ", stiche=" + stiche + ", punkte=" + punkte
				+ ", gespielt=" + gespielt + ", kommtRaus=" + kommtRaus + "]";
	}
}
