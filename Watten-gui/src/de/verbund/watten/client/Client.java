package de.verbund.watten.client;

public interface Client {

	/**
	 * Sendet den Namen des Spielers an den Server
	 * 
	 * @param name
	 *            der zu übermittelnde Name des Spielers
	 */
	public void sendeName(String name);

}
