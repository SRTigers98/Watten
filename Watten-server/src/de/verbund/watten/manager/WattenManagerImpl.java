package de.verbund.watten.manager;

import de.verbund.watten.server.WattenServer;
import de.verbund.watten.spiel.Spiel;

public class WattenManagerImpl implements WattenManager {

	private WattenServer server;
	private Spiel spiel;

	public WattenManagerImpl() {
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
