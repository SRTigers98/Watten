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

import de.verbund.watten.client.ClientImpl;
import de.verbund.watten.client.gui.ClientGUI;
import de.verbund.watten.hauptfenster.Spielfenster;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hauptmenue {

	private JFrame frame;
	private JLabel lblSpielername;
	private JTextField txtName;
	private JLabel lblFehlermeldung;
	private JButton btnGo;
	private ClientImpl server = new ClientImpl(null);

	/**
	 * Create the application.
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
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_lblSpielername = new GridBagConstraints();
		gbc_lblSpielername.insets = new Insets(400, 0, 5, 0);
		gbc_lblSpielername.gridwidth = 12;
		gbc_lblSpielername.gridx = 0;
		gbc_lblSpielername.gridy = 10;
		panel.add(getLblSpielername(), gbc_lblSpielername);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridwidth = 12;
		gbc_txtName.gridx = 0;
		gbc_txtName.gridy = 11;
		panel.add(getTxtName(), gbc_txtName);
		GridBagConstraints gbc_lblFehlermeldung = new GridBagConstraints();
		gbc_lblFehlermeldung.insets = new Insets(0, 0, 5, 5);
		gbc_lblFehlermeldung.gridx = 0;
		gbc_lblFehlermeldung.gridy = 12;
		panel.add(getLblFehlermeldung(), gbc_lblFehlermeldung);
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.gridwidth = 12;
		gbc_btnGo.insets = new Insets(50, 0, 0, 5);
		gbc_btnGo.gridx = 0;
		gbc_btnGo.gridy = 14;
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

	private JLabel getLblFehlermeldung() {
		if (lblFehlermeldung == null) {
			lblFehlermeldung = new JLabel("");
		}
		return lblFehlermeldung;
	}

	private JButton getBtnGo() {
		if (btnGo == null) {
			btnGo = new JButton("Go");

			btnGo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnGo) {
						if (txtName.getText().isEmpty() || txtName.getText().equals("")) {
							lblFehlermeldung.setText("Bitte geben Sie einen Namen an.");
						} else {
							server.sendeName(txtName.getText());
							new Spielfenster(txtName.getText(), server);
							frame.dispose();
						}
					}
				}
			});
		}
		return btnGo;
	}
}
