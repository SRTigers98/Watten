package meldungen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Meldung {

	private JFrame frame;
	private JPanel lower_panel;
	private JPanel upper_panel;

	/**
	 * Create the application.
	 */
	public Meldung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getLower_panel(), BorderLayout.SOUTH);
		frame.getContentPane().add(getUpper_panel(), BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private JPanel getLower_panel() {
		if (lower_panel == null) {
			lower_panel = new JPanel();
		}
		return lower_panel;
	}

	private JPanel getUpper_panel() {
		if (upper_panel == null) {
			upper_panel = new JPanel();
		}
		return upper_panel;
	}
}
