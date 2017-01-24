package de.verbund.watten.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.regelwerk.Regelwerk;
import de.verbund.watten.spiel.Spiel;
import de.verbund.watten.spiel.SpielRunde;
import de.verbund.watten.spieler.Spieler;

public class SpielTestBenni {

	private static Spieler sp1;
	private static Spieler sp2;

	@BeforeClass
	public static void zuBeginnAllerTests() {
		sp1 = new Spieler();
		sp2 = new Spieler();
	}

	public void testDantStiche() {
		Spiel spiel = new Spiel();

		spiel.setFarbe("Eichel");
		spiel.setSchlag("_10");

		Regelwerk rules = spiel.getRegeln();

		sp1.setGespielt(new Karte("Schelln", "_9"));
		sp2.setGespielt(new Karte("Herz", "_9"));
		sp1.setKommtRaus(true);
		sp2.setKommtRaus(false);
		SpielRunde runde = new SpielRunde(rules, sp1, sp2);
		int i = runde.werteAus();
		assertEquals(1, i);

		sp1.setGespielt(new Karte("Herz", "_9"));
		sp2.setGespielt(new Karte("Schelln", "_9"));
		sp1.setKommtRaus(true);
		sp2.setKommtRaus(false);
		runde = new SpielRunde(rules, sp1, sp2);
		i = runde.werteAus();
		assertEquals(1, i);

		sp1.setGespielt(new Karte("Blau", "_7"));
		sp2.setGespielt(new Karte("Herz", "_Sau"));
		sp1.setKommtRaus(true);
		sp2.setKommtRaus(false);
		runde = new SpielRunde(rules, sp1, sp2);
		i = runde.werteAus();
		assertEquals(1, i);

		sp1.setGespielt(new Karte("Blau", "_7"));
		sp2.setGespielt(new Karte("Blau", "_Sau"));
		sp1.setKommtRaus(true);
		sp2.setKommtRaus(false);
		runde = new SpielRunde(rules, sp1, sp2);
		i = runde.werteAus();
		assertEquals(2, i);
	}

	@Test
	public void testMehrfach() {
		for (int i = 0; i < 1000; i++) {
			testDantStiche();
		}
	}

	@Test
	public void gleicheFarbeTest() {

	}

}
