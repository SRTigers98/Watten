package de.verbund.watten.client;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.karten.Karte;

public class ClientImpl implements Client {

	private WattenClient client;

	public ClientImpl(WattenClient client) {
		this.client = client;
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

}
