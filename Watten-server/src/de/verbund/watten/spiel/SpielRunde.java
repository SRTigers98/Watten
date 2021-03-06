package de.verbund.watten.spiel;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.regelwerk.Regelwerk;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * Speichert die gespielten Karten einer Runde und ermittelt den Sieger.
 * 
 * @author Benjamin
 *
 */
public class SpielRunde {

	private Regelwerk regeln;
	private Spieler sp1;
	private Spieler sp2;
	private int sieger;

	public SpielRunde(Regelwerk regeln, Spieler sp1, Spieler sp2) {
		this.regeln = regeln;
		this.sp1 = sp1;
		this.sp2 = sp2;
	}

	public int werteAus() {
		Karte k1 = null;
		Karte k2 = null;
		if (sp1.isKommtRaus()) {
			k1 = sp1.getGespielt();
			k2 = sp2.getGespielt();
		} else {
			k1 = sp2.getGespielt();
			k2 = sp1.getGespielt();
		}
		sieger = regeln.werteAus(k1, k2);
		// Für Test
		if (sieger == 0) {
			return sieger;
		}
		if (sp2.isKommtRaus()) {
			if (sieger == 1) {
				sieger = 2;
			} else {
				sieger = 1;
			}
		}
		if (sieger == 1) {
			sp1.setKommtRaus(true);
			sp2.setKommtRaus(false);
		} else {
			sp1.setKommtRaus(false);
			sp2.setKommtRaus(true);
		}
		sp1.setGespielt(null);
		sp2.setGespielt(null);
		return sieger;
	}

	public Spieler getSp1() {
		return sp1;
	}

	public void setSp1(Spieler sp1) {
		this.sp1 = sp1;
	}

	public Spieler getSp2() {
		return sp2;
	}

	public void setSp2(Spieler sp2) {
		this.sp2 = sp2;
	}

	public int getSieger() {
		return sieger;
	}

	public void setSieger(int sieger) {
		this.sieger = sieger;
	}

}
