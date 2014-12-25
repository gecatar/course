package com.sirma.itt.evgeni.comunication;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComunicatorView extends JFrame implements ActionListener {

	protected JTextField ipAdress = new JTextField(15);
	protected JTextField port = new JTextField(4);
	protected JLabel conectionStatus = new JLabel();
	protected ComunicatorViewListener listener;

	public ComunicatorView(ComunicatorViewListener listener) {
		this.listener = listener;
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
		// --------------------------------------
		setSize(new Dimension(200, 250));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// --------------------------------------
	}

	/**
	 * Change connection status.
	 * 
	 * @param conected
	 */
	public void setConectionStatus(boolean conected) {
		if (conected) {
			conectionStatus.setText("Conected...");
		} else {
			conectionStatus.setText("Not conected...");
		}
	}

	/**
	 * When UI Button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getName().equals("start")) {
			listener.startConection(ipAdress.getText(),
					Integer.parseInt(port.getText()));
		}
		if (((JButton) e.getSource()).getName().equals("stop")) {
			listener.stopConection();
		}
	}
}
