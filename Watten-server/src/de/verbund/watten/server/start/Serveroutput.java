package de.verbund.watten.server.start;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import de.verbund.watten.server.WattenServer;

/**
 * 
 * Die GUI für den Server.
 * 
 * @author Benedikt
 *
 */
public class Serveroutput implements ActionListener {

	private JFrame frame;
	TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serveroutput window = new Serveroutput();
					new WattenServer(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Serveroutput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		textArea = new TextArea();
		frame.setBounds(100, 100, 800, 400);
		frame.setTitle("Server Output");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Button bShutdown = new Button("Shutdown Server and Close");
		bShutdown.setBounds(0, 339, 784, 22);
		bShutdown.addActionListener(this);

		frame.getContentPane().add(bShutdown);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setEditable(false);

		textArea.setBounds(0, 0, 784, 339);
		frame.getContentPane().add(textArea);
		frame.setVisible(true);
	}

	public void outputNewLine(String outputLine) {
		if (textArea.getText().equals("")) {
			textArea.setText(outputLine);
		} else {
			textArea.setText(textArea.getText().toString() + "\n" + outputLine);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Server Shutdown
		System.exit(0);
	}
}
