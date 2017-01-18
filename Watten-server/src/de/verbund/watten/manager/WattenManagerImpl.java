package de.verbund.watten.manager;

import java.util.List;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.exception.WattenException;
import de.verbund.watten.hilfe.Hilfe;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.konstanten.MeldungKonst;
import de.verbund.watten.server.Verbindung;
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
	public void sendeHandkarten() {
		for (Spieler s : spiel.getSpieler()) {
			List<Karte> hand = s.getHand();
			int id = s.getId();
			Kommando kdo = new Kommando();
			kdo.setKommando("sendeHandkarten");
			for (Karte k : hand) {
				kdo.addParameter(k);
			}
			for (Verbindung v : server.getVerbindungen()) {
				if (v.getId() == id) {
					v.sende(kdo);
				}
			}
		}
	}

	@Override
	public void starteSpiel() throws WattenException {
		if (spiel.getSpieler().size() == 2) {
			// starte Spiel
			spiel.teileAus();
			Kommando kdo = Hilfe.getMeldungKommando(MeldungKonst.HINWEIS, "Spieler gefunden. Spiel startet.");
			server.sendeAnAlle(kdo);
		} else {
			throw new WattenException("Noch nicht genügend Spieler vorhanden!");
		}
	}

	@Override
	public void entferneSpieler(int id) {
		Spieler sp = null;
		for (Spieler s : spiel.getSpieler()) {
			if (s.getId() == id) {
				sp = s;
			}
		}
		spiel.getSpieler().remove(sp);
	}

	@Override
	public void setzeSchlag(String schlag) {
		spiel.setSchlag(schlag);
	}

	@Override
	public void setzeFarbe(String farbe) {
		spiel.setFarbe(farbe);
		spiel.getRegeln();
	}

}
