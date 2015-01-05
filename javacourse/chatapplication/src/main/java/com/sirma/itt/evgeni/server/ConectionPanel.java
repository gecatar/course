package com.sirma.itt.evgeni.server;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.UILIstener;

/**
 * Manage user connection request.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConectionPanel extends JPanel implements ActionListener {

	private UILIstener uiListener;
	private JTextField ipAdress = new JTextField(15);
	private JTextField port = new JTextField(4);
	private JTextArea textArea = new JTextArea();

	/**
	 * Create connection user interface.
	 * 
	 * @param userListener
	 */
	public ConectionPanel(UILIstener uiListener) {
		this.uiListener = uiListener;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ipAdress.setText("localhost");
		port.setText("1300");
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
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setMaximumSize(new Dimension(200, 250));
		// -----------------------------------------------
		add(ipAdress);
		add(port);
		add(startConection);
		add(stopConection);
		add(ipLabel);
		add(ipAdress);
		add(portLabel);
		add(port);
		add(startConection);
		add(stopConection);
		add(scrollPane);
	}

	/**
	 * Detect when user request connection or disconnection.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals("StartConection")) {
				uiListener.startConection("server", ipAdress.getText(),
						port.getText());
			}
			if (((JButton) e.getSource()).getName().equals("StopConection")) {
				uiListener.stopConection();
			}
		}
	}

}
