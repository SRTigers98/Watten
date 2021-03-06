package de.verbund.watten.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.common.Kommando;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.konstanten.KommandoKonst;
import de.verbund.watten.konstanten.MeldungKonst;
import de.verbund.watten.spieler.Spieler;

/**
 * 
 * Kommuniziert mit dem Server. Diese Klasse sendet und empfängt die Daten vom
 * Server.
 * 
 * @author Benjamin
 *
 */
public class WattenClient implements Runnable {

	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	private ClientGUI clientGUI;
	private boolean ok = true;

	public WattenClient(ClientGUI clientGUI, String ip, int port) {
		// Baue Verbindung zum Server auf
		this.clientGUI = clientGUI;
		try {
			socket = new Socket(ip, port);
			// Erzeuge Ausgabestrom
			out = new ObjectOutputStream(socket.getOutputStream());
			// Erzeuge Eingabestrom
			in = new ObjectInputStream(socket.getInputStream());
			// Thread erzeugen und starten
			Thread t = new Thread(this);
			t.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sende(Kommando obj) {
		try {
			// Sende zum Server
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void beende() {
		try {
			Kommando kdo = new Kommando();
			kdo.setKommando(KommandoKonst.BEENDE);
			sende(kdo);
			// und Ressourcen frei geben
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// Erzeuge Ausgabestrom zum Client
		while (ok) {
			// warte auf Input
			try {
				// es muss Serialisierbar sein
				Serializable gesendet = (Serializable) in.readObject();
				// Die Analyse des Objektes
				verarbeite(gesendet);
			} catch (ClassNotFoundException e) {
				clientGUI.ausgabe(MeldungKonst.FEHLER, "Fehler beim Lesen: " + e.getMessage());
				e.printStackTrace();
			} catch (SocketException e) {
				clientGUI.ausgabe(MeldungKonst.FEHLER, "Server nicht mehr erreichbar!");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void verarbeite(Serializable gesendet) {
		Kommando kdo = (Kommando) gesendet;
		if (kdo.getKommando().equals(KommandoKonst.TEXT)) {
			clientGUI.ausgabe((int) kdo.getParameter().get(0), kdo.getParameter().get(1).toString());
		}
		if (kdo.getKommando().equals(KommandoKonst.SENDE_HANDKARTEN)) {
			verteileHandkarten(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.SENDE_SCHLAG)) {
			verteileSchlag(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.SENDE_FARBE)) {
			verteileFarbe(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.SENDE_SPIELER)) {
			verteileSpieler(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.AM_ZUG)) {
			amZug(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.SENDE_GEGNER_KARTE)) {
			gegnerKarte(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.SPIEL_ENDE)) {
			spielEnde(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.FEHLER)) {
			fehler(kdo);
		}
		if (kdo.getKommando().equals(KommandoKonst.NEUES_SPIEL)) {
			erhalteAntwort(kdo);
		}
	}

	private void erhalteAntwort(Kommando kdo) {
		if ((boolean) kdo.getReturnWert()) {
			clientGUI.neuesSpiel();
		}
	}

	private void fehler(Kommando kdo) {
		clientGUI.fehler(kdo.getParameter().get(0).toString());
	}

	private void spielEnde(Kommando kdo) {
		clientGUI.spielEnde((boolean) kdo.getParameter().get(0));
	}

	private void gegnerKarte(Kommando kdo) {
		clientGUI.gibGegnerKarte((int) kdo.getParameter().get(0), (Karte) kdo.getParameter().get(1));
	}

	private void amZug(Kommando kdo) {
		boolean schlag = false;
		boolean parameter = false;
		if (kdo.getParameter() != null) {
			schlag = (boolean) kdo.getParameter().get(0);
			parameter = true;
		}
		if (parameter) {
			clientGUI.amZug(schlag);
		} else {
			clientGUI.amZug();
		}
	}

	private void verteileSpieler(Kommando kdo) {
		List<Spieler> spieler = new ArrayList<>();
		for (Serializable p : kdo.getParameter()) {
			spieler.add((Spieler) p);
		}
		clientGUI.gibSpieler(spieler);
	}

	private void verteileFarbe(Kommando kdo) {
		clientGUI.gibFarbe(kdo.getParameter().get(0).toString());
	}

	private void verteileSchlag(Kommando kdo) {
		clientGUI.gibSchlag(kdo.getParameter().get(0).toString());
	}

	private void verteileHandkarten(Kommando kdo) {
		List<Karte> hand = new ArrayList<>();
		for (Serializable p : kdo.getParameter()) {
			hand.add((Karte) p);
		}
		clientGUI.gibHandkarten(hand);
	}

}
