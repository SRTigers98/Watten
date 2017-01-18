package de.verbund.watten.hilfe;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.konstanten.KommandoKonst;

/**
 * 
 * Eine Hilfsklasse für diverse statische Methoden.
 * 
 * @author Benjamin
 *
 */
public class Hilfe {

	public static Kommando getMeldungKommando(int art, String message) {
		Kommando kdo = new Kommando();
		kdo.setKommando("text");
		kdo.addParameter(art);
		kdo.addParameter(message);
		return kdo;
	}

	public static Kommando getMeldungAmZug(boolean schlag) {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.AM_ZUG);
		kdo.addParameter(schlag);
		return kdo;
	}

	public static Kommando getMeldungAmZug() {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.AM_ZUG);
		return kdo;
	}

}
