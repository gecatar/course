package com.sirma.itt.evgeni.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComponentID;

/**
 * Manage user connection request.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConectionPanel extends JPanel {

	private JTextField ipAdress = new JTextField(15);
	private JTextField port = new JTextField(4);
	private JTextField nickname = new JTextField(10);
	private JLabel conectionStatus = new JLabel();

	/**
	 * Create connection user interface.
	 */
	public ConectionPanel(ActionListener listener, ResourceBundle bundle) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		conectionStatus.setText("Conection Status:Not Connected");
		ipAdress.setText("localhost");
		port.setText("1300");
		nickname.setText("User");
		JButton startConection = new JButton(
				bundle.getString("conect_button_name"));
		startConection.setName(ComponentID.CONECT_BUTTON_ID);
		startConection.addActionListener(listener);
		JButton stopConection = new JButton(
				bundle.getString("disconect_button_name"));
		stopConection.setName(ComponentID.DISCONECT_BUTTON_ID);
		stopConection.addActionListener(listener);
		conectionStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel ipLabel = new JLabel(bundle.getString("ip_label_name"));
		ipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setMaximumSize(new Dimension(150, 20));
		ipAdress.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel portLabel = new JLabel(bundle.getString("port_label_name"));
		portLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setMaximumSize(new Dimension(80, 20));
		port.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel nicknameLabel = new JLabel(
				bundle.getString("nickname_label_name"));
		nicknameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nickname.setText("User");
		nickname.setMaximumSize(new Dimension(150, 20));
		nickname.setAlignmentX(CENTER_ALIGNMENT);
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		// -----------------------------------------------
		add(conectionStatus);
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

	@Override
	public String getName() {
		return nickname.getText();
	}

	public String getIP() {
		return ipAdress.getText();
	}

	public int getPort() {
		return Integer.parseInt(port.getText());
	}

	/**
	 * Display connection status.
	 */
	public void setConectionStatus(String conectionCondition) {
		conectionStatus.setText(conectionCondition);
	}
}
