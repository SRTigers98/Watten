package de.verbund.watten.meldungen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import de.verbund.watten.startfenster.Hauptmenue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Meldung {

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

	/**
	 * Create the application.
	 */
	public Meldung(int art, String meldung) {
		initialize();
		switch (art) {
		// Warnung
		case 1:
			initWarnung(meldung);
			break;
		// Fehler
		case 2:
			initFehler(meldung);
			break;
		// Hinweis
		case 3:
			initHinweis(meldung);
			break;
		}
	}

	private void initHinweis(String txt) {
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(getLowerPanelHinweis(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setTitle("Hinweis");
		lblMeldung.setText(txt);

	}

	private void initFehler(String txt) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getLowerPanelFehler(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setTitle("Fehler");
		lblMeldung.setText(txt);

	}

	private void initWarnung(String txt) {
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(getLowerPanelWarnung(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpperPanel(), BorderLayout.CENTER);
		frame.setTitle("Warnung");
		lblMeldung.setText(txt);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
			gbc_btnOk.anchor = GridBagConstraints.SOUTH;
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
						new Hauptmenue();
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
			gbl_lower_panel_fehler.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_lower_panel_fehler.rowHeights = new int[] { 0, 0 };
			gbl_lower_panel_fehler.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_lower_panel_fehler.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			lower_panel_fehler.setLayout(gbl_lower_panel_fehler);
			GridBagConstraints gbc_btnSchließen = new GridBagConstraints();
			gbc_btnSchließen.anchor = GridBagConstraints.SOUTH;
			gbc_btnSchließen.gridwidth = 11;
			gbc_btnSchließen.insets = new Insets(0, 0, 0, 5);
			gbc_btnSchließen.gridx = 0;
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
}
