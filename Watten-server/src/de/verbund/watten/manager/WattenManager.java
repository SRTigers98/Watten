package de.verbund.watten.manager;

import de.verbund.watten.exception.WattenException;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.spieler.Spieler;

public interface WattenManager {

	public void addSpieler(Spieler spieler);

	public void spieleKarte(int id, Karte karte);

	public void sendeHandkarten();

	public void starteSpiel() throws WattenException;

	public void entferneSpieler(int id);

}
