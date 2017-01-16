package meldungen;

import javax.swing.JFrame;

public class Hinweis extends Meldung {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Hinweis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
