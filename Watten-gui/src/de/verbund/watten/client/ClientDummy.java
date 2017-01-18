package de.verbund.watten.client;

import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.konstanten.MeldungKonst;
import de.verbund.watten.spieler.Spieler;

public class ClientDummy implements Client {

	private WattenClient client;
	private ClientGUI clientGUI;

	public ClientDummy(ClientGUI gui) {
		clientGUI = gui;
		clientGUI.setClient(this);
		client = null;
	}

	@Override
	public void sendeName(String name) {
		List<Karte> handkarten = new ArrayList<>();
		handkarten.add(new Karte("Schelln", "_Sau"));
		handkarten.add(new Karte("Blau", "_Sau"));
		handkarten.add(new Karte("Herz", "_Sau"));
		handkarten.add(new Karte("Eichel", "_Sau"));
		handkarten.add(new Karte("Herz", "_Koenig"));
		clientGUI.gibHandkarten(handkarten);
		List<Spieler> spieler = new ArrayList<>();
		spieler.add(new Spieler(0, "Test1"));
		spieler.add(new Spieler(1, "Test2"));
		clientGUI.gibSpieler(spieler);
		clientGUI.amZug(0, true);
	}

	@Override
	public void sendeKarte(Karte karte) {
		clientGUI.ausgabe(MeldungKonst.HINWEIS, "Karte erfolgreich gesendet!");
	}

	@Override
	public void sendeSchlag(String schlag) {
		clientGUI.gibSchlag(schlag);
		clientGUI.gibFarbe("Herz");
		clientGUI.amZug(0, false);
	}

	@Override
	public void sendeFarbe(String farbe) {
		// kommt in diesem Dummy nicht vor
		clientGUI.gibSchlag("_Koenig");
		clientGUI.gibFarbe(farbe);
		clientGUI.amZug(0, false);
	}

}
