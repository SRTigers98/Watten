package spiel;

import karten.Karte;

public class SpielRunde {

	private static final int SPIELER_1 = 1;
	private static final int SPIELER_2 = 2;

	private Karte sp1;
	private Karte sp2;
	private int sieger;

	public SpielRunde(Karte sp1, Karte sp2) {
		this.sp1 = sp1;
		this.sp2 = sp2;
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

}
