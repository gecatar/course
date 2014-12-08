package com.sirma.itt.evgeni.comunication;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class View extends JFrame {

	JTabbedPane tabbedView = new JTabbedPane();

	public View() {
		add(tabbedView);
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
