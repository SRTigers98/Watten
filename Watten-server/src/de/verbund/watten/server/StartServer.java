package de.verbund.watten.server;

import java.io.IOException;

/**
 * 
 * Startet den Server und hält ihn so lange am Leben, wie keine Eingabe in der
 * Konsole erfolgt.
 * 
 * @author Benjamin
 *
 */
public class StartServer {

	public static void main(String[] args) throws IOException {
		// TODO GUI zur Serversteuerung
		WattenServer server = new WattenServer();
		System.out.println("Server startup");
		System.in.read();
		System.out.println("Server shutdown");
		System.exit(0);
	}

}
