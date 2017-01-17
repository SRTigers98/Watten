package de.verbund.watten.client.gui;

import java.util.List;

import de.verbund.watten.karten.Karte;

public class ClientGUIImpl implements ClientGUI {

	private String message;
	private List<Karte> handkarten;

	@Override
	public void ausgabe(String message) {
		this.message = message;
	}

	@Override
	public void gibHandkarten(List<Karte> handkarten) {
		this.handkarten = handkarten;
	}

	public String getMessage() {
		return message;
	}

	public List<Karte> getHandkarten() {
		return handkarten;
	}

}
