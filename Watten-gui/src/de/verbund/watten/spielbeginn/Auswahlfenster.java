package de.verbund.watten.spielbeginn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Auswahlfenster {

	private JFrame frame;
	private JPanel panel_schlag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auswahlfenster window = new Auswahlfenster();
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
	public Auswahlfenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel_schlag(), BorderLayout.CENTER);
	}

	private JPanel getPanel_schlag() {
		if (panel_schlag == null) {
			panel_schlag = new JPanel();
		}
		return panel_schlag;
	}
}
