package de.verbund.watten.client.gui;

import java.util.List;

import de.verbund.watten.client.Client;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * Das Interface, dass die empfangenen Daten vom Server an die GUI-Applikation
 * übermittelt. Die Implementation liegt in der GUI selbst.
 * 
 * @author Benjamin
 *
 */
public interface ClientGUI {

	/**
	 * Gibt die empfangene Nahchricht dem Benutzer aus.
	 * 
	 * @param message
	 *            die empfangene Nachricht
	 */
	public void ausgabe(int art, String message);

	/**
	 * Gibt die Handkarten des Spielers in einer Liste aus, wenn der Client
	 * diese vom Server empfängt.
	 * 
	 * @param eine
	 *            Liste mit den Handkarten des Spielers
	 */
	public void gibHandkarten(List<Karte> handkarten);

	/**
	 * Gibt die Spieler der aktuellen Partie in einer Liste.
	 * 
	 * @param eine
	 *            Liste mit den Spielern
	 */
	public void gibSpieler(List<Spieler> spieler);

	/**
	 * Teilt mit, wenn der Spieler am Zug ist, er ansagen muss und was er
	 * ansagen muss.
	 * 
	 * @param die
	 *            ID
	 */
	public void amZug(boolean schlag);

	/**
	 * 
	 * Teilt mit, dass der Spieler am Zug ist.
	 */
	public void amZug();

	/**
	 * 
	 * Gibt den angesaten Schlag in diesem Spiel.
	 * 
	 * @param schlag
	 */
	public void gibSchlag(String schlag);

	/**
	 * 
	 * Gibt die angesagte Farbe in diesem Spiel.
	 * 
	 * @param farbe
	 */
	public void gibFarbe(String farbe);

	/**
	 * Setzt die Client-Referenz auf den entsprechenden Client.
	 * 
	 * @param client
	 */
	public void setClient(Client client);

	/**
	 * 
	 * Gibt die Karte, die ein Gegener gespielt hat.
	 * 
	 * @param ID
	 *            des Spielers, der die Karte gespielt hat
	 * @param Karte,
	 *            die der Gegner gespielt hat
	 */
	public void gibGegnerKarte(int i, Karte karte);

}
