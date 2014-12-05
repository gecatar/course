package com.sirma.itt.evgeni.client.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Manage user connection request.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConectionPanel extends JPanel implements ActionListener {

	UserActionListener userListener;

	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JTextField nickname = new JTextField(10);

	/**
	 * Create connection user interface.
	 * 
	 * @param userListener
	 */
	public ConectionPanel(UserActionListener userListener) {
		this.userListener = userListener;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ipAdress.setText("localhost");
		port.setText("1300");
		nickname.setText("User");
		JButton startConection = new JButton("Conect");
		startConection.setName("StartConection");
		startConection.addActionListener(this);
		JButton stopConection = new JButton("Disconect");
		stopConection.setName("StopConection");
		stopConection.addActionListener(this);
		JLabel ipLabel = new JLabel("IP Adress");
		ipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setMaximumSize(new Dimension(150, 20));
		ipAdress.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel portLabel = new JLabel("Port");
		portLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setMaximumSize(new Dimension(80, 20));
		port.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel nicknameLabel = new JLabel("Nickname");
		nicknameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nickname.setText("User");
		nickname.setMaximumSize(new Dimension(150, 20));
		nickname.setAlignmentX(CENTER_ALIGNMENT);
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		// -----------------------------------------------
		add(ipAdress);
		add(port);
		add(nickname);
		add(startConection);
		add(stopConection);
		add(ipLabel);
		add(ipAdress);
		add(portLabel);
		add(port);
		add(nicknameLabel);
		add(nickname);
		add(startConection);
		add(stopConection);
	}

	/**
	 * Detect when user request connection or disconnection.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals("StartConection")) {
				userListener.startConection(nickname.getText(),
						ipAdress.getText(), port.getText());
			}
			if (((JButton) e.getSource()).getName().equals("StopConection")) {
				userListener.stopConection();
			}
		}
	}

}
