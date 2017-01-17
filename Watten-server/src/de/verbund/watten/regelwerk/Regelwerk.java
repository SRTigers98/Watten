package de.verbund.watten.regelwerk;

import java.util.HashMap;
import java.util.Map;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.karten.Kartendeck;

public class Regelwerk {

	private static final int SPIELER_1 = 1;
	private static final int SPIELER_2 = 2;
	Map<String, Integer> regelwerk;

	private Kartendeck referenzDeck;

	public Regelwerk() {

		regelwerk = new HashMap<>();

		// Fix
		// TODO Fabian Regelwerk

	}

	public int wertAus(Karte sp1, Karte sp2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
