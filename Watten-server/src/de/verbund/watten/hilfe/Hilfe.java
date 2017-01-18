package de.verbund.watten.hilfe;

import de.verbund.watten.common.Kommando;

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

}
