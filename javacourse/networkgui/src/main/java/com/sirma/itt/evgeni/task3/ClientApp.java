package com.sirma.itt.evgeni.task3;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Show UI and get message send from server.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ClientApp extends JFrame implements ActionListener {

	Client client = new Client();
	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JLabel conectionStatus = new JLabel();

	public ClientApp() {
		setTitle("Client");
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
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton startConection = new JButton("Get message");
		startConection.setName("start");
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		startConection.addActionListener(this);
		panel.add(ipLabel);
		panel.add(ipAdress);
		panel.add(portLabel);
		panel.add(port);
		panel.add(conectionStatus);
		panel.add(startConection);
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
			try {
				client.startConection(ipAdress.getText(),
						Integer.parseInt(port.getText()));
				conectionStatus.setText(client.getMessage());
				client.closeSocket();
			} catch (IOException | ClassNotFoundException e) {
				conectionStatus.setText(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientApp();
	}
}
