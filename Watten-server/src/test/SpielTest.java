package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import karten.Karte;
import karten.Kartendeck;
import spiel.Spiel;
import spieler.Spieler;

public class SpielTest {

	private static Spieler sp1;
	private static Spieler sp2;
	private static int zaehler = 0;

	@BeforeClass
	public static void zuBeginnAllerTests() {
		System.out.println("Starte das Testen(Achte auf static!)");

		sp1 = new Spieler();
		sp2 = new Spieler();

	}

	@Test
	public void testTeileAus() {
		// Handkartenzahl sollte 5 sein
		Spiel spiel = new Spiel();
		List<Spieler> spieler = spiel.getSpieler();

		System.out.println();

		spieler.add(sp1);
		spieler.add(sp2);

		spiel.teileAus();
		assertEquals(5, sp1.getHand().size());
		assertEquals(5, sp2.getHand().size());

		for (int i = 0; i < sp1.getHand().size(); i++) {
			int n = 0;
			for (int j = i; j < sp1.getHand().size(); j++) {
				if (sp1.getHand().get(i).equals(sp1.getHand().get(j))) {
					n++;
				}
			}
			for (int j = 0; j < sp2.getHand().size(); j++) {
				if (sp1.getHand().get(i).equals(sp2.getHand().get(j))) {
					n++;
				}
			}
			for (int j = 0; j < sp2.getHand().size(); j++) {
				if (sp1.getHand().get(i).equals(spiel.getDeck().get(j))) {
					n++;
				}
				if (n < 1) {
					fail("Eine Karte mehrfach im Spiel!");
				}
			}
		}
	}

	@Test
	public void testDeck() {
		Spiel spiel = new Spiel();
		List<Karte> deck = spiel.getDeck();
		for (int i = 0; i < deck.size(); i++) {
			int n = 0;
			for (int j = i; j < deck.size(); j++) {
				if (deck.get(i).equals(deck.get(j))) {
					n++;
				}
			}
			if (n < 1) {
				fail("Eine Karte mehrfach im Deck!");
			}
		}
	}

}
