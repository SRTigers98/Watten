package de.verbund.watten.server;

public class StartServer {

	public static void main(String[] args) {
		// TODO GUI zur Serversteuerung
		WattenServer server = new WattenServer();
		while (server.isRun()) {
			// Halte den Server am Leben
		}
	}

}
