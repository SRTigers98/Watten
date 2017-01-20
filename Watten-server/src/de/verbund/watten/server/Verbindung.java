package de.verbund.watten.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.exception.WattenException;
import de.verbund.watten.hilfe.Hilfe;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.konstanten.KommandoKonst;
import de.verbund.watten.konstanten.MeldungKonst;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * Repräsentiert die Verbindung zwischen einem Client und dem Server.
 * 
 * @author Benjamin
 *
 */
public class Verbindung implements Runnable {

	private int id;
	private Socket socket;
	private WattenServer socketServer;
	private boolean ok = true;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Verbindung(Socket socket, WattenServer socketServer) {
		this.socket = socket;
		this.socketServer = socketServer;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			// Erzeuge Ausgabestrom zum Client
			out = new ObjectOutputStream(socket.getOutputStream());
			// Erzeuge Eingabestrom zum Client
			in = new ObjectInputStream(socket.getInputStream());
			while (ok) {
				// warte auf Input
				try {
					// es muss Serialisierbar sein
					Serializable gesendet = (Serializable) in.readObject();
					// Die Analyse des Objektes
					Serializable returnObj = verarbeite(gesendet);
					// R�ckgabe des Objektes
					out.writeObject(returnObj);
					socketServer.getOutput().outputNewLine("Connection found: " + socket.getRemoteSocketAddress());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SocketException s) {
					socketServer.getOutput().outputNewLine("Connection reset: " + socket.getRemoteSocketAddress());
					ok = false;
					socketServer.getManager().entferneSpieler(id);
					socketServer.getVerbindungen().remove(this);
				}
			}
			// beenden
			in.close();
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void sende(Kommando obj) {
		try {
			// Sende zum Client
			// Reset des Caches
			out.reset();
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Serializable verarbeite(Serializable gesendet) {
		Kommando kdo = null;
		if (gesendet instanceof Kommando) {
			kdo = (Kommando) gesendet;
		} else {
			// unerwarteter Fehler
			kdo = new Kommando();
			kdo.setReturnWert("Fehlerhafter Aufruf!");
		}
		if (kdo.getKommando().equals(KommandoKonst.BEENDE)) {
			ok = false;
		}
		if (kdo.getKommando().equals(KommandoKonst.SENDE_NAME)) {
			try {
				erhalteName(kdo);
			} catch (WattenException e) {
				kdo = Hilfe.getMeldungKommando(MeldungKonst.FEHLER, e.getMessage());
				sende(kdo);
				socketServer.getVerbindungen().remove(this);
			}
		}
		if (kdo.getKommando().equals(KommandoKonst.SPIELE_KARTE)) {
			spieleKarte(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.ANSAGE_SCHLAG)) {
			sagAnSchlag(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.ANSAGE_FARBE)) {
			sagAnFarbe(kdo);
		}

		return gesendet;
	}

	private void sagAnFarbe(Kommando kdo) {
		String farbe = kdo.getParameter().get(0).toString();
		socketServer.getManager().setzeFarbe(farbe);
	}

	private void sagAnSchlag(Kommando kdo) {
		String schlag = kdo.getParameter().get(0).toString();
		socketServer.getManager().setzeSchlag(schlag);
	}

	private void spieleKarte(Kommando kdo) {
		Karte karte = (Karte) kdo.getParameter().get(0);
		socketServer.getManager().spieleKarte(id, karte);
	}

	private void erhalteName(Kommando kdo) throws WattenException {
		if (socketServer.getManager().getSpiel().getSpieler().size() >= 2) {
			throw new WattenException("Server ist voll!");
		}
		id = socketServer.holeId();
		Spieler spieler = new Spieler(id, kdo.getParameter().get(0).toString());
		socketServer.getManager().addSpieler(spieler);
		try {
			socketServer.getManager().starteSpiel();
		} catch (WattenException e) {
			Kommando kdo2 = Hilfe.getMeldungKommando(MeldungKonst.HINWEIS, e.getMessage());
			sende(kdo2);
		}
	}

	public void beende() {
		Kommando kdo = new Kommando();
		kdo.setKommando(KommandoKonst.BEENDE);
		try {
			out.writeObject(kdo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

}
