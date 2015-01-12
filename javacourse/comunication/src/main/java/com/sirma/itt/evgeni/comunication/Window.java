package com.sirma.itt.evgeni.comunication;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class Window extends JFrame {

	private static final Dimension WINDOW_DIMENSION = new Dimension(400, 500);
	protected UILIstener listener;

	public Window() {
		setSize(WINDOW_DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public abstract String getName();

	public abstract String getIPField();

	public abstract int getPort();

	public String getMessageText(String name) {
		return null;
	}

	public void displayMessage(String name, String text) {

	}

	public void setListener(UILIstener listener) {
		this.listener = listener;
	}

	public void setConectionStatus(MesageCommand status) {

	}
}
