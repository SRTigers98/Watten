package de.verbund.watten.spiel;

import de.verbund.watten.karten.Karte;
import de.verbund.watten.regelwerk.Regelwerk;

public class SpielRunde {

	private Regelwerk regeln;
	private Karte sp1;
	private Karte sp2;
	private int sieger;
	private int amZug;

	public SpielRunde(Regelwerk regeln, Karte sp1, Karte sp2) {
		this.regeln = regeln;
		this.sp1 = sp1;
		this.sp2 = sp2;
	}

	public int werteAus() {
		return regeln.wertAus(sp1, sp2);
	}

	public Karte getSp1() {
		return sp1;
	}

	public void setSp1(Karte sp1) {
		this.sp1 = sp1;
	}

	public Karte getSp2() {
		return sp2;
	}

	public void setSp2(Karte sp2) {
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
