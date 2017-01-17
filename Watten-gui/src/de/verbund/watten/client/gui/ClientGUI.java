package de.verbund.watten.client.gui;

import java.util.List;

import de.verbund.watten.client.Client;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.spieler.Spieler;

public interface ClientGUI {

	/**
	 * Gibt die empfangene Nahchricht dem Benutzer aus
	 * 
	 * @param message
	 *            die empfangene Nachricht
	 */
	public void ausgabe(int art, String message);

	/**
	 * Gibt die Handkarten des Spielers in einer Liste aus, wenn der Client
	 * diese vom Server empfängt
	 * 
	 * @return eine Liste mit den Handkarten des Spielers
	 */
	public void gibHandkarten(List<Karte> handkarten);

	/**
	 * Gibt die Spieler der aktuellen Partie in einer Liste
	 * 
	 * @return eine Liste mit den Spielern
	 */
	public void gibSpieler(List<Spieler> spieler);

	/**
	 * Setzt die Client-Referenz auf den entsprechenden Client
	 * 
	 * @param client
	 */
	public void setClient(Client client);

}
