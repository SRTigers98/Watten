package de.verbund.watten.spielbeginn;

import java.awt.EventQueue;
import java.awt.Graphics;
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

public class Auswahlfenster {

	private static final int EICHEL = 6;
	private static final int HERZ = 5;
	private static final int SCHELLN = 4;
	private static final int BLAU = 3;
	private static final int FARBE_WAHL = 2;
	private static final int SCHLAG_WAHL = 1;
	private int schlag_auswahl;
	private int farb_auwahl;
	private JFrame frame;
	private JPanel panel_schlag;
	private JLabel lblBlau;
	private JRadioButton rdbtnBlau;
	private JLabel lblSchelln;
	private JRadioButton rdbtnSchelln;
	private JLabel lblHerz;
	private JRadioButton rdbtnHerz;
	private JLabel lblEichel;
	private JRadioButton rdbtnEichel;
	private JButton btnCommit;
	private Color gruen = new Color(0, 64, 0);

	/**
	 * Launch the application.
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
		case SCHLAG_WAHL:
			initSchlag();
			break;
		case FARBE_WAHL:
			initFarbe();
			break;
		}
	}

	/**
	 * Initialisiert das Fenster wenn der Schlag ausgewählt werden soll.
	 */
	private void initSchlag() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 240);
		frame.setTitle("Schlag Auswahl");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel_schlag(), BorderLayout.CENTER);
	}

	/**
	 * Initialisiert das Fenster wenn die Farbe ausgewählt werden soll.
	 */
	private void initFarbe() {
		// TODO Auto-generated method stub

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel_schlag(), BorderLayout.CENTER);
	}

	private JPanel getPanel_schlag() {
		if (panel_schlag == null) {
			panel_schlag = new JPanel();
			panel_schlag.setBackground(gruen);
			GridBagLayout gbl_panel_schlag = new GridBagLayout();
			gbl_panel_schlag.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_schlag.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_schlag.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_schlag.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			panel_schlag.setLayout(gbl_panel_schlag);
			GridBagConstraints gbc_lblBlau = new GridBagConstraints();
			gbc_lblBlau.insets = new Insets(25, 25, 5, 10);
			gbc_lblBlau.gridx = 1;
			gbc_lblBlau.gridy = 2;
			panel_schlag.add(getLblBlau(), gbc_lblBlau);
			GridBagConstraints gbc_lblSchelln = new GridBagConstraints();
			gbc_lblSchelln.insets = new Insets(25, 10, 5, 10);
			gbc_lblSchelln.gridx = 2;
			gbc_lblSchelln.gridy = 2;
			panel_schlag.add(getLblSchelln(), gbc_lblSchelln);
			GridBagConstraints gbc_lblHerz = new GridBagConstraints();
			gbc_lblHerz.insets = new Insets(25, 10, 5, 10);
			gbc_lblHerz.gridx = 3;
			gbc_lblHerz.gridy = 2;
			panel_schlag.add(getLblHerz(), gbc_lblHerz);
			GridBagConstraints gbc_lblEichel = new GridBagConstraints();
			gbc_lblEichel.insets = new Insets(25, 10, 5, 25);
			gbc_lblEichel.gridx = 4;
			gbc_lblEichel.gridy = 2;
			panel_schlag.add(getLblEichel(), gbc_lblEichel);
			GridBagConstraints gbc_rdbtnBlau = new GridBagConstraints();
			gbc_rdbtnBlau.insets = new Insets(5, 25, 25, 10);
			gbc_rdbtnBlau.gridx = 1;
			gbc_rdbtnBlau.gridy = 4;
			panel_schlag.add(getRdbtnBlau(), gbc_rdbtnBlau);
			GridBagConstraints gbc_rdbtnSchelln = new GridBagConstraints();
			gbc_rdbtnSchelln.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnSchelln.gridx = 2;
			gbc_rdbtnSchelln.gridy = 4;
			panel_schlag.add(getRdbtnSchelln(), gbc_rdbtnSchelln);
			GridBagConstraints gbc_rdbtnHerz = new GridBagConstraints();
			gbc_rdbtnHerz.insets = new Insets(5, 10, 25, 10);
			gbc_rdbtnHerz.gridx = 3;
			gbc_rdbtnHerz.gridy = 4;
			panel_schlag.add(getRdbtnHerz(), gbc_rdbtnHerz);
			GridBagConstraints gbc_rdbtnEichel = new GridBagConstraints();
			gbc_rdbtnEichel.insets = new Insets(5, 10, 25, 25);
			gbc_rdbtnEichel.gridx = 4;
			gbc_rdbtnEichel.gridy = 4;
			panel_schlag.add(getRdbtnEichel(), gbc_rdbtnEichel);
			GridBagConstraints gbc_btnCommit = new GridBagConstraints();
			gbc_btnCommit.gridwidth = 6;
			gbc_btnCommit.insets = new Insets(0, 0, 5, 5);
			gbc_btnCommit.gridx = 0;
			gbc_btnCommit.gridy = 7;
			panel_schlag.add(getBtnCommit(), gbc_btnCommit);

			ButtonGroup radios = new ButtonGroup();
			radios.add(getRdbtnBlau());
			radios.add(getRdbtnEichel());
			radios.add(getRdbtnHerz());
			radios.add(getRdbtnSchelln());
		}
		return panel_schlag;
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
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblBlau;
	}

	private JRadioButton getRdbtnBlau() {
		if (rdbtnBlau == null) {
			rdbtnBlau = new JRadioButton("Blau");
			rdbtnBlau.setBackground(gruen);
			rdbtnBlau.setForeground(Color.WHITE);
			rdbtnBlau.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnBlau) {
						schlag_auswahl = BLAU;
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
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblSchelln;
	}

	private JRadioButton getRdbtnSchelln() {
		if (rdbtnSchelln == null) {
			rdbtnSchelln = new JRadioButton("Schelln");
			rdbtnSchelln.setBackground(gruen);
			rdbtnSchelln.setForeground(Color.WHITE);
			rdbtnSchelln.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnSchelln) {
						schlag_auswahl = SCHELLN;
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
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblHerz;
	}

	private JRadioButton getRdbtnHerz() {
		if (rdbtnHerz == null) {
			rdbtnHerz = new JRadioButton("Herz");
			rdbtnHerz.setBackground(gruen);
			rdbtnHerz.setForeground(Color.WHITE);
			rdbtnHerz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnHerz) {
						schlag_auswahl = HERZ;
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
				new Meldung(2, "Schlag konnte nicht geladen werden!");
				frame.dispose();
			}
		}
		return lblEichel;
	}

	private JRadioButton getRdbtnEichel() {
		if (rdbtnEichel == null) {
			rdbtnEichel = new JRadioButton("Eichel");
			rdbtnEichel.setBackground(gruen);
			rdbtnEichel.setForeground(Color.WHITE);
			rdbtnEichel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == rdbtnEichel) {
						schlag_auswahl = EICHEL;
					}
				}
			});
		}
		return rdbtnEichel;
	}

	private JButton getBtnCommit() {
		if (btnCommit == null) {
			btnCommit = new JButton("Commit");
			btnCommit.setBackground(Color.WHITE);
			btnCommit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnCommit) {
						schlagCommit();
					}
				}
			});
		}
		return btnCommit;
	}

	protected void schlagCommit() {
		// TODO Auto-generated method stub

	}
}
