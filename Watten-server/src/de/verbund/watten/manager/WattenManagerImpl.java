package de.verbund.watten.manager;

import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.exception.WattenException;
import de.verbund.watten.hilfe.Hilfe;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.konstanten.KommandoKonst;
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
		int naechsterID = -1;
		for (int i = 0; i < spiel.getSpieler().size(); i++) {
			Spieler s = spiel.getSpieler().get(i);
			if (s.getId() == id) {
				s.setGespielt(karte);
				if ((i + 1) == spiel.getSpieler().size()) {
					naechsterID = spiel.getSpieler().get(0).getId();
				} else {
					naechsterID = spiel.getSpieler().get(i + 1).getId();
				}
			}
		}
		sendeKarteAnAlle(id, karte);
		boolean alleGespielt = true;
		for (Spieler s : spiel.getSpieler()) {
			if (s.getGespielt() == null) {
				alleGespielt = false;
			}
		}
		if (alleGespielt) {
			try {
				int siegerID = spiel.werteAus();
				sendeSpieler();
				Kommando kdo = Hilfe.getMeldungAmZug();
				for (Verbindung v : server.getVerbindungen()) {
					if (v.getId() == siegerID) {
						v.sende(kdo);
					}
				}
				if (spielEnde()) {
					for (Verbindung v : server.getVerbindungen()) {
						Kommando kdo2 = new Kommando();
						kdo2.setKommando(KommandoKonst.SPIEL_ENDE);
						for (Spieler s : spiel.getSpieler()) {
							if (v.getId() == s.getId()) {
								kdo2.addParameter(s.isSieger());
							}
						}
						v.sende(kdo2);
					}
				}
			} catch (WattenException e) {
				Kommando kdo = Hilfe.getMeldungKommando(MeldungKonst.FEHLER, e.getMessage());
				server.sendeAnAlle(kdo);
			}
		} else {
			for (Verbindung v : server.getVerbindungen()) {
				if (v.getId() == naechsterID) {
					Kommando kdo = Hilfe.getMeldungAmZug();
					v.sende(kdo);
				}
			}
		}
	}

	@Override
	public boolean spielEnde() {
		int stiche = 0;
		for (Spieler s : spiel.getSpieler()) {
			stiche += s.getStiche();
		}
		boolean ende = (stiche == 5);
		if (ende) {
			for (Spieler s : spiel.getSpieler()) {
				s.setStiche(0);
			}
		}
		return ende;
	}

	private void sendeKarteAnAlle(int id, Karte karte) {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.SENDE_GEGNER_KARTE);
		kdo.addParameter(id);
		kdo.addParameter(karte);
		for (Verbindung v : server.getVerbindungen()) {
			if (v.getId() != id) {
				v.sende(kdo);
			}
		}
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
	public void sendeSpieler() {
		for (Verbindung v : server.getVerbindungen()) {
			Kommando kdo = new Kommando();
			kdo.setKommando(KommandoKonst.SENDE_SPIELER);
			List<Spieler> spieler = new ArrayList<>();
			int index = -1;
			for (int i = 0; i < spiel.getSpieler().size(); i++) {
				if (v.getId() == spiel.getSpieler().get(i).getId()) {
					index = i;
				}
			}
			spieler = spielerListeDrehen(spieler, index);
			for (Spieler s : spieler) {
				kdo.addParameter(s);
			}
			v.sende(kdo);
		}
	}

	private List<Spieler> spielerListeDrehen(List<Spieler> spieler, int index) {
		for (int i = 0; i < spiel.getSpieler().size(); i++) {
			spieler.add(spiel.getSpieler().get(index));
			index++;
			if (index == spiel.getSpieler().size()) {
				index = 0;
			}
		}
		return spieler;
	}

	@Override
	public void starteSpiel() throws WattenException {
		if (spiel.getSpieler().size() == 2) {
			for (Spieler s : spiel.getSpieler()) {
				s.setSieger(false);
			}
			spiel.getSpieler().get(0).setKommtRaus(true);
			sendeSpieler();
			spiel.teileAus();
			sendeHandkarten();
			int id = spiel.getSpieler().get(0).getId();
			Kommando kdo = Hilfe.getMeldungAmZug(true);
			for (Verbindung v : server.getVerbindungen()) {
				if (v.getId() == id) {
					v.sende(kdo);
				}
			}
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
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.SENDE_SCHLAG);
		kdo.addParameter(schlag);
		server.sendeAnAlle(kdo);
		int id = spiel.getSpieler().get(0).getId();
		kdo = Hilfe.getMeldungAmZug(false);
		for (int i = 0; i < server.getVerbindungen().size(); i++) {
			if (server.getVerbindungen().get(i).getId() == id) {
				if ((i + 1) == server.getVerbindungen().size()) {
					server.getVerbindungen().get(0).sende(kdo);
				} else {
					server.getVerbindungen().get(i + 1).sende(kdo);
				}
				break;
			}
		}
	}

	@Override
	public void setzeFarbe(String farbe) {
		spiel.setFarbe(farbe);
		spiel.getRegeln();
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.SENDE_FARBE);
		kdo.addParameter(farbe);
		server.sendeAnAlle(kdo);
		int id = spiel.getSpieler().get(0).getId();
		kdo = Hilfe.getMeldungAmZug();
		for (Verbindung v : server.getVerbindungen()) {
			if (v.getId() == id) {
				v.sende(kdo);
			}
		}
	}

	public void pruefeAnfrage(Kommando kdo) {
		boolean neuesSpiel = true;
		for (Verbindung v : server.getVerbindungen()) {
			if (!v.isNeuesSpiel()) {
				neuesSpiel = false;
			}
		}
		if (neuesSpiel) {
			kdo.setReturnWert(true);
			server.sendeAnAlle(kdo);
			for (Verbindung v : server.getVerbindungen()) {
				v.setNeuesSpiel(false);
			}
			Spiel newSpiel = new Spiel();
			newSpiel.getSpieler().addAll(spielerListeDrehen(spiel.getSpieler(), 0));
			spiel = newSpiel;
			try {
				starteSpiel();
			} catch (WattenException e) {
				// Kann nicht passieren
				e.printStackTrace();
			}
		}
	}

}
