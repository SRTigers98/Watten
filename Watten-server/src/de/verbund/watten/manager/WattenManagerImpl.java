package de.verbund.watten.manager;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.exception.WattenException;
import de.verbund.watten.hilfe.Hilfe;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.server.WattenServer;
import de.verbund.watten.spiel.Spiel;
import de.verbund.watten.spieler.Spieler;

public class WattenManagerImpl implements WattenManager {

	private WattenServer server;
	private Spiel spiel;

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
		spiel.getSpieler().add(spieler);
	}

	@Override
	public void spieleKarte(int id, Karte karte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void starteSpiel() throws WattenException {
		if (spiel.getSpieler().size() == 2) {
			// starte Spiel
			Kommando kdo = Hilfe.getMeldungKommando(3, "Spieler gefunden. Spiel startet.");
			server.sendeAnAlle(kdo);
		} else {
			throw new WattenException("Noch nicht genügend Spieler vorhanden!");
		}
	}

}
