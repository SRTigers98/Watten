package de.verbund.watten.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.regelwerk.Regelwerk;
import de.verbund.watten.spiel.Spiel;
import de.verbund.watten.spieler.Spieler;

public class SpielTestBenni {

	private static Spieler sp1;
	private static Spieler sp2;

	@BeforeClass
	public static void zuBeginnAllerTests() {
		sp1 = new Spieler();
		sp2 = new Spieler();
	}

	@Test
	public void testDantStiche() {
		Spiel spiel = new Spiel();

		spiel.setFarbe("Eichel");
		spiel.setSchlag("_10");

		Regelwerk rules = spiel.getRegeln();

		sp1.setGespielt(new Karte("Schelln", "_9"));
		sp2.setGespielt(new Karte("Herz", "_9"));
		int i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);

		sp1.setGespielt(new Karte("Herz", "_9"));
		sp2.setGespielt(new Karte("Schelln", "_9"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);

		sp1.setGespielt(new Karte("Blau", "_7"));
		sp2.setGespielt(new Karte("Herz", "_Sau"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
	}

}
