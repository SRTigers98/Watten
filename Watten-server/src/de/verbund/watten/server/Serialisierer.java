package de.verbund.watten.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * Ist für die Serialisierung der Objekte zuständig.
 * 
 * @author Friedrich
 *
 */
public class Serialisierer {

	public static Object lese(String dateiName) throws Exception {
		Object o = null;
		FileInputStream fIn = new FileInputStream(dateiName);
		ObjectInputStream oIn = new ObjectInputStream(fIn);

		o = oIn.readObject();
		oIn.close();
		return o;
	}

	public static void schreibe(Object o, String dateiName) throws Exception {
		FileOutputStream fOut = new FileOutputStream(dateiName);
		ObjectOutputStream oOut = new ObjectOutputStream(fOut);

		oOut.writeObject(o);
		oOut.flush();
		oOut.close();
	}

}
