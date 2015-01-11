package com.sirma.itt.evgeni.comunication;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final Dimension WINDOW_DIMENSION = new Dimension(400, 500);
	protected UILIstener listener;

	public Window() {
		setSize(WINDOW_DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setListener(UILIstener listener) {
		this.listener = listener;
	}
}
