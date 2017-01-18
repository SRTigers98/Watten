package de.verbund.watten.client;

import de.verbund.watten.karten.Karte;

/**
 * 
 * Die Klasse, die die Daten, die die Client-Anwendung zu übermitteln hat, an
 * den Server sendet.
 * 
 * @author Benjamin
 *
 */
public interface Client {

	/**
	 * Sendet den Namen des Spielers an den Server
	 * 
	 * @param name
	 *            der zu übermittelnde Name des Spielers
	 */
	public void sendeName(String name);

	/**
	 * Sendet die ausgespielte Karte an den Server
	 * 
	 * @param karte
	 */
	public void sendeKarte(Karte karte);

	/**
	 * Sendet den angesagten Schlag an den Server
	 * 
	 * @param schlag
	 */
	public void sendeSchlag(String schlag);

	/**
	 * Sendet die angesagte Farbe an den Server
	 * 
	 * @param farbe
	 */
	public void sendeFarbe(String farbe);

}
