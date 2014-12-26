package com.sirma.itt.evgeni.task5;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;

/**
 * Read, send and reverse messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class MessageReverserApp extends JFrame implements ActionListener,
		ComunicatorListener {

	MessageReverser messageReverser;
	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JLabel conectionStatus = new JLabel();
	JTextArea textArea = new JTextArea();

	public MessageReverserApp() {

		setTitle("Server");
		JPanel panel = new JPanel();
		add(panel);
		JLabel ipLabel = new JLabel("IP");
		ipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setText("localhost");
		ipAdress.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setMaximumSize(new Dimension(150, 20));
		JLabel portLabel = new JLabel("Port");
		portLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setText("7005");
		port.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setMaximumSize(new Dimension(150, 20));
		conectionStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		conectionStatus.setText("Result:");
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textArea.setMaximumSize(new Dimension(150, 60));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton startConection = new JButton("Start server");
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		startConection.setName("start");
		startConection.addActionListener(this);
		JButton stopConection = new JButton("Stop server");
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setName("stop");
		stopConection.addActionListener(this);
		panel.add(ipLabel);
		panel.add(ipAdress);
		panel.add(portLabel);
		panel.add(port);
		panel.add(conectionStatus);
		panel.add(startConection);
		panel.add(stopConection);
		panel.add(textArea);
		// --------------------------------------
		setSize(new Dimension(200, 250));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// --------------------------------------
	}

	/**
	 * When UI Button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (((JButton) ae.getSource()).getName().equals("start")) {
			if (messageReverser == null) {
				messageReverser = new MessageReverser(ipAdress.getText(),
						Integer.parseInt(port.getText()), this);
				messageReverser.start();
			}
		}
		if (((JButton) ae.getSource()).getName().equals("stop")) {
			if (messageReverser != null) {
				messageReverser.closeServerSocket();
				messageReverser = null;
			}
		}
	}

	/**
	 * Start app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MessageReverserApp();
	}

	/**
	 * Display messages received from server.
	 */
	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		conectionStatus.setText("User conected..." + "\n"
				+ conectionStatus.getText());
	}

	/**
	 * Change conection status.
	 */
	@Override
	public void conectionStatusChange(boolean conected) {
		if (!conected) {
			conectionStatus.setText("Disconnected....");
		}

	}
}
