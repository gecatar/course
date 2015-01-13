package com.sirma.itt.evgeni.task6;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Contain UI components.
 * 
 * @author GecaTM
 *
 */
public class KeyView extends JFrame {

	protected JPanel panel = new JPanel();
	protected JTextField ipAdress = new JTextField(15);
	protected JTextField port = new JTextField(4);
	protected JTextField datagramSize = new JTextField(4);
	protected JLabel conectionStatus = new JLabel();
	protected JTextArea textArea = new JTextArea();
	protected ActionListener listener;

	public KeyView(ActionListener listener) {
		this.listener = listener;
		add(panel);
		JLabel ipLabel = new JLabel("IP");
		ipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setText("228.5.6.7");
		ipAdress.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setMaximumSize(new Dimension(150, 20));
		JLabel portLabel = new JLabel("Port");
		portLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setText("7005");
		port.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setMaximumSize(new Dimension(150, 20));
		JLabel datagramSizeLabel = new JLabel("Key size");
		datagramSizeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		datagramSize.setText("8");
		datagramSize.setAlignmentX(Component.CENTER_ALIGNMENT);
		datagramSize.setMaximumSize(new Dimension(150, 20));
		conectionStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		conectionStatus.setText("Result:");
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton startConection = new JButton("Start receiving");
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		startConection.setName("start");
		startConection.addActionListener(listener);
		JButton stopConection = new JButton("Stop receiving");
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setName("stop");
		stopConection.addActionListener(listener);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setMaximumSize(new Dimension(300, 400));
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		scrollPane.setMaximumSize(new Dimension(150, 200));
		panel.add(ipLabel);
		panel.add(ipAdress);
		panel.add(portLabel);
		panel.add(port);
		panel.add(datagramSizeLabel);
		panel.add(datagramSize);
		panel.add(conectionStatus);
		panel.add(startConection);
		panel.add(stopConection);
		panel.add(scrollPane);
		// --------------------------------------
		setSize(new Dimension(300, 450));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// --------------------------------------
	}

	/**
	 * Display key.
	 * 
	 * @param key
	 */
	public void displayKey(String key) {
		textArea.setText(textArea.getText() + "\n" + key);
	}

}
