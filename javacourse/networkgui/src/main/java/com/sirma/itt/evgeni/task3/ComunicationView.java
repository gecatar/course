package com.sirma.itt.evgeni.task3;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComunicationView extends JFrame {

	public ComunicationView() {
		JPanel panel = new JPanel();
		JTextField ipAdress = new JTextField(15);
		JTextField port = new JTextField(4);
		JTextField name = new JTextField(10);
		JLabel conectionStatus = new JLabel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// --------------------------------------
		setSize(new Dimension(200, 250));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// --------------------------------------
	}
}
