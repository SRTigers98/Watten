package spieler;

import java.util.ArrayList;
import java.util.List;

import karten.Karte;

public class Spieler {

	private String id;
	private String name;
	private List<Karte> hand;
	private int stiche;
	private int punkte;

	public Spieler() {
		// default-Konsturktor
	}

	public Spieler(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

}
