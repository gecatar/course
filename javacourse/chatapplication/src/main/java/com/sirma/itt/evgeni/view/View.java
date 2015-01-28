package com.sirma.itt.evgeni.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class View extends JFrame {

	private final Dimension WINDOW_DIMENSION = new Dimension(400, 500);

	public View() {
		setSize(WINDOW_DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
