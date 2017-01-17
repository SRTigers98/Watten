package de.verbund.watten.server;

import java.io.IOException;

public class StartServer {

	public static void main(String[] args) throws IOException {
		// TODO GUI zur Serversteuerung
		WattenServer server = new WattenServer();
		System.in.read();
		System.exit(0);
	}

}
