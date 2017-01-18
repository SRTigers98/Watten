package de.verbund.watten.client;

import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.karten.Karte;

public class ClientDummy implements Client {

	private WattenClient client;
	private ClientGUI clientGUI;

	public ClientDummy(ClientGUI gui) {
		clientGUI = gui;
		clientGUI.setClient(this);
		this.client = new WattenClient(clientGUI);
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
	}

	@Override
	public void sendeKarte(Karte karte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendeSchlag(String schlag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendeFarbe(String farbe) {
		// TODO Auto-generated method stub

	}

}
