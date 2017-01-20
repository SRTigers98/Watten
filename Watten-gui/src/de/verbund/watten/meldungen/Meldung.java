package de.verbund.watten.meldungen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import de.verbund.watten.startfenster.Hauptmenue;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

/**
 * Meldungen generiert Hinweise, Warnungen und Fehlermeldungen mit einem
 * übergebenen Text.
 * 
 * @author Mcscha
 *
 */
public class Meldung {

	private static final int HINWEIS = 3;
	private static final int FEHLER = 2;
	private static final int WARNUNG = 1;
	private JFrame frame;
	private JPanel lower_panel_warnung;
	private JPanel upper_panel;
	private JButton btnVerstanden;
	private JLabel lblMeldung;
	private JTextPane textPane;
	private JPanel lower_panel_hinweis;
	private JButton btnOk;
	private JPanel lower_panel_fehler;
	private JButton btnSchließen;
	private JButton btnDismiss;

	/**
	 * Test Launch der Fenster | Normaler Aufruf über den Kontruktor
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meldung window = new Meldung(2, "Test");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Erstellt ein Fenster welches einen Hinweis, eine Warnung oder einen
	 * Fehler ausgibt.
	 * 
	 * @param art
	 *            <br>
	 *            1- Es wird eine Warnung ausgegeben <br>
	 *            2- Es wird ein Fehler ausgegeben <br>
	 *            3- Es wird ein Hinweis ausgegeben <br>
	 * 
	 * @param meldung
	 *            <br>
	 *            Die Nachricht die in der Meldung wiedergegeben wird.
	 * 
	 * @return Durch klicken der Buttons unten auf den Meldungen passieren
	 *         folgende Dinge:<br>
	 *         - Bei einer Warnung oder einem Hinweis verschwindet das
	 *         Fenster.<br>
	 *         - Bei einem Fehler wird man zum Hauptmenü weitergeleitet.
	 * 
	 */
	public Meldung(int art, String meldung) {
		initialize();
		switch (art) {
		// Warnung
		case WARNUNG:
			initWarnung(meldung);
			break;
		// Fehler
		case FEHLER:
			initFehler(meldung);
			break;
		// Hinweis
		case HINWEIS:
			initHinweis(meldung);
			break;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(getLowerPanelFehler(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private void initHinweis(String txt) {
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(getLowerPanelHinweis(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setTitle("Hinweis");
		try {
			URL urlLogo = getClass().getClassLoader()
					.getResource("de/verbund/watten/meldungen/watten_notification.png");
			Image img = ImageIO.read(urlLogo);
			frame.setIconImage(img);
		} catch (Exception e) {
		}
		if (!txt.isEmpty())
			textPane.setText(txt);

	}

	private void initFehler(String txt) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getLowerPanelFehler(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setTitle("Fehler");
		try {
			URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/meldungen/watten_error.png");
			Image img = ImageIO.read(urlLogo);
			frame.setIconImage(img);
		} catch (Exception e) {
		}
		textPane.setText(txt);

	}

	private void initWarnung(String txt) {
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(getLowerPanelWarnung(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setTitle("Warnung");
		try {
			URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/meldungen/watten_warning.png");
			Image img = ImageIO.read(urlLogo);
			frame.setIconImage(img);
		} catch (Exception e) {
		}
		textPane.setText(txt);

	}

	private JPanel getUpperPanel() {
		if (upper_panel == null) {
			upper_panel = new JPanel();
			GridBagLayout gbl_upper_panel = new GridBagLayout();
			gbl_upper_panel.columnWidths = new int[] { 0, 0 };
			gbl_upper_panel.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_upper_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_upper_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
			upper_panel.setLayout(gbl_upper_panel);
			GridBagConstraints gbc_lblMeldung = new GridBagConstraints();
			gbc_lblMeldung.anchor = GridBagConstraints.WEST;
			gbc_lblMeldung.insets = new Insets(10, 10, 5, 0);
			gbc_lblMeldung.gridx = 0;
			gbc_lblMeldung.gridy = 0;
			upper_panel.add(getLblMeldung(), gbc_lblMeldung);
			GridBagConstraints gbc_textPane = new GridBagConstraints();
			gbc_textPane.insets = new Insets(10, 10, 10, 10);
			gbc_textPane.fill = GridBagConstraints.BOTH;
			gbc_textPane.gridx = 0;
			gbc_textPane.gridy = 2;
			upper_panel.add(getTextPane(), gbc_textPane);
		}
		return upper_panel;
	}

	private JLabel getLblMeldung() {
		if (lblMeldung == null) {
			lblMeldung = new JLabel("Meldung: ");
		}
		return lblMeldung;
	}

	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setEditable(false);
		}
		return textPane;
	}

	private JPanel getLowerPanelWarnung() {
		if (lower_panel_warnung == null) {
			lower_panel_warnung = new JPanel();
			GridBagLayout gbl_lower_panel = new GridBagLayout();
			gbl_lower_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_lower_panel.rowHeights = new int[] { 0, 0 };
			gbl_lower_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_lower_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			lower_panel_warnung.setLayout(gbl_lower_panel);
			GridBagConstraints gbc_btnOk = new GridBagConstraints();
			gbc_btnOk.insets = new Insets(0, 90, 5, 90);
			gbc_btnOk.gridwidth = 12;
			gbc_btnOk.gridx = 0;
			gbc_btnOk.gridy = 0;
			lower_panel_warnung.add(getBtnVerstanden(), gbc_btnOk);
		}
		return lower_panel_warnung;
	}

	private JButton getBtnVerstanden() {
		if (btnVerstanden == null) {
			btnVerstanden = new JButton("Verstanden");
			btnVerstanden.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnVerstanden) {
						frame.dispose();
					}
				}
			});
		}
		return btnVerstanden;
	}

	private JPanel getLowerPanelHinweis() {
		if (lower_panel_hinweis == null) {
			lower_panel_hinweis = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			lower_panel_hinweis.setLayout(gbl_panel);
			GridBagConstraints gbc_btnOk = new GridBagConstraints();
			gbc_btnOk.insets = new Insets(0, 125, 5, 125);
			gbc_btnOk.gridwidth = 11;
			gbc_btnOk.gridx = 0;
			gbc_btnOk.gridy = 0;
			lower_panel_hinweis.add(getBtnOk(), gbc_btnOk);
		}
		return lower_panel_hinweis;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnOk) {
						frame.dispose();
					}
				}
			});
		}
		return btnOk;
	}

	private JPanel getLowerPanelFehler() {
		if (lower_panel_fehler == null) {
			lower_panel_fehler = new JPanel();
			GridBagLayout gbl_lower_panel_fehler = new GridBagLayout();
			gbl_lower_panel_fehler.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0 };
			gbl_lower_panel_fehler.rowHeights = new int[] { 0, 0 };
			gbl_lower_panel_fehler.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_lower_panel_fehler.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			lower_panel_fehler.setLayout(gbl_lower_panel_fehler);
			GridBagConstraints gbc_btnDismiss = new GridBagConstraints();
			gbc_btnDismiss.insets = new Insets(0, 50, 0, 25);
			gbc_btnDismiss.gridx = 0;
			gbc_btnDismiss.gridy = 0;
			lower_panel_fehler.add(getBtnDismiss(), gbc_btnDismiss);
			GridBagConstraints gbc_btnSchließen = new GridBagConstraints();
			gbc_btnSchließen.insets = new Insets(0, 25, 0, 50);
			gbc_btnSchließen.gridx = 7;
			gbc_btnSchließen.gridy = 0;
			lower_panel_fehler.add(getBtnSchließen(), gbc_btnSchließen);
		}
		return lower_panel_fehler;
	}

	private JButton getBtnSchließen() {
		if (btnSchließen == null) {
			btnSchließen = new JButton("Schließen");
			btnSchließen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnSchließen) {
						new Hauptmenue();
						frame.dispose();
					}
				}
			});
		}
		return btnSchließen;
	}

	public void terminate() {
		frame.dispose();
	}

	private JButton getBtnDismiss() {
		if (btnDismiss == null) {
			btnDismiss = new JButton("Dismiss");
			btnDismiss.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnDismiss) {
						frame.dispose();
					}
				}
			});
		}
		return btnDismiss;
	}
}
