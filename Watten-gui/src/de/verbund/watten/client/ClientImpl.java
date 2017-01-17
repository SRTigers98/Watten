package de.verbund.watten.client;

import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.common.Kommando;
import de.verbund.watten.karten.Karte;

public class ClientImpl implements Client {

	private WattenClient client;
	private ClientGUI clientGUI;

	public ClientImpl(ClientGUI gui) {
		clientGUI = gui;
		clientGUI.setClient(this);
		this.client = new WattenClient(clientGUI);
	}

	@Override
	public void sendeName(String name) {
		Kommando kdo = new Kommando();
		kdo.setKommando("setzeName");
		kdo.addParameter(name);
		client.sende(kdo);
	}

	public void sendeKarte(Karte karte) {
		Kommando kdo = new Kommando();
		kdo.setKommando("spieltKarte");
		kdo.addParameter(karte);
		client.sende(kdo);
	}

	@Override
	public void sendeSchlag(String schlag) {
		Kommando kdo = new Kommando();
		kdo.setKommando("ansageSchlag");
		kdo.addParameter(schlag);
		client.sende(kdo);
	}

	@Override
	public void sendeFarbe(String farbe) {
		Kommando kdo = new Kommando();
		kdo.setKommando("ansageFarbe");
		kdo.addParameter(farbe);
		client.sende(kdo);
	}

}
