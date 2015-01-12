package com.sirma.itt.evgeni.comunication;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public abstract class Window extends JFrame implements ComunicatorListener,
		ActionListener, MouseListener {

	private static final Dimension WINDOW_DIMENSION = new Dimension(400, 500);

	public Window(ComunicatorApp listener) {
		setSize(WINDOW_DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public abstract String getName();

	public abstract String getIPField();

	public abstract int getPort();

	public abstract String getMessageText(String name);
}
