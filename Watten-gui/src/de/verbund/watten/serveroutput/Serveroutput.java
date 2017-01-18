package de.verbund.watten.serveroutput;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.TextArea;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

public class Serveroutput implements ActionListener {

	private JFrame frame;
	TextArea textArea = new TextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serveroutput window = new Serveroutput();
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
	public Serveroutput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
	}

	public void OutputNewLine (String outputLine) {
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
