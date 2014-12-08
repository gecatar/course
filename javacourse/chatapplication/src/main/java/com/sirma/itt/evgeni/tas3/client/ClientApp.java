package com.sirma.itt.evgeni.tas3.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sirma.itt.evgeni.comunication.Window;

public class ClientApp extends Window implements ActionListener {

	static JButton closingButton = new JButton("Close operation");

	public ClientApp(Component componnent) {

		super(closingButton);
		closingButton.addActionListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
	}

	// Runner--------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientApp(closingButton);
	}
	// --------------------------------------

}
