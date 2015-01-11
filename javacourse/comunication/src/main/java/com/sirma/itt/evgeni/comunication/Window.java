package com.sirma.itt.evgeni.comunication;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

	protected UILIstener listener;

	public Window() {
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setListener(UILIstener listener) {
		this.listener = listener;
	}
}
