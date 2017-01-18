package de.verbund.watten.hauptfenster;

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
import java.awt.Color;

import javax.swing.JPanel;

import de.verbund.watten.client.Client;
import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.meldungen.Meldung;
import de.verbund.watten.spielbeginn.Auswahlfenster;
import de.verbund.watten.spieler.Spieler;
import konstanten.MeldungKonst;

import javax.swing.JLabel;

public class Spielfenster implements ClientGUI {

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
	private JPanel panelTisch;
	private Meldung meldung;
	private Spieler sp1;
	private Spieler sp2;

	/**
	 * Create the application.
	 */
	public Spielfenster(String name1) {
		initialize();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanelTisch(), BorderLayout.CENTER);
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

	@SuppressWarnings("serial")
	private JPanel getPanel_1() {
		if (panelWins2 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelWins2 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelWins2.add(getLblName2());
			panelWins2.add(getLblWins2());
		}
		return panelWins2;
	}

	@SuppressWarnings("serial")
	private JPanel getPanel_1_1() {
		if (panelHand2 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelHand2 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}

			}
			panelHand2.add(getLblSP2K1());
			panelHand2.add(getLblSP2K2());
			panelHand2.add(getLblSP2K3());
			panelHand2.add(getLblSP2K4());
			panelHand2.add(getLblSP2K5());
		}
		return panelHand2;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelStich2() {
		if (panelStich2 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelStich2 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelStich2.add(getLblStich2());
			panelStich2.add(getLblAnzStiche2());
		}
		return panelStich2;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelWins1() {
		if (panelWins1 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelWins1 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelWins1.add(getLblName1());
			panelWins1.add(getLblWins1());
		}
		return panelWins1;
	}

	@SuppressWarnings("serial")
	private JPanel getPanel_1_2() {
		if (panelHand1 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelHand1 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelHand1.add(getLblSP1K1());
			panelHand1.add(getLblSP1K2());
			panelHand1.add(getLblSP1K3());
			panelHand1.add(getLblSP1K4());
			panelHand1.add(getLblSP1K5());
		}
		return panelHand1;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelStich1() {
		if (panelStich1 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelStich1 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelStich1.add(getLblStich1());
			panelStich1.add(getLblAnzStiche1());
		}
		return panelStich1;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelFeld() {
		if (panelFeld == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelFeld = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelFeld.setLayout(new BorderLayout(0, 0));
			panelFeld.add(getPanel_1_3(), BorderLayout.NORTH);
			panelFeld.add(getPanelKarte1(), BorderLayout.SOUTH);
		}
		return panelFeld;
	}

	@SuppressWarnings("serial")
	private JPanel getPanel_1_3() {
		if (panelKarte2 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelKarte2 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelKarte2.add(getLblKsp());
		}
		return panelKarte2;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelKarte1() {
		if (panelKarte1 == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelKarte1 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(2, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelKarte1.add(getLblKsp_1());
		}
		return panelKarte1;
	}

	private JLabel getLblName2() {
		if (lblName2 == null) {
			lblName2 = new JLabel("Name 2:");
			lblName2.setForeground(Color.WHITE);
		}
		return lblName2;
	}

	private JLabel getLblWins2() {
		if (lblWins2 == null) {
			lblWins2 = new JLabel("AnzWins");
			lblWins2.setForeground(Color.WHITE);
		}
		return lblWins2;
	}

	private JLabel getLblName1() {
		if (lblName1 == null) {
			lblName1 = new JLabel("Name 1:");
		}
		lblName1.setForeground(Color.WHITE);
		return lblName1;
	}

	private JLabel getLblWins1() {
		if (lblWins1 == null) {
			lblWins1 = new JLabel("AnzWins");
			lblWins1.setForeground(Color.WHITE);
		}
		return lblWins1;
	}

	private JLabel getLblStich2() {
		if (lblStich2 == null) {
			lblStich2 = new JLabel("Stiche:");
			lblStich2.setForeground(Color.WHITE);
		}
		return lblStich2;
	}

	private JLabel getLblStich1() {
		if (lblStich1 == null) {
			lblStich1 = new JLabel("Stiche:");
			lblStich1.setForeground(Color.WHITE);
		}
		return lblStich1;
	}

	private JLabel getLblAnzStiche2() {
		if (lblAnzStiche2 == null) {
			lblAnzStiche2 = new JLabel("AnzStiche");
			lblAnzStiche2.setForeground(Color.WHITE);
		}
		return lblAnzStiche2;
	}

	private JLabel getLblAnzStiche1() {
		if (lblAnzStiche1 == null) {
			lblAnzStiche1 = new JLabel("AnzStiche");
			lblAnzStiche1.setForeground(Color.WHITE);
		}
		return lblAnzStiche1;
	}

	private JLabel getLblSP1K1() {
		if (lblSP1K1 == null) {
			lblSP1K1 = new JLabel("");
		}
		return lblSP1K1;
	}

	private JLabel getLblSP1K2() {
		if (lblSP1K2 == null) {
			lblSP1K2 = new JLabel("");
		}
		return lblSP1K2;
	}

	private JLabel getLblSP1K3() {
		if (lblSP1K3 == null) {
			lblSP1K3 = new JLabel("");
		}
		return lblSP1K3;
	}

	private JLabel getLblSP1K4() {
		if (lblSP1K4 == null) {
			lblSP1K4 = new JLabel("");
		}
		return lblSP1K4;
	}

	private JLabel getLblSP1K5() {
		if (lblSP1K5 == null) {
			lblSP1K5 = new JLabel("");
		}
		return lblSP1K5;
	}

	private JLabel getLblSP2K1() {
		if (lblSP2K1 == null) {
			lblSP2K1 = new JLabel("");
		}
		return lblSP2K1;
	}

	private JLabel getLblSP2K2() {
		if (lblSP2K2 == null) {
			lblSP2K2 = new JLabel("");
		}
		return lblSP2K2;
	}

	private JLabel getLblSP2K3() {
		if (lblSP2K3 == null) {
			lblSP2K3 = new JLabel("");
		}
		return lblSP2K3;
	}

	private JLabel getLblSP2K4() {
		if (lblSP2K4 == null) {
			lblSP2K4 = new JLabel("");
		}
		return lblSP2K4;
	}

	private JLabel getLblSP2K5() {
		if (lblSP2K5 == null) {
			lblSP2K5 = new JLabel("");
		}
		return lblSP2K5;
	}

	private JLabel getLblKsp() {
		if (lblKSP2 == null) {
			lblKSP2 = new JLabel("");
		}
		return lblKSP2;
	}

	private JLabel getLblKsp_1() {
		if (lblKSP1 == null) {
			lblKSP1 = new JLabel("");
		}
		return lblKSP1;
	}

	@Override
	public void ausgabe(int art, String message) {
		if (meldung == null) {
			meldung = new Meldung(art, message);
		} else {
			meldung.terminate();
			meldung = new Meldung(art, message);
		}
	}

	private JPanel getPanelTisch() {
		if (panelTisch == null) {
			panelTisch = new JPanel();
			panelTisch.setLayout(new BorderLayout(0, 0));
			panelTisch.add(getPanelFeld(), BorderLayout.CENTER);
			panelTisch.add(getPanelSP1(), BorderLayout.SOUTH);
			panelTisch.add(getPanelSP2(), BorderLayout.NORTH);
		}
		return panelTisch;
	}
	
	@Override
	public void gibHandkarten(List<Karte> handkarten) {
		try {
			URL urlBack = getClass().getClassLoader().getResource("de/verbund/watten/karten/Back.png");
			Image img = ImageIO.read(urlBack);
			Icon back = new ImageIcon(img);
			lblSP2K1.setIcon(back);
			lblSP2K2.setIcon(back);
			lblSP2K3.setIcon(back);
			lblSP2K4.setIcon(back);
			lblSP2K5.setIcon(back);
			Karte karte1 = handkarten.get(0);
			lblSP1K1.setIcon(iconHolen(karte1));
			Karte karte2 = handkarten.get(1);
			lblSP1K2 .setIcon(iconHolen(karte2));
			Karte karte3 = handkarten.get(2);
			lblSP1K3.setIcon(iconHolen(karte3));
			Karte karte4 = handkarten.get(3);
			lblSP1K4.setIcon(iconHolen(karte4));
			Karte karte5 = handkarten.get(4);
			lblSP1K5.setIcon(iconHolen(karte5));
		} catch (IOException e) {
			if (meldung == null) {
				meldung = new Meldung(2, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(2, "Handkarten können nicht angezeigt werden!");
			}
		}

	}
	
	private Icon iconHolen(Karte karte){
		URL urlIcon = getClass().getClassLoader().getResource("de/verbund/watten/karten/"+karte.getLink());
		try {
			Image imageIcon = ImageIO.read(urlIcon);
			Icon icon = new ImageIcon(imageIcon);
			return icon;
		} catch (IOException e) {
			if (meldung == null) {
				meldung = new Meldung(2, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(2, "Handkarten können nicht angezeigt werden!");
			}
		}
		return null;
	}

	@Override
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public void gibSpieler(List<Spieler> spieler) {
		lblName1.setText(spieler.get(0).getName());
		lblName2.setText(spieler.get(1).getName());
		sp1 = spieler.get(0);
		sp2 = spieler.get(1);
	}

	@Override
	public void amZug(int id) {
		if(id == sp1.getId()){
			Auswahlfenster auswahlFarbe = new Auswahlfenster();
		}else if(id == sp2.getId()){
			System.out.println("Spieler 2 beginnt!");
		}else{
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.FEHLER, "ID passt nicht zu den Spielern!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "ID passt nicht zu den Spielern!");
			}
		}
	}
}