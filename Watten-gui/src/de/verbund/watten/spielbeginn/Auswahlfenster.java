package de.verbund.watten.spielbeginn;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import de.verbund.watten.meldungen.Meldung;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import de.verbund.watten.konstanten.AuswahlfensterKonst;

/**
 * Auswahlfenster generiert das Farb Auswahl Fenster und das Schlag Auswahl
 * Fenster. Dies wird zu Beginn eines Spiel aufgerufen.
 * 
 * @author Mcscha
 *
 */
public class Auswahlfenster {

	private static final int SAU = 14;
	private static final int KOENIG = 13;
	private static final int OBER = 12;
	private static final int UNTER = 11;
	private static final int ZEHN = 10;
	private static final int NEUN = 9;
	private static final int ACHT = 8;
	private static final int SIEBEN = 7;
	private static final int EICHEL = 6;
	private static final int HERZ = 5;
	private static final int SCHELLN = 4;
	private static final int BLAU = 3;

	private int schlag_auswahl;
	private int farb_auswahl;
	private JFrame frame;
	private JPanel panel_Farbe;
	private JLabel lblBlau;
	private JRadioButton rdbtnBlau;
	private JLabel lblSchelln;
	private JRadioButton rdbtnSchelln;
	private JLabel lblHerz;
	private JRadioButton rdbtnHerz;
	private JLabel lblEichel;
	private JRadioButton rdbtnEichel;
	private JButton btnCommitFarbe;
	private Color dunklesGruen = new Color(0, 64, 0);
	private Color hellesGruen = new Color(34, 177, 76);
	private JPanel panel_Schlag;
	private JLabel lblSieben;
	private JLabel lblAcht;
	private JLabel lblNeun;
	private JLabel lblZehn;
	private JLabel lblUnter;
	private JLabel lblOber;
	private JLabel lblKoenig;
	private JLabel lblSau;
	private JRadioButton rdbtnSieben;
	private JRadioButton rdbtnAcht;
	private JRadioButton rdbtnNeun;
	private JRadioButton rdbtnZehn;
	private JRadioButton rdbtnUnter;
	private JRadioButton rdbtnOber;
	private JRadioButton rdbtnKoenig;
	private JRadioButton rdbtnSau;
	private JButton btnCommitSchlag;

	/**
	 * Test Launch. Eigentlicher Aufruf über den Kontruktor.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auswahlfenster window = new Auswahlfenster(1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Erstellt ein Fenster das zu Beginn eines Spiels angezeigt wird. Es wird
	 * entweder eine FarbAuswahl oder eine SchlagAuswahl angezeigt.
	 * 
	 * @param art
	 *            <br>
	 *            1- Es wird die SchlagWahl angezeigt. <br>
	 *            2- Es wird die FarbWahl angezeigt. <br>
	 * @return Bei beiden Fenster wird die ausgewählte Farbe oder Schlag an den
	 *         Server übermittelt.
	 */
	public Auswahlfenster(int art) {
		initialize();
		switch (art) {
		case AuswahlfensterKonst.SCHLAG_WAHL:
			initSchlag();
			break;
		case AuswahlfensterKonst.FARBE_WAHL:
			initFarbe();
			break;
		}
	}

	/**
	 * Initialisiert das Fenster wenn die Farbe ausgewählt werden soll.
	 */
	private void initFarbe() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 240);
		frame.setTitle("Farbe Auswahl");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel_Farbe(), BorderLayout.CENTER);
	}

	/**
	 * Initialisiert das Fenster wenn der Schlag ausgewählt werden soll.
	 */
	private void initSchlag() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 240);
		frame.setTitle("Schlag Auswahl");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel_Schlag(), BorderLayout.CENTER);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.getContentPane().add(getPanel_Schlag(), BorderLayout.CENTER);
	}

	private JPanel getPanel_Farbe() {
		if (panel_Farbe == null) {
			panel_Farbe = new JPanel();
			panel_Farbe.setBackground(dunklesGruen);
			GridBagLayout gbl_panel_schlag = new GridBagLayout();
			gbl_panel_schlag.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_schlag.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_schlag.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_schlag.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			panel_Farbe.setLayout(gbl_panel_schlag);
			GridBagConstraints gbc_lblBlau = new GridBagConstraints();
			gbc_lblBlau.insets = new Insets(25, 25, 5, 10);
			gbc_lblBlau.gridx = 1;
			gbc_lblBlau.gridy = 2;
			panel_Farbe.add(getLblBlau(), gbc_lblBlau);
			GridBagConstraints gbc_lblSchelln = new GridBagConstraints();
			gbc_lblSchelln.insets = new Insets(25, 10, 5, 10);
			gbc_lblSchelln.gridx = 2;
			gbc_lblSchelln.gridy = 2;
			panel_Farbe.add(getLblSchelln(), gbc_lblSchelln);
			GridBagConstraints gbc_lblHerz = new GridBagConstraints();
			gbc_lblHerz.insets = new Insets(25, 10, 5, 10);
			gbc_lblHerz.gridx = 3;
			gbc_lblHerz.gridy = 2;
			panel_Farbe.add(getLblHerz(), gbc_lblHerz);
			GridBagConstraints gbc_lblEichel = new GridBagConstraints();
			gbc_lblEichel.insets = new Insets(25, 10, 5, 25);
			gbc_lblEichel.gridx = 4;
			gbc_lblEichel.gridy = 2;
			panel_Farbe.add(getLblEichel(), gbc_lblEichel);
			GridBagConstraints gbc_rdbtnBlau = new GridBagConstraints();
			gbc_rdbtnBlau.insets = new Insets(5, 25, 25, 10);
			gbc_rdbtnBlau.gridx = 1;
			gbc_rdbtnBlau.gridy = 4;
			panel_Farbe.add(getRdbtnBlau(), gbc_rdbtnBlau);
			GridBagConstraints gbc_rdbtnSchelln = new GridBagConstraints();
			gbc_rdbtnSchelln.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnSchelln.gridx = 2;
			gbc_rdbtnSchelln.gridy = 4;
			panel_Farbe.add(getRdbtnSchelln(), gbc_rdbtnSchelln);
			GridBagConstraints gbc_rdbtnHerz = new GridBagConstraints();
			gbc_rdbtnHerz.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnHerz.gridx = 3;
			gbc_rdbtnHerz.gridy = 4;
			panel_Farbe.add(getRdbtnHerz(), gbc_rdbtnHerz);
			GridBagConstraints gbc_rdbtnEichel = new GridBagConstraints();
			gbc_rdbtnEichel.insets = new Insets(5, 10, 25, 25);
			gbc_rdbtnEichel.gridx = 4;
			gbc_rdbtnEichel.gridy = 4;
			panel_Farbe.add(getRdbtnEichel(), gbc_rdbtnEichel);
			GridBagConstraints gbc_btnCommit = new GridBagConstraints();
			gbc_btnCommit.gridwidth = 6;
			gbc_btnCommit.insets = new Insets(0, 0, 5, 5);
			gbc_btnCommit.gridx = 0;
			gbc_btnCommit.gridy = 7;
			panel_Farbe.add(getBtnCommitFarbe(), gbc_btnCommit);

			ButtonGroup radios = new ButtonGroup();
			radios.add(getRdbtnBlau());
			radios.add(getRdbtnEichel());
			radios.add(getRdbtnHerz());
			radios.add(getRdbtnSchelln());
		}
		return panel_Farbe;
	}

	private JLabel getLblBlau() {
		if (lblBlau == null) {
			lblBlau = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/spielbeginn/Blau.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblBlau.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Farbe konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblBlau;
	}

	private JRadioButton getRdbtnBlau() {
		if (rdbtnBlau == null) {
			rdbtnBlau = new JRadioButton("Blau");
			rdbtnBlau.setBackground(dunklesGruen);
			rdbtnBlau.setForeground(Color.WHITE);
			rdbtnBlau.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnBlau) {
						farb_auswahl = BLAU;
					}
				}
			});
		}
		return rdbtnBlau;
	}

	private JLabel getLblSchelln() {
		if (lblSchelln == null) {
			lblSchelln = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/spielbeginn/Schelln.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblSchelln.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Farbe konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblSchelln;
	}

	private JRadioButton getRdbtnSchelln() {
		if (rdbtnSchelln == null) {
			rdbtnSchelln = new JRadioButton("Schelln");
			rdbtnSchelln.setBackground(dunklesGruen);
			rdbtnSchelln.setForeground(Color.WHITE);
			rdbtnSchelln.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnSchelln) {
						farb_auswahl = SCHELLN;
					}
				}
			});
		}
		return rdbtnSchelln;
	}

	private JLabel getLblHerz() {
		if (lblHerz == null) {
			lblHerz = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/spielbeginn/Herz.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblHerz.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Farbe konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblHerz;
	}

	private JRadioButton getRdbtnHerz() {
		if (rdbtnHerz == null) {
			rdbtnHerz = new JRadioButton("Herz");
			rdbtnHerz.setBackground(dunklesGruen);
			rdbtnHerz.setForeground(Color.WHITE);
			rdbtnHerz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnHerz) {
						farb_auswahl = HERZ;
					}
				}
			});
		}
		return rdbtnHerz;
	}

	private JLabel getLblEichel() {
		if (lblEichel == null) {
			lblEichel = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/spielbeginn/Eichel.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblEichel.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Farbe konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblEichel;
	}

	private JRadioButton getRdbtnEichel() {
		if (rdbtnEichel == null) {
			rdbtnEichel = new JRadioButton("Eichel");
			rdbtnEichel.setBackground(dunklesGruen);
			rdbtnEichel.setForeground(Color.WHITE);
			rdbtnEichel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnEichel) {
						farb_auswahl = EICHEL;
					}
				}
			});
		}
		return rdbtnEichel;
	}

	private JButton getBtnCommitFarbe() {
		if (btnCommitFarbe == null) {
			btnCommitFarbe = new JButton("Commit");
			btnCommitFarbe.setBackground(Color.WHITE);
			btnCommitFarbe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnCommitFarbe) {
						farbCommit();
						frame.dispose();
					}
				}
			});
		}
		return btnCommitFarbe;
	}

	private JPanel getPanel_Schlag() {
		if (panel_Schlag == null) {
			panel_Schlag = new JPanel();
			panel_Schlag.setBackground(hellesGruen);
			GridBagLayout gbl_panel_farbe = new GridBagLayout();
			gbl_panel_farbe.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_farbe.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_panel_farbe.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_panel_farbe.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_Schlag.setLayout(gbl_panel_farbe);
			GridBagConstraints gbc_lblSieben = new GridBagConstraints();
			gbc_lblSieben.insets = new Insets(25, 25, 5, 10);
			gbc_lblSieben.gridx = 1;
			gbc_lblSieben.gridy = 1;
			panel_Schlag.add(getLblSieben(), gbc_lblSieben);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(25, 10, 5, 10);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 1;
			panel_Schlag.add(getLblAcht(), gbc_lblNewLabel_1);
			GridBagConstraints gbc_lblNeun = new GridBagConstraints();
			gbc_lblNeun.insets = new Insets(25, 10, 5, 10);
			gbc_lblNeun.gridx = 3;
			gbc_lblNeun.gridy = 1;
			panel_Schlag.add(getLblNeun(), gbc_lblNeun);
			GridBagConstraints gbc_lblZehn = new GridBagConstraints();
			gbc_lblZehn.insets = new Insets(25, 10, 5, 10);
			gbc_lblZehn.gridx = 4;
			gbc_lblZehn.gridy = 1;
			panel_Schlag.add(getLblZehn(), gbc_lblZehn);
			GridBagConstraints gbc_lblUnter = new GridBagConstraints();
			gbc_lblUnter.insets = new Insets(25, 10, 5, 10);
			gbc_lblUnter.gridx = 5;
			gbc_lblUnter.gridy = 1;
			panel_Schlag.add(getLblUnter(), gbc_lblUnter);
			GridBagConstraints gbc_lblOber = new GridBagConstraints();
			gbc_lblOber.insets = new Insets(25, 10, 5, 10);
			gbc_lblOber.gridx = 6;
			gbc_lblOber.gridy = 1;
			panel_Schlag.add(getLblOber(), gbc_lblOber);
			GridBagConstraints gbc_lblKoenig = new GridBagConstraints();
			gbc_lblKoenig.insets = new Insets(25, 10, 5, 10);
			gbc_lblKoenig.gridx = 7;
			gbc_lblKoenig.gridy = 1;
			panel_Schlag.add(getLblKoenig(), gbc_lblKoenig);
			GridBagConstraints gbc_lblSau = new GridBagConstraints();
			gbc_lblSau.insets = new Insets(25, 10, 5, 25);
			gbc_lblSau.gridx = 8;
			gbc_lblSau.gridy = 1;
			panel_Schlag.add(getLblSau(), gbc_lblSau);
			GridBagConstraints gbc_rdbtnSieben = new GridBagConstraints();
			gbc_rdbtnSieben.insets = new Insets(5, 25, 25, 10);
			gbc_rdbtnSieben.gridx = 1;
			gbc_rdbtnSieben.gridy = 2;
			panel_Schlag.add(getRdbtnSieben(), gbc_rdbtnSieben);
			GridBagConstraints gbc_rdbtnAcht = new GridBagConstraints();
			gbc_rdbtnAcht.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnAcht.gridx = 2;
			gbc_rdbtnAcht.gridy = 2;
			panel_Schlag.add(getRdbtnAcht(), gbc_rdbtnAcht);
			GridBagConstraints gbc_rdbtnNeun = new GridBagConstraints();
			gbc_rdbtnNeun.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnNeun.gridx = 3;
			gbc_rdbtnNeun.gridy = 2;
			panel_Schlag.add(getRdbtnNeun(), gbc_rdbtnNeun);
			GridBagConstraints gbc_rdbtnZehn = new GridBagConstraints();
			gbc_rdbtnZehn.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnZehn.gridx = 4;
			gbc_rdbtnZehn.gridy = 2;
			panel_Schlag.add(getRdbtnZehn(), gbc_rdbtnZehn);
			GridBagConstraints gbc_rdbtnUnter = new GridBagConstraints();
			gbc_rdbtnUnter.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnUnter.gridx = 5;
			gbc_rdbtnUnter.gridy = 2;
			panel_Schlag.add(getRdbtnUnter(), gbc_rdbtnUnter);
			GridBagConstraints gbc_rdbtnOber = new GridBagConstraints();
			gbc_rdbtnOber.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnOber.gridx = 6;
			gbc_rdbtnOber.gridy = 2;
			panel_Schlag.add(getRdbtnOber(), gbc_rdbtnOber);
			GridBagConstraints gbc_rdbtnKoenig = new GridBagConstraints();
			gbc_rdbtnKoenig.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnKoenig.gridx = 7;
			gbc_rdbtnKoenig.gridy = 2;
			panel_Schlag.add(getRdbtnKoenig(), gbc_rdbtnKoenig);
			GridBagConstraints gbc_rdbtnSau = new GridBagConstraints();
			gbc_rdbtnSau.insets = new Insets(5, 10, 25, 25);
			gbc_rdbtnSau.gridx = 8;
			gbc_rdbtnSau.gridy = 2;
			panel_Schlag.add(getRdbtnSau(), gbc_rdbtnSau);
			GridBagConstraints gbc_btnCommitFarbe = new GridBagConstraints();
			gbc_btnCommitFarbe.gridwidth = 9;
			gbc_btnCommitFarbe.insets = new Insets(0, 0, 0, 5);
			gbc_btnCommitFarbe.gridx = 0;
			gbc_btnCommitFarbe.gridy = 4;
			panel_Schlag.add(getBtnCommitSchlag(), gbc_btnCommitFarbe);

			ButtonGroup radios = new ButtonGroup();
			radios.add(getRdbtnSieben());
			radios.add(getRdbtnAcht());
			radios.add(getRdbtnNeun());
			radios.add(getRdbtnZehn());
			radios.add(getRdbtnUnter());
			radios.add(getRdbtnOber());
			radios.add(getRdbtnKoenig());
			radios.add(getRdbtnSau());
		}
		return panel_Schlag;
	}

	private JLabel getLblSieben() {
		if (lblSieben == null) {
			lblSieben = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/7.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblSieben.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblSieben;
	}

	private JLabel getLblAcht() {
		if (lblAcht == null) {
			lblAcht = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/8.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblAcht.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblAcht;
	}

	private JLabel getLblNeun() {
		if (lblNeun == null) {
			lblNeun = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/9.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblNeun.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblNeun;
	}

	private JLabel getLblZehn() {
		if (lblZehn == null) {
			lblZehn = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/10.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblZehn.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblZehn;
	}

	private JLabel getLblUnter() {
		if (lblUnter == null) {
			lblUnter = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/u.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblUnter.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblUnter;
	}

	private JLabel getLblOber() {
		if (lblOber == null) {
			lblOber = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/o.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblOber.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblOber;
	}

	private JLabel getLblKoenig() {
		if (lblKoenig == null) {
			lblKoenig = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/k.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblKoenig.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblKoenig;
	}

	private JLabel getLblSau() {
		if (lblSau == null) {
			lblSau = new JLabel("");
			try {
				URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/icons/s.png");
				Image img = ImageIO.read(urlLogo);
				Icon ic = new ImageIcon(img);
				lblSau.setIcon(ic);
			} catch (Exception e) {
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblSau;
	}

	private JRadioButton getRdbtnSieben() {
		if (rdbtnSieben == null) {
			rdbtnSieben = new JRadioButton("Sieben");
			rdbtnSieben.setBackground(hellesGruen);
			rdbtnSieben.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnSieben) {
						schlag_auswahl = SIEBEN;
					}
				}
			});
		}
		return rdbtnSieben;
	}

	private JRadioButton getRdbtnAcht() {
		if (rdbtnAcht == null) {
			rdbtnAcht = new JRadioButton("Acht");
			rdbtnAcht.setBackground(hellesGruen);
			rdbtnAcht.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnAcht) {
						schlag_auswahl = ACHT;
					}
				}
			});
		}
		return rdbtnAcht;
	}

	private JRadioButton getRdbtnNeun() {
		if (rdbtnNeun == null) {
			rdbtnNeun = new JRadioButton("Neun");
			rdbtnNeun.setBackground(hellesGruen);
			rdbtnNeun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnNeun) {
						schlag_auswahl = NEUN;
					}
				}
			});
		}
		return rdbtnNeun;
	}

	private JRadioButton getRdbtnZehn() {
		if (rdbtnZehn == null) {
			rdbtnZehn = new JRadioButton("Zehn");
			rdbtnZehn.setBackground(hellesGruen);
			rdbtnZehn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnZehn) {
						schlag_auswahl = ZEHN;
					}
				}
			});
		}
		return rdbtnZehn;
	}

	private JRadioButton getRdbtnUnter() {
		if (rdbtnUnter == null) {
			rdbtnUnter = new JRadioButton("Unter");
			rdbtnUnter.setBackground(hellesGruen);
			rdbtnUnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnUnter) {
						schlag_auswahl = UNTER;
					}
				}
			});
		}
		return rdbtnUnter;
	}

	private JRadioButton getRdbtnOber() {
		if (rdbtnOber == null) {
			rdbtnOber = new JRadioButton("Ober");
			rdbtnOber.setBackground(hellesGruen);
			rdbtnOber.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnOber) {
						schlag_auswahl = OBER;
					}
				}
			});
		}
		return rdbtnOber;
	}

	private JRadioButton getRdbtnKoenig() {
		if (rdbtnKoenig == null) {
			rdbtnKoenig = new JRadioButton("Koenig");
			rdbtnKoenig.setBackground(hellesGruen);
			rdbtnKoenig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnKoenig) {
						schlag_auswahl = KOENIG;
					}
				}
			});
		}
		return rdbtnKoenig;
	}

	private JRadioButton getRdbtnSau() {
		if (rdbtnSau == null) {
			rdbtnSau = new JRadioButton("Sau");
			rdbtnSau.setBackground(hellesGruen);
			rdbtnSau.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnSau) {
						schlag_auswahl = SAU;
					}
				}
			});
		}
		return rdbtnSau;
	}

	private JButton getBtnCommitSchlag() {
		if (btnCommitSchlag == null) {
			btnCommitSchlag = new JButton("Commit");
			btnCommitSchlag.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnCommitSchlag) {
						schlagCommit();
						frame.dispose();
					}
				}
			});
		}
		return btnCommitSchlag;
	}

	protected void schlagCommit() {

	}

	protected void farbCommit() {
		// TODO Auto-generated method stub

	}
}
