package com.sirma.itt.evgeni.task6;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Contain UI components.
 * 
 * @author GecaTM
 *
 */
public class KeyTransmiterView extends JFrame {

	protected JPanel panel = new JPanel();
	protected JTextField ipAdress = new JTextField(15);
	protected JTextField ipAdressSecond = new JTextField(15);
	protected JTextField port = new JTextField(4);
	protected JTextField portSecond = new JTextField(4);
	protected ActionListener listener;

	public KeyTransmiterView(ActionListener listener) {
		this.listener = listener;
		add(panel);
		JLabel ipLabel = new JLabel("IP 8 bit channel");
		ipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setText("228.5.6.7");
		ipAdress.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setMaximumSize(new Dimension(150, 20));
		JLabel portLabel = new JLabel("Port");
		portLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setText("7005");
		port.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setMaximumSize(new Dimension(150, 20));
		JLabel ipLabelSecond = new JLabel("IP 32 bit channel");
		ipLabelSecond.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdressSecond.setText("228.5.6.8");
		ipAdressSecond.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdressSecond.setMaximumSize(new Dimension(150, 20));
		JLabel portLabelSecond = new JLabel("Port");
		portLabelSecond.setAlignmentX(Component.CENTER_ALIGNMENT);
		portSecond.setText("7005");
		portSecond.setAlignmentX(Component.CENTER_ALIGNMENT);
		portSecond.setMaximumSize(new Dimension(150, 20));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton sendSmallKey = new JButton("Send 8 bit key");
		sendSmallKey.setAlignmentX(Component.CENTER_ALIGNMENT);
		sendSmallKey.setName("8BIT");
		sendSmallKey.addActionListener(listener);
		JButton sendBigKey = new JButton("Send 32 bit key");
		sendBigKey.setAlignmentX(Component.CENTER_ALIGNMENT);
		sendBigKey.setName("32BIT");
		sendBigKey.addActionListener(listener);
		JButton startTransmiter = new JButton("Start transmiter");
		startTransmiter.setAlignmentX(Component.CENTER_ALIGNMENT);
		startTransmiter.setName("start");
		startTransmiter.addActionListener(listener);
		panel.add(ipLabel);
		panel.add(ipAdress);
		panel.add(portLabel);
		panel.add(port);
		panel.add(ipLabelSecond);
		panel.add(ipAdressSecond);
		panel.add(portLabelSecond);
		panel.add(portSecond);
		panel.add(sendSmallKey);
		panel.add(sendBigKey);
		panel.add(startTransmiter);
		// --------------------------------------
		setSize(new Dimension(300, 450));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// --------------------------------------
	}
}