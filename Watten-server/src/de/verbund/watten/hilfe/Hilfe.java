package de.verbund.watten.hilfe;

import de.verbund.watten.common.Kommando;

public class Hilfe {

	public static Kommando getMeldungKommando(int art, String message) {
		Kommando kdo = new Kommando();
		kdo.setKommando("text");
		kdo.addParameter(art);
		kdo.addParameter(message);
		return kdo;
	}

}
