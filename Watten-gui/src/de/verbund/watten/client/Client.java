package de.verbund.watten.client;

import de.verbund.watten.karten.Karte;

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

}
