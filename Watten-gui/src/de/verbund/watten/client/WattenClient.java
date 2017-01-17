package de.verbund.watten.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.common.Kommando;

public class WattenClient implements Runnable {
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	private ClientGUI clientGUI;
	private boolean ok = true;

	public WattenClient(ClientGUI clientGUI) {
		// Baue Verbindung zum Server auf
		this.clientGUI = clientGUI;
		try {
			socket = new Socket("localhost", 4444);
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

	public WattenClient() {
		this(null);
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
			kdo.setKommando("beende");
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
				clientGUI.ausgabe(2, "Fehler beim Lesen: " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// clientGUI.ausgabe("...beendet");
	}

	private void verarbeite(Serializable gesendet) {
		Kommando kdo = (Kommando) gesendet;
		if (kdo.getKommando().equals("text")) {
			clientGUI.ausgabe((int) kdo.getParameter().get(0), kdo.getParameter().get(1).toString());
		}
		if (kdo.getKommando().equals("sendeHandkarten")) {

		}
	}
}
