package de.verbund.watten.server;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import de.verbund.watten.common.Kommando;
import de.verbund.watten.manager.WattenManagerImpl;
import de.verbund.watten.server.start.Serveroutput;

/**
 * 
 * Der Server, über den die komplette Applikation läuft.
 * 
 * @author Benjamin
 *
 */
public class WattenServer {

	private WattenManagerImpl manager;
	private Serveroutput output;
	private boolean ok = true;
	private int id = 0;
	private int port;

	// neu 1:n: Die Liste f�r die Verbindungen
	private List<Verbindung> verbindungen;

	public WattenServer(Serveroutput output, int port) {
		// Setze Output-GUI
		this.output = output;

		// Setze Port
		this.port = port;

		// Erzeuge Manager
		manager = new WattenManagerImpl(this);

		// neu 1:n:
		verbindungen = new ArrayList<>();

		// Erzeuge Thread
		Thread t = new Thread(() -> run());
		t.start();
	}

	public void run() {
		// Warte auf Verbindung
		try {
			ServerSocket server = new ServerSocket(port);
			output.outputNewLine(
					"Server gestartet auf Port " + port + " IP: " + InetAddress.getLocalHost().getHostAddress());
			while (ok) {
				Socket socket = server.accept();
				InetAddress adr = socket.getInetAddress();
				Verbindung v = new Verbindung(socket, this);
				verbindungen.add(v);
			}
		} catch (BindException e) {
			output.bindException();
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

	public WattenManagerImpl getManager() {
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
