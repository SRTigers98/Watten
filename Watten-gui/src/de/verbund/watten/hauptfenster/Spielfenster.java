package de.verbund.watten.hauptfenster;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import de.verbund.watten.client.Client;
import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.meldungen.Meldung;

import javax.swing.JLabel;

public class Spielfenster implements ClientGUI{

	private Client client;
	private JFrame frame;
	private JPanel panelSP2;
	private JPanel panelSP1;
	private JPanel panelWins2;
	private JPanel panelHand2;
	private JPanel panelStich2;
	private JPanel panelWins1;
	private JPanel panelHand1;
	private JPanel panelStich1;
	private JPanel panelFeld;
	private JPanel panelKarte2;
	private JPanel panelKarte1;
	private JLabel lblName2;
	private JLabel lblWins2;
	private JLabel lblName1;
	private JLabel lblWins1;
	private JLabel lblStich2;
	private JLabel lblStich1;
	private JLabel lblAnzStiche2;
	private JLabel lblAnzStiche1;
	private JLabel lblSP1K1;
	private JLabel lblSP1K2;
	private JLabel lblSP1K3;
	private JLabel lblSP1K4;
	private JLabel lblSP1K5;
	private JLabel lblSP2K1;
	private JLabel lblSP2K2;
	private JLabel lblSP2K3;
	private JLabel lblSP2K4;
	private JLabel lblSP2K5;
	private JLabel lblKSP2;
	private JLabel lblKSP1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spielfenster window = new Spielfenster("Test");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Spielfenster(String name1) {
		lblName1 = new JLabel(name1 + ":");
		initialize();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		hintergrundLaden();
		frame.setVisible(true);
		gibHandkarten(null);
	}

	@SuppressWarnings("serial")
	private void hintergrundLaden() {
		try {
			URL urlTisch = getClass().getClassLoader().getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
			Image imgTisch = ImageIO.read(urlTisch);
			JPanel panelHintergrund = new JPanel() {
				@Override
				public void paintComponent(Graphics g) {
					g.drawImage(imgTisch, 0, 0, null);
				}
			};
		} catch (IOException e1) {
			new Meldung(2, "Hintergrund konnte nicht geladen werden!");
		}		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanelSP2(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanelSP1(), BorderLayout.SOUTH);
		frame.getContentPane().add(getPanelFeld(), BorderLayout.CENTER);
	}

	private JPanel getPanelSP2() {
		if (panelSP2 == null) {
			panelSP2 = new JPanel();
			panelSP2.setLayout(new BorderLayout(0, 0));
			panelSP2.add(getPanel_1(), BorderLayout.WEST);
			panelSP2.add(getPanel_1_1(), BorderLayout.CENTER);
			panelSP2.add(getPanelStich2(), BorderLayout.EAST);
		}
		return panelSP2;
	}
	private JPanel getPanelSP1() {
		if (panelSP1 == null) {
			panelSP1 = new JPanel();
			panelSP1.setLayout(new BorderLayout(0, 0));
			panelSP1.add(getPanelWins1(), BorderLayout.WEST);
			panelSP1.add(getPanel_1_2(), BorderLayout.CENTER);
			panelSP1.add(getPanelStich1(), BorderLayout.EAST);
		}
		return panelSP1;
	}
	private JPanel getPanel_1() {
		if (panelWins2 == null) {
			panelWins2 = new JPanel();
			panelWins2.add(getLblName2());
			panelWins2.add(getLblWins2());
		}
		return panelWins2;
	}
	private JPanel getPanel_1_1() {
		if (panelHand2 == null) {
			panelHand2 = new JPanel();
			panelHand2.add(getLblSP2K1());
			panelHand2.add(getLblSP2K2());
			panelHand2.add(getLblSP2K3());
			panelHand2.add(getLblSP2K4());
			panelHand2.add(getLblSP2K5());
		}
		return panelHand2;
	}
	private JPanel getPanelStich2() {
		if (panelStich2 == null) {
			panelStich2 = new JPanel();
			panelStich2.add(getLblStich2());
			panelStich2.add(getLblAnzStiche2());
		}
		return panelStich2;
	}
	private JPanel getPanelWins1() {
		if (panelWins1 == null) {
			panelWins1 = new JPanel();
			panelWins1.add(getLblName1());
			panelWins1.add(getLblWins1());
		}
		return panelWins1;
	}
	private JPanel getPanel_1_2() {
		if (panelHand1 == null) {
			panelHand1 = new JPanel();
			panelHand1.add(getLblSP1K1());
			panelHand1.add(getLblSP1K2());
			panelHand1.add(getLblSP1K3());
			panelHand1.add(getLblSP1K4());
			panelHand1.add(getLblSP1K5());
		}
		return panelHand1;
	}
	private JPanel getPanelStich1() {
		if (panelStich1 == null) {
			panelStich1 = new JPanel();
			panelStich1.add(getLblStich1());
			panelStich1.add(getLblAnzStiche1());
		}
		return panelStich1;
	}
	private JPanel getPanelFeld() {
		if (panelFeld == null) {
			panelFeld = new JPanel();
			panelFeld.setLayout(new BorderLayout(0, 0));
			panelFeld.add(getPanel_1_3(), BorderLayout.NORTH);
			panelFeld.add(getPanelKarte1(), BorderLayout.SOUTH);
		}
		return panelFeld;
	}
	private JPanel getPanel_1_3() {
		if (panelKarte2 == null) {
			panelKarte2 = new JPanel();
			panelKarte2.add(getLblKsp());
		}
		return panelKarte2;
	}
	private JPanel getPanelKarte1() {
		if (panelKarte1 == null) {
			panelKarte1 = new JPanel();
			panelKarte1.add(getLblKsp_1());
		}
		return panelKarte1;
	}
	private JLabel getLblName2() {
		if (lblName2 == null) {
			lblName2 = new JLabel("Name 2:");
		}
		return lblName2;
	}
	private JLabel getLblWins2() {
		if (lblWins2 == null) {
			lblWins2 = new JLabel("AnzWins");
		}
		return lblWins2;
	}
	private JLabel getLblName1() {
		if (lblName1 == null) {
			lblName1 = new JLabel("Name 1:");
		}
		return lblName1;
	}
	private JLabel getLblWins1() {
		if (lblWins1 == null) {
			lblWins1 = new JLabel("AnzWins");
		}
		return lblWins1;
	}
	private JLabel getLblStich2() {
		if (lblStich2 == null) {
			lblStich2 = new JLabel("Stiche:");
		}
		return lblStich2;
	}
	private JLabel getLblStich1() {
		if (lblStich1 == null) {
			lblStich1 = new JLabel("Stiche:");
		}
		return lblStich1;
	}
	private JLabel getLblAnzStiche2() {
		if (lblAnzStiche2 == null) {
			lblAnzStiche2 = new JLabel("AnzStiche");
		}
		return lblAnzStiche2;
	}
	private JLabel getLblAnzStiche1() {
		if (lblAnzStiche1 == null) {
			lblAnzStiche1 = new JLabel("AnzStiche");
		}
		return lblAnzStiche1;
	}
	private JLabel getLblSP1K1() {
		if (lblSP1K1 == null) {
			lblSP1K1 = new JLabel("K1");
		}
		return lblSP1K1;
	}
	private JLabel getLblSP1K2() {
		if (lblSP1K2 == null) {
			lblSP1K2 = new JLabel("K2");
		}
		return lblSP1K2;
	}
	private JLabel getLblSP1K3() {
		if (lblSP1K3 == null) {
			lblSP1K3 = new JLabel("K3");
		}
		return lblSP1K3;
	}
	private JLabel getLblSP1K4() {
		if (lblSP1K4 == null) {
			lblSP1K4 = new JLabel("K4");
		}
		return lblSP1K4;
	}
	private JLabel getLblSP1K5() {
		if (lblSP1K5 == null) {
			lblSP1K5 = new JLabel("K5");
		}
		return lblSP1K5;
	}
	private JLabel getLblSP2K1() {
		if (lblSP2K1 == null) {
			lblSP2K1 = new JLabel("K1");
		}
		return lblSP2K1;
	}
	private JLabel getLblSP2K2() {
		if (lblSP2K2 == null) {
			lblSP2K2 = new JLabel("K2");
		}
		return lblSP2K2;
	}
	private JLabel getLblSP2K3() {
		if (lblSP2K3 == null) {
			lblSP2K3 = new JLabel("K3");
		}
		return lblSP2K3;
	}
	private JLabel getLblSP2K4() {
		if (lblSP2K4 == null) {
			lblSP2K4 = new JLabel("K4");
		}
		return lblSP2K4;
	}
	private JLabel getLblSP2K5() {
		if (lblSP2K5 == null) {
			lblSP2K5 = new JLabel("K5");
		}
		return lblSP2K5;
	}
	private JLabel getLblKsp() {
		if (lblKSP2 == null) {
			lblKSP2 = new JLabel("KSP2");
		}
		return lblKSP2;
	}
	private JLabel getLblKsp_1() {
		if (lblKSP1 == null) {
			lblKSP1 = new JLabel("KSP1");
		}
		return lblKSP1;
	}

	@Override
	public void ausgabe(int art, String message) {
		new Meldung(art, message);
	}

	@Override
	public void gibHandkarten(List<Karte> handkarten){
		try {
			URL urlBack = getClass().getClassLoader().getResource("de/verbund/watten/karten/Back.png");
			Image img = ImageIO.read(urlBack);
			Icon back = new ImageIcon(img);
			lblSP2K1.setIcon(back);
			lblSP2K2.setIcon(back);
			lblSP2K3.setIcon(back);
			lblSP2K4.setIcon(back);
			lblSP2K5.setIcon(back);
		} catch (IOException e) {
			new Meldung(2, "Handkarten können nicht angezeigt werden!");
		}

	}

	@Override
	public void setClient(Client client) {
		this.client = client;
	}
}