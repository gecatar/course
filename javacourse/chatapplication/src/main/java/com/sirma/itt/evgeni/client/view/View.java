package com.sirma.itt.evgeni.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class View extends JFrame {

	public View(StaffPane staffPane) {
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(staffPane);
		setVisible(true);
	}

	public void setConectionStatus(boolean conected) {
		if (conected) {
			setTitle("conected....");
		} else {
			setTitle("not conected....");
		}
	}
}
