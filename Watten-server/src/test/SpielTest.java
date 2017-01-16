package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import karten.Karte;
import karten.Kartendeck;
import spiel.Spiel;
import spieler.Spieler;


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
	public void testDeck() {
		
	}
	
	
	@Test
	public void testTeileAus() {
		//Handkartenzahl sollte 5 sein
		Spiel spiel = new Spiel();
		List<Spieler> spieler = spiel.getSpieler();
		
		System.out.println();
		
		spieler.add(sp1);
		spieler.add(sp2);
		
		spiel.teileAus();
		assertEquals(5, sp1.getHand().size());
		assertEquals(5, sp2.getHand().size());
		
		System.out.println(spiel.getDeck());
		
		
		
		//Handkarten sollten sich unterscheiden
		for ( int i = 0; i< sp1.getHand().size() ; i++ ){
			Karte karte = sp1.getHand().get(i);
			System.out.println(karte);
		}
		
//		assertNotEquals(, );
		
		
	}

//TODO Iteration test teile aus

}
