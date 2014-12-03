package com.sirma.itt.evgeni.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class View extends JFrame {

	public View(ConverationPane conversationPane) {

		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(conversationPane);
		setVisible(true);
	}

}
