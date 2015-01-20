package com.sirma.itt.evgeni.client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

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
		setLayout(new GridBagLayout());
		conectionStatus.setText(bundle.getString("user_disconected_message"));
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
		JLabel conectionStatusLabel = new JLabel(
				bundle.getString("conection_status_name"));
		JLabel ipLabel = new JLabel(bundle.getString("ip_label_name"));
		JLabel portLabel = new JLabel(bundle.getString("port_label_name"));
		JLabel nicknameLabel = new JLabel(
				bundle.getString("nickname_label_name"));
		nickname.setText("User");
		// -----------------------------------------------
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(conectionStatusLabel, gridBagConstraints);
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(conectionStatus, gridBagConstraints);
		gridBagConstraints.gridx--;
		gridBagConstraints.gridy++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(ipLabel, gridBagConstraints);
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ipAdress, gridBagConstraints);
		gridBagConstraints.gridx--;
		gridBagConstraints.gridy++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(portLabel, gridBagConstraints);
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(port, gridBagConstraints);
		gridBagConstraints.gridx--;
		gridBagConstraints.gridy++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(nicknameLabel, gridBagConstraints);
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(nickname, gridBagConstraints);
		gridBagConstraints.gridx--;
		gridBagConstraints.gridy++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(startConection, gridBagConstraints);
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(stopConection, gridBagConstraints);
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
