package de.verbund.watten.server.start;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import de.verbund.watten.server.WattenServer;
import java.awt.Label;
import java.awt.TextField;

/**
 * 
 * Die GUI für den Server.
 * 
 * @author Benedikt
 *
 */
public class Serveroutput {

	private JFrame frame;
	TextArea textArea;
	private Label lPort;
	private TextField textField;
	private static Serveroutput window;
	private static WattenServer wattenServer;
	private Button bPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Serveroutput();
					wattenServer = new WattenServer(window);
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
		bShutdown.setFont(new Font("Courier New", Font.PLAIN, 12));
		bShutdown.setBounds(609, 0, 175, 22);
		bShutdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wattenServer.beende();
				System.exit(0);
			}
		});

		frame.getContentPane().add(bShutdown);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setEditable(false);

		textArea.setBounds(0, 22, 784, 339);
		frame.getContentPane().add(textArea);
		
		lPort = new Label("Port:");
		lPort.setFont(new Font("Cordia New", Font.PLAIN, 12));
		lPort.setBounds(0, 0, 36, 22);
		frame.getContentPane().add(lPort);
		
		textField = new TextField();
		textField.setBounds(38, 0, 90, 22);
		frame.getContentPane().add(textField);
		
		bPort = new Button("Set Port");
		bPort.setBounds(129, 0, 70, 22);
		frame.getContentPane().add(bPort);
		frame.setVisible(true);
		bPort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO setze Port (wird im Textfeld eingelesen)				
			}	
		});
	}

	public void outputNewLine(String outputLine) {
		if (textArea.getText().equals("")) {
			textArea.setText(outputLine);
		} else {
			textArea.setText(textArea.getText().toString() + "\n" + outputLine);
		}

	}
	
}
