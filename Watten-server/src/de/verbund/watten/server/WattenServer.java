package de.verbund.watten.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.manager.WattenManager;
import de.verbund.watten.manager.WattenManagerImpl;
import de.verbund.watten.server.start.Serveroutput;

/**
 * 
 * Der Server, über den die komplette Applikation läuft.
 * 
 * @author Benjamin
 *
 */
public class WattenServer implements Runnable {

	private WattenManager manager;
	private Serveroutput output;
	private boolean ok = true;
	private int id = 0;

	// neu 1:n: Die Liste f�r die Verbindungen
	private List<Verbindung> verbindungen;

	public WattenServer(Serveroutput output) {
		// Setze Output-GUI
		this.output = output;

		// Erzeuge Manager
		manager = new WattenManagerImpl(this);

		// neu 1:n:
		verbindungen = new ArrayList<>();

		// Erzeuge Thread
		Thread t = new Thread(this);
		t.start();

		output.outputNewLine("Server gestartet");
	}

	public void run() {
		// Warte auf Verbindung
		try {
			ServerSocket server = new ServerSocket(4444);
			while (ok) {
				Socket socket = server.accept();
				InetAddress adr = socket.getInetAddress();
				Verbindung v = new Verbindung(socket, this);
				verbindungen.add(v);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void beende() {
		for (int i = 0; i < verbindungen.size(); ++i) {
			Verbindung v = (Verbindung) verbindungen.get(i);
			v.beende();
		}
	}

	public void sendePingAnAlle() {
		Kommando kdo = new Kommando();
		kdo.setKommando("info");
		kdo.addParameter("Ping vom Server");
		sendeAnAlle(kdo);
	}

	public void sendeAnAlle(Kommando kdo) {
		for (int i = 0; i < verbindungen.size(); ++i) {
			Verbindung v = (Verbindung) verbindungen.get(i);
			v.sende(kdo);
		}

	}

	public WattenManager getManager() {
		return manager;
	}

	public List<Verbindung> getVerbindungen() {
		return verbindungen;
	}

	public Serveroutput getOutput() {
		return output;
	}

	public int holeId() {
		id++;
		return id;
	}

}
