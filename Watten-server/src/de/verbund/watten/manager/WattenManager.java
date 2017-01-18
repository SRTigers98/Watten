package de.verbund.watten.manager;

import de.verbund.watten.exception.WattenException;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * Die zentrale Datenklasse im Service. Sie verwaltet alle Eingaben der Clients
 * und verwaltet das Spiel.
 * 
 * @author Benjamin
 *
 */
public interface WattenManager {

	public void addSpieler(Spieler spieler);

	public void spieleKarte(int id, Karte karte);

	public void sendeHandkarten();

	public void starteSpiel() throws WattenException;

	public void setzeSchlag(String schlag);

	public void setzeFarbe(String farbe);

	public void entferneSpieler(int id);

}
