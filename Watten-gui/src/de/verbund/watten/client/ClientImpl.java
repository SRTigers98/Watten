package de.verbund.watten.client;

import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.common.Kommando;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.konstanten.KommandoKonst;

public class ClientImpl implements Client {

	private WattenClient client;
	private ClientGUI clientGUI;

	public ClientImpl(ClientGUI gui, String ip, int port) {
		clientGUI = gui;
		clientGUI.setClient(this);
		this.client = new WattenClient(clientGUI, ip, port);
	}

	@Override
	public void sendeName(String name) {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.SENDE_NAME);
		kdo.addParameter(name);
		client.sende(kdo);
	}

	public void sendeKarte(Karte karte) {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.SPIELE_KARTE);
		kdo.addParameter(karte);
		client.sende(kdo);
	}

	@Override
	public void sendeSchlag(String schlag) {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.ANSAGE_SCHLAG);
		kdo.addParameter(schlag);
		client.sende(kdo);
	}

	@Override
	public void sendeFarbe(String farbe) {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.ANSAGE_FARBE);
		kdo.addParameter(farbe);
		client.sende(kdo);
	}

}
