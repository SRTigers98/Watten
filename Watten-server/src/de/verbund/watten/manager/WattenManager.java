package de.verbund.watten.manager;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.spieler.Spieler;

public interface WattenManager {

	public void addSpieler(Spieler spieler);

	public void spieleKarte(int id, Karte karte);

}
