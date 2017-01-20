package de.verbund.watten.endfenster;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.verbund.watten.client.Client;
import de.verbund.watten.hauptfenster.Spielfenster;
import de.verbund.watten.meldungen.Meldung;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Dieses Fenster erscheint wenn ein Match abgeschlossen wurde. Es zeigt ein
 * Image das wiederspiegelt ob man Gewonnen oder Verloren hat. Zudem zeigt es
 * die Statistiken des Matches. Man kann mit 2 Button entweder direkt ein neues
 * Match starten oder ins Hauptmenü gelangen.
 * 
 * @author Mcscha
 *
 */
public class Endfenster {

	private JFrame frame;
	private JPanel lower_panel;
	private JPanel upper_panel;
	private JButton btnNeuesSpiel;
	private JButton btnHauptmenue;
	private JLabel lblSp1;
	private JLabel lblSp2;
	private JLabel lblSticheSp1;
	private JLabel lblSticheSp2;
	private JTextField txtSticheSp1;
	private JTextField txtSticheSp2;
	private JLabel lblPunkteSp1;
	private JLabel lblPunkteSp2;
	private JTextField txtPunkteSp1;
	private JTextField txtPunkteSp2;
	private JLabel lblIcon;

	// Variablen zum Füllen der Screens
	private boolean gewonnen = true;
	private String playerSelf = "Sp1";
	private String playerOther = "Sp2";
	private int sticheSelf = 0;
	private int sticheOther = 0;
	private int punkteSelf = 0;
	private int punkteOther = 0;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Endfenster window = new Endfenster("Max", "Mike", 1, 2, 10, 10, false, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kontruktor der die nötigen Variablen setzt und das entfenster
	 * initialisiert.
	 * 
	 * @param p1
	 *            Übergabe des eigenen Namens
	 * 
	 * @param p2
	 *            Übergabe des Names vom Kontrahenten
	 * 
	 * @param stich1
	 *            Anzahl der eigenen Stiche.
	 * 
	 * @param stich2
	 *            Anzahl der Stiche des Kontrahenten
	 * 
	 * @param punkte1
	 *            Anzahl der eigenen Punkte
	 * 
	 * @param punkte2
	 *            Anzahl der Punkte des Kontrahenten
	 * 
	 * @param gewonnen
	 *            Angabe ob man selbst gewonnen hat <br>
	 *            true : gewonnen <br>
	 *            false : verloren
	 * 
	 * 
	 * 
	 */
	public Endfenster(String p1, String p2, int stich1, int stich2, int punkte1, int punkte2, boolean gewonnen,
			Client client) {
		playerSelf = p1;
		playerOther = p2;
		sticheSelf = stich1;
		sticheOther = stich2;
		punkteSelf = punkte1;
		punkteOther = punkte2;
		this.gewonnen = gewonnen;
		this.client = client;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getLower_panel(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpper_panel(), BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private JPanel getLower_panel() {
		if (lower_panel == null) {
			lower_panel = new JPanel();
			GridBagLayout gbl_lower_panel = new GridBagLayout();
			gbl_lower_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_lower_panel.rowHeights = new int[] { 0, 0 };
			gbl_lower_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_lower_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			lower_panel.setLayout(gbl_lower_panel);
			GridBagConstraints gbc_btnNeuesSpiel = new GridBagConstraints();
			gbc_btnNeuesSpiel.gridwidth = 8;
			gbc_btnNeuesSpiel.insets = new Insets(25, 800, 25, 150);
			gbc_btnNeuesSpiel.gridx = 0;
			gbc_btnNeuesSpiel.gridy = 0;
			lower_panel.add(getBtnNeuesSpiel(), gbc_btnNeuesSpiel);
			GridBagConstraints gbc_btnHauptmenue = new GridBagConstraints();
			gbc_btnHauptmenue.gridwidth = 8;
			gbc_btnHauptmenue.insets = new Insets(25, 150, 25, 800);
			gbc_btnHauptmenue.gridx = 8;
			gbc_btnHauptmenue.gridy = 0;
			lower_panel.add(getBtnHauptmenue(), gbc_btnHauptmenue);
		}
		return lower_panel;
	}

	private JPanel getUpper_panel() {
		if (upper_panel == null) {

			/*
			 * try { URL urlLogo; if (gewonnen) { urlLogo =
			 * getClass().getClassLoader().getResource(
			 * "de/verbund/watten/endfenster/Gewonnen.png"); } else { urlLogo =
			 * getClass().getClassLoader().getResource(
			 * "de/verbund/watten/endfenster/Verloren.jpg"); } Image img =
			 * ImageIO.read(urlLogo); upper_panel = new JPanel() {
			 * 
			 * @Override public void paint(Graphics g) { g.drawImage(img, 0, 0,
			 * null); } }; } catch (Exception e) { upper_panel = new JPanel(); }
			 */
			upper_panel = new JPanel();

			GridBagLayout gbl_upper_panel = new GridBagLayout();
			gbl_upper_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_upper_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_upper_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
			gbl_upper_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			upper_panel.setLayout(gbl_upper_panel);

			GridBagConstraints gbc_lblIcon = new GridBagConstraints();
			gbc_lblIcon.gridwidth = 16;
			gbc_lblIcon.insets = new Insets(0, 0, 5, 5);
			gbc_lblIcon.gridx = 0;
			gbc_lblIcon.gridy = 0;
			upper_panel.add(getLblIcon(), gbc_lblIcon);

			GridBagConstraints gbc_lblSp1 = new GridBagConstraints();
			gbc_lblSp1.anchor = GridBagConstraints.WEST;
			gbc_lblSp1.insets = new Insets(0, 0, 5, 50);
			gbc_lblSp1.gridx = 0;
			gbc_lblSp1.gridy = 1;
			upper_panel.add(getLblSp1(), gbc_lblSp1);
			GridBagConstraints gbc_lblSp2 = new GridBagConstraints();
			gbc_lblSp2.gridwidth = 2;
			gbc_lblSp2.anchor = GridBagConstraints.WEST;
			gbc_lblSp2.insets = new Insets(0, 1295, 5, 5);
			gbc_lblSp2.gridx = 14;
			gbc_lblSp2.gridy = 1;
			upper_panel.add(getLblSp2(), gbc_lblSp2);
			GridBagConstraints gbc_lblSticheSp1 = new GridBagConstraints();
			gbc_lblSticheSp1.anchor = GridBagConstraints.WEST;
			gbc_lblSticheSp1.gridwidth = 2;
			gbc_lblSticheSp1.insets = new Insets(0, 0, 5, 5);
			gbc_lblSticheSp1.gridx = 0;
			gbc_lblSticheSp1.gridy = 2;
			upper_panel.add(getLblSticheSp1(), gbc_lblSticheSp1);
			GridBagConstraints gbc_lblSticheSp2 = new GridBagConstraints();
			gbc_lblSticheSp2.insets = new Insets(0, 1305, 5, 0);
			gbc_lblSticheSp2.gridwidth = 3;
			gbc_lblSticheSp2.gridx = 13;
			gbc_lblSticheSp2.gridy = 2;
			upper_panel.add(getLblSticheSp2(), gbc_lblSticheSp2);
			GridBagConstraints gbc_txtSticheSp1 = new GridBagConstraints();
			gbc_txtSticheSp1.anchor = GridBagConstraints.WEST;
			gbc_txtSticheSp1.gridwidth = 2;
			gbc_txtSticheSp1.insets = new Insets(0, 0, 5, 5);
			gbc_txtSticheSp1.gridx = 0;
			gbc_txtSticheSp1.gridy = 3;
			upper_panel.add(getTxtSticheSp1(), gbc_txtSticheSp1);
			GridBagConstraints gbc_txtSticheSp2 = new GridBagConstraints();
			gbc_txtSticheSp2.anchor = GridBagConstraints.EAST;
			gbc_txtSticheSp2.insets = new Insets(0, 0, 5, 0);
			gbc_txtSticheSp2.gridwidth = 3;
			gbc_txtSticheSp2.gridx = 13;
			gbc_txtSticheSp2.gridy = 3;
			upper_panel.add(getTxtSticheSp2(), gbc_txtSticheSp2);
			GridBagConstraints gbc_lblPunkteSp1 = new GridBagConstraints();
			gbc_lblPunkteSp1.anchor = GridBagConstraints.WEST;
			gbc_lblPunkteSp1.gridwidth = 2;
			gbc_lblPunkteSp1.insets = new Insets(0, 0, 5, 5);
			gbc_lblPunkteSp1.gridx = 0;
			gbc_lblPunkteSp1.gridy = 4;
			upper_panel.add(getLblPunkteSp1(), gbc_lblPunkteSp1);
			GridBagConstraints gbc_lblPunkteSp2 = new GridBagConstraints();
			gbc_lblPunkteSp2.gridwidth = 3;
			gbc_lblPunkteSp2.insets = new Insets(0, 1310, 5, 0);
			gbc_lblPunkteSp2.gridx = 13;
			gbc_lblPunkteSp2.gridy = 4;
			upper_panel.add(getLblPunkteSp2(), gbc_lblPunkteSp2);
			GridBagConstraints gbc_txtPunkteSp1 = new GridBagConstraints();
			gbc_txtPunkteSp1.anchor = GridBagConstraints.WEST;
			gbc_txtPunkteSp1.gridwidth = 2;
			gbc_txtPunkteSp1.insets = new Insets(0, 0, 0, 5);
			gbc_txtPunkteSp1.gridx = 0;
			gbc_txtPunkteSp1.gridy = 5;
			upper_panel.add(getTxtPunkteSp1(), gbc_txtPunkteSp1);
			GridBagConstraints gbc_txtPunkteSp2 = new GridBagConstraints();
			gbc_txtPunkteSp2.anchor = GridBagConstraints.EAST;
			gbc_txtPunkteSp2.gridwidth = 3;
			gbc_txtPunkteSp2.gridx = 13;
			gbc_txtPunkteSp2.gridy = 5;
			upper_panel.add(getTxtPunkteSp2(), gbc_txtPunkteSp2);
		}
		upper_panel.setOpaque(true);
		return upper_panel;

	}

	private JButton getBtnNeuesSpiel() {
		if (btnNeuesSpiel == null) {
			btnNeuesSpiel = new JButton("Neues Spiel");
			btnNeuesSpiel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Spielfenster(playerSelf);
				}
			});
		}
		return btnNeuesSpiel;
	}

	private JButton getBtnHauptmenue() {
		if (btnHauptmenue == null) {
			btnHauptmenue = new JButton("Ins Hauptmenü");
			btnHauptmenue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnHauptmenue) {
						System.out.println("Höhe:" + frame.getHeight() + "| Breite:" + frame.getWidth());

						frame.dispose();
					}
				}
			});
		}
		return btnHauptmenue;
	}

	private JLabel getLblSp1() {
		if (lblSp1 == null) {
			lblSp1 = new JLabel(playerSelf);
			lblSp1.setOpaque(true);
		}
		return lblSp1;
	}

	private JLabel getLblSp2() {
		if (lblSp2 == null) {
			lblSp2 = new JLabel(playerOther);
		}
		return lblSp2;
	}

	private JLabel getLblSticheSp1() {
		if (lblSticheSp1 == null) {
			lblSticheSp1 = new JLabel("Stiche :");
		}
		return lblSticheSp1;
	}

	private JLabel getLblSticheSp2() {
		if (lblSticheSp2 == null) {
			lblSticheSp2 = new JLabel("Stiche :");
		}
		return lblSticheSp2;
	}

	private JTextField getTxtSticheSp1() {
		if (txtSticheSp1 == null) {
			txtSticheSp1 = new JTextField();
			txtSticheSp1.setText("" + sticheSelf);
			txtSticheSp1.setEditable(false);
			txtSticheSp1.setColumns(10);
		}
		return txtSticheSp1;
	}

	private JTextField getTxtSticheSp2() {
		if (txtSticheSp2 == null) {
			txtSticheSp2 = new JTextField();
			txtSticheSp2.setText("" + sticheOther);
			txtSticheSp2.setEditable(false);
			txtSticheSp2.setColumns(10);
		}
		return txtSticheSp2;
	}

	private JLabel getLblPunkteSp1() {
		if (lblPunkteSp1 == null) {
			lblPunkteSp1 = new JLabel("Punkte :");
		}
		return lblPunkteSp1;
	}

	private JLabel getLblPunkteSp2() {
		if (lblPunkteSp2 == null) {
			lblPunkteSp2 = new JLabel("Punkte :");
		}
		return lblPunkteSp2;
	}

	private JTextField getTxtPunkteSp1() {
		if (txtPunkteSp1 == null) {
			txtPunkteSp1 = new JTextField();
			txtPunkteSp1.setText("" + punkteSelf);
			txtPunkteSp1.setEditable(false);
			txtPunkteSp1.setColumns(10);
		}
		return txtPunkteSp1;
	}

	private JTextField getTxtPunkteSp2() {
		if (txtPunkteSp2 == null) {
			txtPunkteSp2 = new JTextField();
			txtPunkteSp2.setText("" + punkteOther);
			txtPunkteSp2.setEditable(false);
			txtPunkteSp2.setColumns(10);
		}
		return txtPunkteSp2;
	}

	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("Test");
			/*
			 * try { URL urlLogo; if (gewonnen) { urlLogo =
			 * getClass().getClassLoader().getResource(
			 * "de/verbund/watten/endfenster/Gewonnen.png"); } else { urlLogo =
			 * getClass().getClassLoader().getResource(
			 * "de/verbund/watten/endfenster/Verloren.jpg"); } Image img =
			 * ImageIO.read(urlLogo); Icon ic = new ImageIcon(img);
			 * lblIcon.setIcon(ic); } catch (Exception e) { new Meldung(2,
			 * "Icon konnte nicht geladen werden!"); frame.dispose(); }
			 * lblIcon.setSize(1600, 400);
			 */
		}
		return lblIcon;
	}
}
