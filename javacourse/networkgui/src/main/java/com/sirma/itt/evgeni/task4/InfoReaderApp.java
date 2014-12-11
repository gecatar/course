package com.sirma.itt.evgeni.task4;

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
 * Read and display information about clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class InfoReaderApp extends JFrame implements ActionListener,
		ComunicatorListener {

	ClientInfoReader infoReader;
	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JLabel conectionStatus = new JLabel();
	JTextArea messageArea = new JTextArea();

	public InfoReaderApp() {
		setTitle("Information about clients...");
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
		messageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		messageArea.setMaximumSize(new Dimension(150, 100));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton startConection = new JButton("Conect");
		startConection.setName("start");
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		startConection.addActionListener(this);
		panel.add(ipLabel);
		panel.add(ipAdress);
		panel.add(portLabel);
		panel.add(port);
		panel.add(startConection);
		panel.add(conectionStatus);
		panel.add(messageArea);
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
			if (infoReader == null) {
				infoReader = new ClientInfoReader(ipAdress.getText(),
						Integer.parseInt(port.getText()), this);
				infoReader.start();
			}
		}
		if (((JButton) ae.getSource()).getName().equals("stop")) {
			if (infoReader != null) {
				infoReader.stopClient();
				infoReader = null;
			}
		}
	}

	/**
	 * Start app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new InfoReaderApp();
	}

	@Override
	public void userConected() {
	}

	/**
	 * Display message from server.
	 */
	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		messageArea.setText(message + "\n" + messageArea.getText());
	}

	/**
	 * When connection state change.
	 */
	@Override
	public void conectionStatusChange(boolean conected) {
		if (conected) {
			conectionStatus.setText("Conected...!!!");
		} else {
			conectionStatus.setText("Disconected...!!!");
		}

	}
}
