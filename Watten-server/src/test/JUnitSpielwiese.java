package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitSpielwiese {

	@Before
	public void vorJedemTest() {
		System.out.println("Vor jedem Test");
	}
	@BeforeClass
	public static void zuBeginnAllerTests() {
		System.out.println("Starte das Testen (Achte auf static!)");
	}
	
	@After
	public void nachJedemTest() {
		System.out.println("Nach jedem Test");
	}
	@AfterClass
	public static void nachAllerTests() {
		System.out.println("Testen beendet (Achte auf static!)");
	}
	
	@Test
	public void testEinfachMalSoEinBisserlWas() {
		String etwas = null;
		assertNull(etwas);
	}
	
	@Test
	public void fuerEinFail(){
		int i = 3;
		
		if (i > 3) {
			fail("Hier sollte er nicht hin kommen!");
		}
		
		String nuller = null;
		
		try {
			nuller.length();
			fail("Sollte Ex werfen!");
		} catch (NullPointerException e) {
			// ok
		}
		
	}
}
