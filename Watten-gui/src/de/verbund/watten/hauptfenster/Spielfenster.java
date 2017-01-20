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
import de.verbund.watten.endfenster.Endfenster;
import de.verbund.watten.karten.Karte;
import de.verbund.watten.meldungen.Meldung;
import de.verbund.watten.spielbeginn.Auswahlfenster;
import de.verbund.watten.spieler.Spieler;
import de.verbund.watten.startfenster.Hauptmenue;
import de.verbund.watten.konstanten.AuswahlfensterKonst;
import de.verbund.watten.konstanten.MeldungKonst;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
/**
 * Spielfenster realisiert die Anzeige auf dem einelnen Client
 * Spielfenster übergibt actions des Users an die Clientklasse
 * 
 * @author SvSy
 */
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
	private boolean amZug;
	private Karte karte1;
	private Karte karte2;
	private Karte karte3;
	private Karte karte4;
	private Karte karte5;
	private JPanel panelAnsage;
	private JLabel lblSchlag;
	private JLabel lblFarbe;
	private JLabel lblSchlagWert;
	private JLabel lblFarbeWert;
	private JLabel lblAnsage;
	private JPanel panelZug;
	private JLabel lblZug;
	private JPanel panelAnsageAusgleich;
	private Spieler SP1;
	private Spieler SP2;

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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelWins2 = new GridBagLayout();
			gbl_panelWins2.columnWidths = new int[] {40, 70, 10};
			gbl_panelWins2.rowHeights = new int[]{14, 0};
			gbl_panelWins2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panelWins2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelWins2.setLayout(gbl_panelWins2);
			GridBagConstraints gbc_lblName2 = new GridBagConstraints();
			gbc_lblName2.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblName2.insets = new Insets(0, 0, 0, 5);
			gbc_lblName2.gridx = 0;
			gbc_lblName2.gridy = 0;
			panelWins2.add(getLblName2(), gbc_lblName2);
			GridBagConstraints gbc_lblWins2 = new GridBagConstraints();
			gbc_lblWins2.anchor = GridBagConstraints.WEST;
			gbc_lblWins2.gridx = 1;
			gbc_lblWins2.gridy = 0;
			panelWins2.add(getLblWins2(), gbc_lblWins2);
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelStich2 = new GridBagLayout();
			gbl_panelStich2.columnWidths = new int[] {40, 70, 10};
			gbl_panelStich2.rowHeights = new int[]{14, 0};
			gbl_panelStich2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panelStich2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelStich2.setLayout(gbl_panelStich2);
			GridBagConstraints gbc_lblStich2 = new GridBagConstraints();
			gbc_lblStich2.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblStich2.insets = new Insets(0, 0, 0, 5);
			gbc_lblStich2.gridx = 0;
			gbc_lblStich2.gridy = 0;
			panelStich2.add(getLblStich2(), gbc_lblStich2);
			GridBagConstraints gbc_lblAnzStiche2 = new GridBagConstraints();
			gbc_lblAnzStiche2.anchor = GridBagConstraints.WEST;
			gbc_lblAnzStiche2.gridx = 1;
			gbc_lblAnzStiche2.gridy = 0;
			panelStich2.add(getLblAnzStiche2(), gbc_lblAnzStiche2);
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelWins1 = new GridBagLayout();
			gbl_panelWins1.columnWidths = new int[] {40, 70, 10};
			gbl_panelWins1.rowHeights = new int[]{1, 0};
			gbl_panelWins1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panelWins1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelWins1.setLayout(gbl_panelWins1);
			GridBagConstraints gbc_lblWins1 = new GridBagConstraints();
			gbc_lblWins1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblWins1.gridx = 1;
			gbc_lblWins1.gridy = 0;
			panelWins1.add(getLblWins1(), gbc_lblWins1);
			GridBagConstraints gbc_lblName1 = new GridBagConstraints();
			gbc_lblName1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblName1.gridx = 0;
			gbc_lblName1.gridy = 0;
			panelWins1.add(getLblName1(), gbc_lblName1);
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelStich1 = new GridBagLayout();
			gbl_panelStich1.columnWidths = new int[] {40, 70, 10};
			gbl_panelStich1.rowHeights = new int[]{14, 0};
			gbl_panelStich1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panelStich1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelStich1.setLayout(gbl_panelStich1);
			GridBagConstraints gbc_lblStich1 = new GridBagConstraints();
			gbc_lblStich1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblStich1.insets = new Insets(0, 0, 0, 5);
			gbc_lblStich1.gridx = 0;
			gbc_lblStich1.gridy = 0;
			panelStich1.add(getLblStich1(), gbc_lblStich1);
			GridBagConstraints gbc_lblAnzStiche1 = new GridBagConstraints();
			gbc_lblAnzStiche1.anchor = GridBagConstraints.WEST;
			gbc_lblAnzStiche1.gridx = 1;
			gbc_lblAnzStiche1.gridy = 0;
			panelStich1.add(getLblAnzStiche1(), gbc_lblAnzStiche1);
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelFeld.setLayout(new BorderLayout(0, 0));
			panelFeld.add(getPanel_1_3(), BorderLayout.NORTH);
			panelFeld.add(getPanelKarte1(), BorderLayout.SOUTH);
			panelFeld.add(getPanelAnsage(), BorderLayout.WEST);
			panelFeld.add(getPanelZug(), BorderLayout.CENTER);
			panelFeld.add(getPanelAnsageAusgleich(), BorderLayout.EAST);
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
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelKarte2 = new GridBagLayout();
			gbl_panelKarte2.columnWidths = new int[] {0};
			gbl_panelKarte2.rowHeights = new int[] {220};
			gbl_panelKarte2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panelKarte2.rowWeights = new double[]{0.0};
			panelKarte2.setLayout(gbl_panelKarte2);
			GridBagConstraints gbc_lblKSP2 = new GridBagConstraints();
			gbc_lblKSP2.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblKSP2.gridx = 1;
			gbc_lblKSP2.gridy = 0;
			panelKarte2.add(getLblKsp(), gbc_lblKSP2);
		}
		return panelKarte2;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelKarte1() {
		if (panelKarte1 == null) {
			try {
				URL urlTisch = getClass().getClassLoader().getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelKarte1 = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelKarte1 = new GridBagLayout();
			gbl_panelKarte1.columnWidths = new int[] {0};
			gbl_panelKarte1.rowHeights = new int[] {220};
			gbl_panelKarte1.columnWeights = new double[]{0.0, 0.0};
			gbl_panelKarte1.rowWeights = new double[]{0.0};
			panelKarte1.setLayout(gbl_panelKarte1);
			GridBagConstraints gbc_lblKSP1 = new GridBagConstraints();
			gbc_lblKSP1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblKSP1.gridx = 1;
			gbc_lblKSP1.gridy = 0;
			panelKarte1.add(getLblKsp_1(), gbc_lblKSP1);
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
			lblWins2 = new JLabel("");
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
			lblWins1 = new JLabel("");
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
			lblAnzStiche2 = new JLabel("");
			lblAnzStiche2.setForeground(Color.WHITE);
		}
		return lblAnzStiche2;
	}

	private JLabel getLblAnzStiche1() {
		if (lblAnzStiche1 == null) {
			lblAnzStiche1 = new JLabel("");
			lblAnzStiche1.setForeground(Color.WHITE);
		}
		return lblAnzStiche1;
	}

	private JLabel getLblSP1K1() {
		if (lblSP1K1 == null) {
			lblSP1K1 = new JLabel("");
			lblSP1K1.setName("K1");
			lblSP1K1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					karteSpielen(lblSP1K1);
				}
			});
		}
		return lblSP1K1;
	}

	private JLabel getLblSP1K2() {
		if (lblSP1K2 == null) {
			lblSP1K2 = new JLabel("");
			lblSP1K2.setName("K2");
			lblSP1K2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					karteSpielen(lblSP1K2);
				}
			});
		}
		return lblSP1K2;
	}

	private JLabel getLblSP1K3() {
		if (lblSP1K3 == null) {
			lblSP1K3 = new JLabel("");
			lblSP1K3.setName("K3");
			lblSP1K3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					karteSpielen(lblSP1K3);
				}
			});
		}
		return lblSP1K3;
	}

	private JLabel getLblSP1K4() {
		if (lblSP1K4 == null) {
			lblSP1K4 = new JLabel("");
			lblSP1K4.setName("K4");
			lblSP1K4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					karteSpielen(lblSP1K4);
				}
			});
		}
		return lblSP1K4;
	}

	private JLabel getLblSP1K5() {
		if (lblSP1K5 == null) {
			lblSP1K5 = new JLabel("");
			lblSP1K5.setName("K5");
			lblSP1K5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					karteSpielen(lblSP1K5);
				}
			});
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
	
	private void karteSpielen(JLabel lable){
		if(amZug == true){
			Icon iconKarte = lable.getIcon();
			lable.setIcon(null);
			if(lblSP1K1.getIcon() == null && lblSP1K2.getIcon() == null && lblSP1K3.getIcon() == null && lblSP1K4.getIcon() == null && lblSP1K5.getIcon() == null){
				lblSP1K3.setIcon(iconHolenDunkelGruen());
			}
			lblKSP1.setIcon(iconKarte);
			if(lable.getName().contains("K1")){
				client.sendeKarte(karte1);
			}
			else if(lable.getName().contains("K2")){
				client.sendeKarte(karte2);
			}
			else if(lable.getName().contains("K3")){
				client.sendeKarte(karte3);
			}
			else if(lable.getName().contains("K4")){
				client.sendeKarte(karte4);
			}
			else if(lable.getName().contains("K5")){
				client.sendeKarte(karte5);
			}else{
				if (meldung == null) {
					meldung = new Meldung(MeldungKonst.FEHLER, "Fehler beim übermitteln der Karte!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Fehler beim übermitteln der Karte!");
				}
			}
			amZug = false;
			lblZug.setText("Dein Gegner ist am Zug!");
		} else {
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.HINWEIS, "Du bist nicht dran!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.HINWEIS, "Du bist nicht dran!");
			}
		}
	}
	
	@SuppressWarnings("serial")
	private JPanel getPanelAnsage() {
		if (panelAnsage == null) {
			try {
				URL urlTisch = getClass().getClassLoader().getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelAnsage = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelAnsage = new GridBagLayout();
			gbl_panelAnsage.columnWidths = new int[] {60, 60};
			gbl_panelAnsage.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panelAnsage.columnWeights = new double[]{0.0, 0.0};
			gbl_panelAnsage.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelAnsage.setLayout(gbl_panelAnsage);
			GridBagConstraints gbc_lblAnsage = new GridBagConstraints();
			gbc_lblAnsage.gridwidth = 2;
			gbc_lblAnsage.insets = new Insets(0, 0, 5, 5);
			gbc_lblAnsage.gridx = 0;
			gbc_lblAnsage.gridy = 0;
			panelAnsage.add(getLblAnsage(), gbc_lblAnsage);
			GridBagConstraints gbc_lblSchlag = new GridBagConstraints();
			gbc_lblSchlag.anchor = GridBagConstraints.EAST;
			gbc_lblSchlag.insets = new Insets(0, 0, 5, 5);
			gbc_lblSchlag.gridx = 0;
			gbc_lblSchlag.gridy = 1;
			panelAnsage.add(getLblSchlag(), gbc_lblSchlag);
			GridBagConstraints gbc_lblFarbe = new GridBagConstraints();
			gbc_lblFarbe.anchor = GridBagConstraints.EAST;
			gbc_lblFarbe.insets = new Insets(0, 0, 5, 5);
			gbc_lblFarbe.gridx = 0;
			gbc_lblFarbe.gridy = 2;
			panelAnsage.add(getLblFarbe(), gbc_lblFarbe);
			GridBagConstraints gbc_lblSchlagWert = new GridBagConstraints();
			gbc_lblSchlagWert.anchor = GridBagConstraints.WEST;
			gbc_lblSchlagWert.insets = new Insets(0, 5, 5, 0);
			gbc_lblSchlagWert.gridx = 1;
			gbc_lblSchlagWert.gridy = 1;
			panelAnsage.add(getLblSchlagWert(), gbc_lblSchlagWert);
			GridBagConstraints gbc_lblFarbeWert = new GridBagConstraints();
			gbc_lblFarbeWert.anchor = GridBagConstraints.WEST;
			gbc_lblFarbeWert.insets = new Insets(0, 5, 5, 0);
			gbc_lblFarbeWert.gridx = 1;
			gbc_lblFarbeWert.gridy = 2;
			panelAnsage.add(getLblFarbeWert(), gbc_lblFarbeWert);
		}
		return panelAnsage;
	}
	private JLabel getLblSchlag() {
		if (lblSchlag == null) {
			lblSchlag = new JLabel("Schlag:");
		}
		return lblSchlag;
	}
	private JLabel getLblFarbe() {
		if (lblFarbe == null) {
			lblFarbe = new JLabel("Farbe:");
		}
		return lblFarbe;
	}
	private JLabel getLblSchlagWert() {
		if (lblSchlagWert == null) {
			lblSchlagWert = new JLabel("");
		}
		return lblSchlagWert;
	}
	private JLabel getLblFarbeWert() {
		if (lblFarbeWert == null) {
			lblFarbeWert = new JLabel("");
		}
		return lblFarbeWert;
	}

	private JLabel getLblAnsage() {
		if (lblAnsage == null) {
			lblAnsage = new JLabel("Ansage");
		}
		return lblAnsage;
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
			karte1 = handkarten.get(0);
			lblSP1K1.setIcon(iconHolen(karte1));
			karte2 = handkarten.get(1);
			lblSP1K2 .setIcon(iconHolen(karte2));
			karte3 = handkarten.get(2);
			lblSP1K3.setIcon(iconHolen(karte3));
			karte4 = handkarten.get(3);
			lblSP1K4.setIcon(iconHolen(karte4));
			karte5 = handkarten.get(4);
			lblSP1K5.setIcon(iconHolen(karte5));
		} catch (IOException e) {
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
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
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			}
		}
		return null;
	}
	
	private Icon iconHolenFarbe(String farbe){
		URL urlIcon = getClass().getClassLoader().getResource("de/verbund/watten/spielbeginn/"+farbe+".png");
		try {
			Image imageIcon = ImageIO.read(urlIcon);
			Icon icon = new ImageIcon(imageIcon);
			return icon;
		} catch (IOException e) {
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			}
		}
		return null;
	}
	
	private Icon iconHolenDunkelGruen(){
		URL urlIcon = getClass().getClassLoader().getResource("de/verbund/watten/hauptfenster/watten_spielfeld.png");
		try {
			Image imageIcon = ImageIO.read(urlIcon);
			Icon icon = new ImageIcon(imageIcon);
			return icon;
		} catch (IOException e) {
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			}
		}
		return null;
	}
	
	private Icon iconHolenSchlag(String schlag){
		URL urlIcon = getClass().getClassLoader().getResource("de/verbund/watten/icons/"+schlag+".png");
		try {
			Image imageIcon = ImageIO.read(urlIcon);
			Icon icon = new ImageIcon(imageIcon);
			return icon;
		} catch (IOException e) {
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "Handkarten können nicht angezeigt werden!");
			}
		}
		return null;
	}
	
	@SuppressWarnings("serial")
	private JPanel getPanelZug() {
		if (panelZug == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelZug = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			panelZug.setLayout(new BorderLayout(0, 0));
			panelZug.add(getLblZug());
		}
		return panelZug;
	}
	private JLabel getLblZug() {
		if (lblZug == null) {
			lblZug = new JLabel("");
			lblZug.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblZug;
	}

	@SuppressWarnings("serial")
	private JPanel getPanelAnsageAusgleich() {
		if (panelAnsageAusgleich == null) {
			try {
				URL urlTisch = getClass().getClassLoader()
						.getResource("de/verbund/watten/hauptfenster/watten_spielfeld_mitte.png");
				Image imgTisch = ImageIO.read(urlTisch);
				panelAnsageAusgleich = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						g.drawImage(imgTisch, 0, 0, null);
					}
				};
			} catch (IOException e1) {
				if (meldung == null) {
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				} else {
					meldung.terminate();
					meldung = new Meldung(MeldungKonst.FEHLER, "Hintergrund konnte nicht geladen werden!");
				}
			}
			GridBagLayout gbl_panelAnsageAusgleich = new GridBagLayout();
			gbl_panelAnsageAusgleich.columnWidths = new int[] {50, 20, 50};
			gbl_panelAnsageAusgleich.rowHeights = new int[]{0};
			gbl_panelAnsageAusgleich.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_panelAnsageAusgleich.rowWeights = new double[]{Double.MIN_VALUE};
			panelAnsageAusgleich.setLayout(gbl_panelAnsageAusgleich);
		}
		return panelAnsageAusgleich;
	}
	
	@Override
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public void gibSpieler(List<Spieler> spieler) {
		SP1 = spieler.get(0);
		SP2 = spieler.get(1);
		lblZug.setText("Dein Gegner ist am Zug!");
		lblName1.setText(spieler.get(0).getName());
		lblName2.setText(spieler.get(1).getName());
		lblAnzStiche1.setText(Integer.toString(spieler.get(0).getStiche()));
		lblAnzStiche2.setText(Integer.toString(spieler.get(1).getStiche()));
		lblWins1.setText(Integer.toString(spieler.get(0).getPunkte()));
		lblWins2.setText(Integer.toString(spieler.get(1).getPunkte()));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lblKSP1.setIcon(null);
		lblKSP2.setIcon(null);
	}

	@Override
	public void amZug(boolean schlag) {
		if(schlag == true){
			meldung.terminate();
			new Auswahlfenster(AuswahlfensterKonst.SCHLAG_WAHL, client);
		}else if(schlag == false){
			new Auswahlfenster(AuswahlfensterKonst.FARBE_WAHL, client);
		}else{
			if (meldung == null) {
				meldung = new Meldung(MeldungKonst.FEHLER, "Falscher Ansageboolean!");
			} else {
				meldung.terminate();
				meldung = new Meldung(MeldungKonst.FEHLER, "Falscher Ansageboolean!");
			}
		}
	}
	
	public void amZug(){
		amZug = true;
		lblZug.setText("Du bist am Zug!");
	}

	@Override
	public void gibSchlag(String schlag) {
		lblSchlagWert.setIcon(iconHolenSchlag(schlag.substring(1)));
	}

	@Override
	public void gibFarbe(String farbe) {
		lblFarbeWert.setIcon(iconHolenFarbe(farbe));
	}

	@Override
	public void gibGegnerKarte(int id, Karte karte) {
		lblKSP2.setIcon(iconHolen(karte));
		if(!(lblSP2K1.getIcon() == null)){
			lblSP2K1.setIcon(null);
		}
		else if(!(lblSP2K2.getIcon() == null)){
			lblSP2K2.setIcon(null);
		}
		else if(!(lblSP2K3.getIcon() == null)){
			lblSP2K3.setIcon(null);
		}
		else if(!(lblSP2K4.getIcon() == null)){
			lblSP2K4.setIcon(null);
		}
		else if(!(lblSP2K5.getIcon() == null)){
			lblSP2K5.setIcon(iconHolenDunkelGruen());
		}
	}

	@Override
	public void spielEnde(boolean sieger) {
		new Endfenster(SP1.getName(), SP2.getName(), SP1.getStiche(), SP2.getStiche(), SP1.getPunkte(), SP2.getPunkte(), sieger, client);
	}

	@Override
	public void fehler(String message) {
		if (meldung == null) {
			meldung = new Meldung(MeldungKonst.FEHLER, message);
		} else {
			meldung.terminate();
			meldung = new Meldung(MeldungKonst.FEHLER, message);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.dispose();
		new Hauptmenue();
	}
}