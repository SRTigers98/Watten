package de.verbund.watten.startfenster;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import de.verbund.watten.client.Client;
import de.verbund.watten.client.ClientDummy;
import de.verbund.watten.client.ClientImpl;
import de.verbund.watten.hauptfenster.Spielfenster;
import de.verbund.watten.konstanten.MeldungKonst;
import de.verbund.watten.meldungen.Meldung;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hauptmenue {

	private JFrame frame;
	private JLabel lblSpielername;
	private JTextField txtName;
	private JButton btnGo;
	private JLabel lblIpadresse;
	private JTextField txtIp;
	private JLabel lblPort;
	private JTextField txtPort;

	/**
	 * Zeigt das Hauptmenü an. Hier kann man Namen, Ip-Adresse und Port angeben
	 * um ein Spiel zu starten. Alle drei müssen angegeben werden.
	 * 
	 */
	@SuppressWarnings("serial")
	public Hauptmenue() {
		initialize();
		JPanel panel;
		try {
			URL urlLogo = getClass().getClassLoader().getResource("de/verbund/watten/startfenster/picasso.png");
			Image img = ImageIO.read(urlLogo);
			panel = new JPanel() {
				@Override
				public void paintComponent(Graphics g) {
					g.drawImage(img, 0, 0, null);
				}
			};
		} catch (IOException e1) {
			e1.printStackTrace();
			panel = new JPanel();
		}
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_lblSpielername = new GridBagConstraints();
		gbc_lblSpielername.insets = new Insets(390, 5, 5, 0);
		gbc_lblSpielername.gridwidth = 12;
		gbc_lblSpielername.gridx = 0;
		gbc_lblSpielername.gridy = 10;
		panel.add(getLblSpielername(), gbc_lblSpielername);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 5, 5, 0);
		gbc_txtName.gridwidth = 12;
		gbc_txtName.gridx = 0;
		gbc_txtName.gridy = 11;
		panel.add(getTxtName(), gbc_txtName);
		GridBagConstraints gbc_lblIpadresse = new GridBagConstraints();
		gbc_lblIpadresse.gridwidth = 12;
		gbc_lblIpadresse.insets = new Insets(0, 5, 5, 0);
		gbc_lblIpadresse.gridx = 0;
		gbc_lblIpadresse.gridy = 12;
		panel.add(getLblIpadresse(), gbc_lblIpadresse);
		GridBagConstraints gbc_txtIp = new GridBagConstraints();
		gbc_txtIp.gridwidth = 12;
		gbc_txtIp.insets = new Insets(0, 5, 5, 0);
		gbc_txtIp.gridx = 0;
		gbc_txtIp.gridy = 13;
		panel.add(getTxtIp(), gbc_txtIp);
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.gridwidth = 12;
		gbc_lblPort.insets = new Insets(0, 5, 5, 0);
		gbc_lblPort.gridx = 0;
		gbc_lblPort.gridy = 14;
		panel.add(getLblPort(), gbc_lblPort);
		GridBagConstraints gbc_txtPort = new GridBagConstraints();
		gbc_txtPort.gridwidth = 12;
		gbc_txtPort.insets = new Insets(0, 5, 5, 0);
		gbc_txtPort.gridx = 0;
		gbc_txtPort.gridy = 15;
		panel.add(getTxtPort(), gbc_txtPort);
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.gridwidth = 12;
		gbc_btnGo.insets = new Insets(20, 5, 0, 0);
		gbc_btnGo.gridx = 0;
		gbc_btnGo.gridy = 16;
		panel.add(getBtnGo(), gbc_btnGo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1020, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getRootPane().setDefaultButton(getBtnGo());
	}

	private JLabel getLblSpielername() {
		if (lblSpielername == null) {
			lblSpielername = new JLabel("Spielername :");
		}
		return lblSpielername;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setColumns(10);
		}
		return txtName;
	}

	private JButton getBtnGo() {
		if (btnGo == null) {
			btnGo = new JButton("Go");
			StringBuffer txt = new StringBuffer();
			btnGo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean korrekt = true;
					if (e.getSource() == btnGo) {
						if (txtName.getText().isEmpty() || txtName.getText().equals("")) {
							txt.append("Sie müssen einen Namen angeben. \n");
							korrekt = false;
						}
						if (txtIp.getText().isEmpty() || txtName.getText().equals("")) {
							if (!txtIp.getText().matches("")) {
								txt.append("Der eingegebene Text entspricht nicht einer IP_Adresse. \n");
							} else {
								txt.append("Sie müssen eine IP-Adresse angeben. \n");
							}
							korrekt = false;
						}
						if (txtPort.getText().isEmpty() || txtPort.getText().equals("")) {
							txt.append("Sie müssen einen Port angeben. \n");
							korrekt = false;
						}
						if (korrekt) {
							Spielfenster spiel = new Spielfenster(txtName.getText());
							// Bei fertigen Programm Dummy wieder durch
							// ClientImpl ersetzten
							// Client server = new ClientImpl(spiel);
							ClientDummy server = new ClientDummy(spiel);
							server.sendeName(txtName.getText());

							frame.dispose();
						}
						new Meldung(MeldungKonst.HINWEIS, txt.toString());
					}
				}
			});
		}
		return btnGo;

	}

	private JLabel getLblIpadresse() {
		if (lblIpadresse == null) {
			lblIpadresse = new JLabel("Ip-Adresse :");
		}
		return lblIpadresse;
	}

	private JTextField getTxtIp() {
		if (txtIp == null) {
			txtIp = new JTextField();
			txtIp.setColumns(10);
		}
		return txtIp;
	}

	private JLabel getLblPort() {
		if (lblPort == null) {
			lblPort = new JLabel("Port :");
		}
		return lblPort;
	}

	private JTextField getTxtPort() {
		if (txtPort == null) {
			txtPort = new JTextField();
			txtPort.setColumns(10);
		}
		return txtPort;
	}
}
