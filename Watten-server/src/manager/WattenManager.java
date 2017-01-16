package manager;

import server.WattenServer;
import spiel.Spiel;

public class WattenManager {

	private WattenServer server;
	private Spiel spiel;

	public WattenManager() {
		server = new WattenServer();
		spiel = new Spiel();
	}

	public WattenServer getServer() {
		return server;
	}

	public Spiel getSpiel() {
		return spiel;
	}

}
