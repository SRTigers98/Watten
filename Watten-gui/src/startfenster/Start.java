package startfenster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Info");

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblKartenspielWatten = new JLabel("Kartenspiel Watten");
		GridBagConstraints gbc_lblKartenspielWatten = new GridBagConstraints();
		gbc_lblKartenspielWatten.gridwidth = 10;
		gbc_lblKartenspielWatten.insets = new Insets(5, 5, 5, 5);
		gbc_lblKartenspielWatten.gridx = 0;
		gbc_lblKartenspielWatten.gridy = 0;
		panel.add(lblKartenspielWatten, gbc_lblKartenspielWatten);

		JButton btnHauptmen = new JButton("Weiter zum Hauptmenü");
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnHauptmen) {
					new Hauptmenü();
					frame.dispose();
				}
			}
		});
		GridBagConstraints gbc_btnHauptmen = new GridBagConstraints();
		gbc_btnHauptmen.gridwidth = 10;
		gbc_btnHauptmen.insets = new Insets(0, 0, 5, 5);
		gbc_btnHauptmen.gridx = 0;
		gbc_btnHauptmen.gridy = 2;
		panel.add(btnHauptmen, gbc_btnHauptmen);

		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setEditable(false);
		txtpnInfo.setText(
				"Es soll das Kartenspiel Watten realisiert werden. Dies soll mit mind. 2 Spielern gespielt werden.");
		GridBagConstraints gbc_txtpnInfo = new GridBagConstraints();
		gbc_txtpnInfo.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnInfo.fill = GridBagConstraints.BOTH;
		gbc_txtpnInfo.gridx = 0;
		gbc_txtpnInfo.gridy = 4;
		panel.add(txtpnInfo, gbc_txtpnInfo);

		JTextPane txtpnMitwirkende = new JTextPane();
		txtpnMitwirkende.setEditable(false);
		txtpnMitwirkende.setText(
				"Mitwirkende:\r\n-Benjamin (Projektleiter : Business/Service)\r\n-Fabian (Test)\r\n-Sven (Gui)\r\n-Benedikt (Integration)\r\n-Marc (Gui)");
		GridBagConstraints gbc_txtpnMitwirkende = new GridBagConstraints();
		gbc_txtpnMitwirkende.gridwidth = 8;
		gbc_txtpnMitwirkende.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnMitwirkende.fill = GridBagConstraints.BOTH;
		gbc_txtpnMitwirkende.gridx = 1;
		gbc_txtpnMitwirkende.gridy = 4;
		panel.add(txtpnMitwirkende, gbc_txtpnMitwirkende);
	}

}