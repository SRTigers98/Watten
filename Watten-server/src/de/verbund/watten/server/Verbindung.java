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
import de.verbund.watten.spieler.Spieler;

public class Verbindung implements Runnable {

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
					// out.writeObject(returnObj);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SocketException s) {
					// TODO
					System.err.println("Connection reset");
					ok = false;
				}
			}
			// beenden
			in.close();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void sende(Kommando obj) {
		try {
			// Sende zum Client
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
		if (kdo.getKommando().equals("beende")) {
			ok = false;
		}
		if (kdo.getKommando().equals("sendeName")) {
			// TODO UUID später
			int id = socketServer.getVerbindungen().size();
			Spieler spieler = new Spieler(id, kdo.getParameter().get(0).toString());
			socketServer.getManager().addSpieler(spieler);
			Kommando kdo2 = new Kommando();
			kdo2.setKommando("sendeID");
			kdo2.addParameter(id);
			sende(kdo2);
			try {
				socketServer.getManager().starteSpiel();
			} catch (WattenException e) {
				Kommando kdo3 = Hilfe.getMeldungKommando(3, e.getMessage());
				sende(kdo3);
			}
		}
		if (kdo.getKommando().equals("spieleKarte")) {
			int id = (int) kdo.getParameter().get(0);
			Karte karte = (Karte) kdo.getParameter().get(1);
			socketServer.getManager().spieleKarte(id, karte);
		}
		if (kdo.getKommando().equals("beende")) {
			ok = false;
		}
		if (kdo.getKommando().equals("beende")) {
			ok = false;
		}

		return gesendet;
	}

	public void beende() {
		Kommando kdo = new Kommando();
		kdo.setKommando("beende");
		try {
			out.writeObject(kdo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
