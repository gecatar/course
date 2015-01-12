package com.sirma.itt.evgeni.comunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComunicatorApp implements ComunicatorListener, ActionListener,
		MouseListener {

	private Comunicator comunicator;
	private Window window;

	public ComunicatorApp(Comunicator comunicator, Window window) {
		this.comunicator = comunicator;
		this.window = window;
		comunicator.setListener(this);
	}

	@Override
	public void setConectionStatus(MesageCommand status) {
	}

	@Override
	public void showMesage(String name, String text) {

	}

	@Override
	public void addUser(String name) {

	}

	@Override
	public void removeUser(String name) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
