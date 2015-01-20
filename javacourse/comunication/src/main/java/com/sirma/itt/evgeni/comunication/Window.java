package com.sirma.itt.evgeni.comunication;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Contain all UI components.
 * 
 * @author GecaTM
 *
 */
public abstract class Window extends JFrame implements ComunicatorListener {

	private static final Dimension WINDOW_DIMENSION = new Dimension(400, 500);

	public Window() {
		setSize(WINDOW_DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public abstract String getName();

	public abstract String getIPField();

	public abstract int getPort();
}
