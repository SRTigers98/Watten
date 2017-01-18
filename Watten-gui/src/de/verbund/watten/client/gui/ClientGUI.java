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
	 * @param eine
	 *            Liste mit den Handkarten des Spielers
	 */
	public void gibHandkarten(List<Karte> handkarten);

	/**
	 * Gibt die Spieler der aktuellen Partie in einer Liste
	 * 
	 * @param eine
	 *            Liste mit den Spielern
	 */
	public void gibSpieler(List<Spieler> spieler);

	/**
	 * Gibt die ID des Spielers der in der aktuellen Runde als erster am Zug ist
	 * 
	 * @param die
	 *            ID
	 */
	public void amZug(int id);

	/**
	 * Setzt die Client-Referenz auf den entsprechenden Client
	 * 
	 * @param client
	 */
	public void setClient(Client client);

}
