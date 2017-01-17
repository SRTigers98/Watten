package de.verbund.watten.manager;

import java.util.List;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.server.WattenServer;
import de.verbund.watten.spiel.Spiel;
import de.verbund.watten.spieler.Spieler;

public class WattenManagerImpl implements WattenManager {

	private WattenServer server;
	private Spiel spiel;
	private List<Integer> ids;

	public WattenManagerImpl(WattenServer server) {
		this.server = server;
		spiel = new Spiel();
	}

	public WattenServer getServer() {
		return server;
	}

	public Spiel getSpiel() {
		return spiel;
	}

	@Override
	public void addSpieler(Spieler spieler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void spieleKarte(int id, Karte karte) {
		// TODO Auto-generated method stub

	}

}
