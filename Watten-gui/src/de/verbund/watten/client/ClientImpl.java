package de.verbund.watten.client;

import de.verbund.watten.common.Kommando;

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

}
