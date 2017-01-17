package de.verbund.watten.client.gui;

import java.util.List;

import de.verbund.watten.karten.Karte;

public interface ClientGUI {

	/**
	 * Gibt die empfangene Nahchricht dem Benutzer aus
	 * 
	 * @param message
	 */
	public void ausgabe(String message);

	/**
	 * Gibt die Handkarten des Spielers in einer Liste aus, wenn der Client
	 * diese vom Server empfängt
	 * 
	 * @return eine Liste mit den Handkarten des Spielers
	 */
	public void gibHandkarten(List<Karte> handkarten);

}
