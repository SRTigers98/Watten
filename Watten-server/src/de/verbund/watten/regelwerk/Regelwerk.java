package de.verbund.watten.regelwerk;

import java.util.HashMap;
import java.util.Map;

import de.verbund.watten.karten.Karte;

/**
 * 
 * @author Fabian Klasse setzt das Regelwerk fest, welche Karten andere Karten
 *         stechen. werteAus gleicht die beiden gespielten Karten mit dem
 *         Regelwerk ab und liefert den Gewinner des Stiches
 */

public class Regelwerk {

	private static final int SPIELER_1 = 1;
	private static final int SPIELER_2 = 2;
	Map<String, Integer> regelwerk;

	// Schlag: _7 , _8 , _9 , _10 , _Unter , _Ober , _Koenig , _Sau
	public Regelwerk(String farbe, String schlag) {

		regelwerk = new HashMap<>();

		// Fixe Werte
		regelwerk.put("Herz_Koenig", 100);
		regelwerk.put("Schelln_7", 98);
		regelwerk.put("Eichel_7", 96);

		// optionale 4. hoechste Karte
		if (farbe.equals("Herz") && schlag.equals("_Koenig")) {
		} else if (farbe.equals("Schelln") && schlag.equals("_7")) {
		} else if (farbe.equals("Eichel") && schlag.equals("_7")) {
		} else {
			regelwerk.put(farbe + schlag, 94);
		}

		// schlaege
		if (!regelwerk.containsKey("Herz" + schlag)) {
			regelwerk.put("Herz" + schlag, 88);
		}
		if (!regelwerk.containsKey("Schelln" + schlag)) {
			regelwerk.put("Schelln" + schlag, 88);
		}
		if (!regelwerk.containsKey("Eichel" + schlag)) {
			regelwerk.put("Eichel" + schlag, 88);
		}
		if (!regelwerk.containsKey("Blau" + schlag)) {
			regelwerk.put("Blau" + schlag, 88);
		}

		// Trumpffarbe
		if (!regelwerk.containsKey(farbe + "_7")) {
			regelwerk.put(farbe + "_7", 60);
		}
		if (!regelwerk.containsKey(farbe + "_8")) {
			regelwerk.put(farbe + "_8", 61);
		}
		if (!regelwerk.containsKey(farbe + "_9")) {
			regelwerk.put(farbe + "_9", 62);
		}
		if (!regelwerk.containsKey(farbe + "_10")) {
			regelwerk.put(farbe + "_10", 63);
		}
		if (!regelwerk.containsKey(farbe + "_Unter")) {
			regelwerk.put(farbe + "_Unter", 64);
		}
		if (!regelwerk.containsKey(farbe + "_Ober")) {
			regelwerk.put(farbe + "_Ober", 65);
		}
		if (!regelwerk.containsKey(farbe + "_Koenig")) {
			regelwerk.put(farbe + "_Koenig", 66);
		}
		if (!regelwerk.containsKey(farbe + "_Sau")) {
			regelwerk.put(farbe + "_Sau", 67);
		}

		// restl. Farben
		int value = 20;
		verteileNiedrigePrio("_7", value);
		verteileNiedrigePrio("_8", value);
		verteileNiedrigePrio("_9", value);
		verteileNiedrigePrio("_10", value);
		verteileNiedrigePrio("_Unter", value);
		verteileNiedrigePrio("_Ober", value);
		verteileNiedrigePrio("_Koenig", value);
		verteileNiedrigePrio("_Sau", value);


	}

	private int verteileNiedrigePrio(String kartenwert, int value) {
		if (!regelwerk.containsKey("Herz" + kartenwert))
			regelwerk.put("Herz" + kartenwert, value);
		if (!regelwerk.containsKey("Schelln" + kartenwert))
			regelwerk.put("Schelln" + kartenwert, value);
		if (!regelwerk.containsKey("Eichel" + kartenwert))
			regelwerk.put("Eichel" + kartenwert, value);
		if (!regelwerk.containsKey("Blau" + kartenwert))
			regelwerk.put("Blau" + kartenwert, value);
		value++;
		return value;
	}

	public int werteAus(Karte sp1, Karte sp2) {

		int gewinner = 0;
		int valueSp1 = regelwerk.get(sp1.getFarbe() + sp1.getSchlag());
		int valueSp2 = regelwerk.get(sp2.getFarbe() + sp2.getSchlag());
		gewinner = werteTrumpf(gewinner, valueSp1, valueSp2);
		if (gewinner == 0) {
			if (sp1.getFarbe().equals(sp2.getFarbe())) {
				if (valueSp1 < valueSp2) {
					gewinner = SPIELER_2;
				}
			}
			if (gewinner == 0) {
				gewinner = SPIELER_1;
			}

		}

		return gewinner;
	}

	private int werteTrumpf(int gewinner, int valueSp1, int valueSp2) {
		if (valueSp1 > 50 || valueSp2 > 50) {
			if (valueSp1 > valueSp2) {
				gewinner = SPIELER_1;
			}
			if (valueSp2 > valueSp1) {
				gewinner = SPIELER_2;
			}
			if (valueSp1 == valueSp2) {
				gewinner = SPIELER_1;
			}
		}

		return gewinner;
	}

	public Map<String, Integer> getRegelwerk() {
		return regelwerk;
	}
}
