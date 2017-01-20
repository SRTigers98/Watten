package de.verbund.watten.server.start;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import de.verbund.watten.exception.WattenException;
import de.verbund.watten.server.WattenServer;

/**
 * 
 * Die GUI für den Server.
 * 
 * @author Benedikt
 *
 */
public class Serveroutput {

	private JFrame frame;
	private TextArea textArea;
	private Label lPort;
	private TextField textField;
	private static Serveroutput window;
	private static WattenServer wattenServer;
	private Button bPort;
	private Button bShutdown;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Serveroutput();
					window.outputNewLine("Bitte Port eingeben...");
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

		bShutdown = new Button("Shutdown Server and Close");
		bShutdown.setFont(new Font("Courier New", Font.PLAIN, 12));
		bShutdown.setBounds(609, 0, 175, 22);
		bShutdown.setEnabled(false);
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
				portSetzen(textField.getText());
			}
		});
	}

	protected void portSetzen(String port) {
		try {
			int portInt = Integer.parseInt(port);
			if (portInt <= 1024) {
				throw new WattenException("Bitte Port > 1024 eingeben!");
			}
			bShutdown.setEnabled(true);
			bPort.setEnabled(false);
			wattenServer = new WattenServer(window, portInt);
		} catch (NumberFormatException e) {
			outputNewLine("Bitte eine gültige Zahl eingeben!");
		} catch (WattenException e) {
			outputNewLine(e.getMessage());
		}
	}

	public void outputNewLine(String outputLine) {
		SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY   HH:mm:ss:   - ");
		Date date = new Date();
		String timestamp = formatter.format(date);
		String tField = new String();
		if (tField.equals(null)) {
			textArea.setText(timestamp + outputLine + "\n");
		} else {
			textArea.append(timestamp + outputLine + "\n");
		}

	}

	public void bindException() {
		outputNewLine("Port bereits in Nutzung! Bitte anderen Port eingeben.");
		bPort.setEnabled(true);
		bShutdown.setEnabled(false);
	}

}
