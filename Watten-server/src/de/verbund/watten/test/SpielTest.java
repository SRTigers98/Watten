package de.verbund.watten.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.regelwerk.Regelwerk;
import de.verbund.watten.spiel.Spiel;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * @author Fabian
 * JUnit Tests für:
 * testTeileAus, jede Karte nur 1 mal, 5 Handkarten pro Spieler
 * testDeck, jede Karte nur 1 mal
 * testSchlag, erste Dummy tests für Stich Auswertungen
 * testRegelwerk, Regelwerk Size, Doppelte Karten
 *
 */


public class SpielTest {

	private static Spieler sp1;
	private static Spieler sp2;

	@BeforeClass
	public static void zuBeginnAllerTests() {
		System.out.println("Starte das Testen(Achte auf static!)");

		sp1 = new Spieler();
		
		sp2 = new Spieler();
		

	}

	@Test
	public void testTeileAus() {
		// Handkartenzahl sollte 5 sein
		// Handkarten kommen nicht doppelt vor
		Spiel spiel = new Spiel();
		List<Spieler> spieler = spiel.getSpieler();

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
		// Jede Karte nur einmal vorhanden
		// Deck = 32 Karten
		Spiel spiel = new Spiel();
		spiel.getSpieler();
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
		if (deck.size() != 32) {
			fail("Deckgröße falsch!");
		}
	}
	
	@Test
	public void testRegelnMoeglicherBug(){
		Spiel spiel = new Spiel();
		
		spiel.setFarbe("Blau");
		spiel.setSchlag("_10");
		
		Regelwerk rules = spiel.getRegeln();
		
		sp1.setGespielt(new Karte("Blau", "_7"));
		sp2.setGespielt(new Karte("Blau", "_8"));
		int i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(2, i);
	}
	
	
	
	
	@Test
	public void testSchlag(){
		Spiel spiel = new Spiel();
		spiel.getSpieler();
		List<Karte> deck = spiel.getDeck();
		
		spiel.setFarbe("Schelln");
		spiel.setSchlag("_10");
		Regelwerk rules = spiel.getRegeln();
		
		sp1.setGespielt(new Karte("Herz", "_Koenig"));
		sp2.setGespielt(new Karte("Schelln", "_Koenig"));
		
		int i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
		
		sp1.setGespielt(new Karte("Herz", "_10"));
		sp2.setGespielt(new Karte("Schelln", "_10"));
		
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(2, i);
		

		sp1.setGespielt(new Karte("Schelln", "_10"));
		sp2.setGespielt(new Karte("Schelln", "_Sau"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
		
		sp1.setGespielt(new Karte("Blau", "_10"));
		sp2.setGespielt(new Karte("Herz", "_10"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
		
		sp1.setGespielt(new Karte("Schelln", "_8"));
		sp2.setGespielt(new Karte("Blau", "_10"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(2, i);
		
		sp1.setGespielt(new Karte("Schelln", "_8"));
		sp2.setGespielt(new Karte("Blau", "_Sau"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
		
		sp1.setGespielt(new Karte("Herz", "_Unter"));
		sp2.setGespielt(new Karte("Blau", "_Sau"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
		
		sp1.setGespielt(new Karte("Blau", "_Sau"));
		sp2.setGespielt(new Karte("Herz", "_Unter"));
		i = rules.werteAus(sp1.getGespielt(), sp2.getGespielt());
		assertEquals(1, i);
	

	}
	
	@Test
	public void testMasse (){
		System.out.println("Case 1  Schelln_7");
		testRegelwerk("Schelln", "_7");
		System.out.println("erfolgreich\nCase2 Herz_Koenig");
		testRegelwerk("Herz", "_Koenig");
		System.out.println("erfolgreich\nCase3 Blau_10");
		testRegelwerk("Blau", "_10");
		System.out.println("erfolgreich");
		
	}
	
	
	
	
	
	public void testRegelwerk(String farbe, String schlag ){	
	
		
		Regelwerk rules = new Regelwerk(farbe, schlag);
		
		assertEquals(32, rules.getRegelwerk().size());
		
		Map<String, Integer> testRegeln = rules.getRegelwerk();		
		System.out.println(testRegeln);
		Set<String> keys = testRegeln.keySet();
		
		for (String string : keys) {
			int n=0;
			if (keys.contains(string)){
				n++;
			}
			if (n>1){
				fail("Karte mehrfach im Regelwerk");
			}
		}
		int i = testRegeln.get("Herz_Koenig");
		assertEquals(100, i);
		
		if (!(farbe+schlag).equals("Herz_Koenig")  && !(farbe+schlag).equals("Schelln_7") && !(farbe+schlag).equals("Eichel_7")){
			i = testRegeln.get(farbe+schlag);
			assertEquals(94, i);
		}
		
				
		System.out.println("Regelwerk");
		
		


		
	}

}
