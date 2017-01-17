package de.verbund.watten.spiel;

import de.verbund.watten.regelwerk.Regelwerk;
import de.verbund.watten.spieler.Spieler;

public class SpielRunde {

	private Regelwerk regeln;
	private Spieler sp1;
	private Spieler sp2;
	private int sieger;
	private int amZug;

	public SpielRunde(Regelwerk regeln, Spieler sp1, Spieler sp2) {
		this.regeln = regeln;
		this.sp1 = sp1;
		this.sp2 = sp2;
	}

	public int werteAus() {
		return regeln.wertAus(sp1.getGespielt(), sp2.getGespielt());
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

	public int getAmZug() {
		return amZug;
	}

	public void setAmZug(int amZug) {
		this.amZug = amZug;
	}

}
