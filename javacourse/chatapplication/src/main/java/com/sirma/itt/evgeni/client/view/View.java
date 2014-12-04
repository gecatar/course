package com.sirma.itt.evgeni.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.sirma.itt.evgeni.comunication.Comunicator;

public class View extends JFrame implements UILIstener, ComunicatorListener {

	Comunicator client;
	StaffPane staffPane;

	public View(StaffPane staffPane) {

		client = new Client(this);
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.staffPane = staffPane;
		add(new StaffPane(this));
		setVisible(true);
	}

	// interface-----------------------------------------------------
	public void startConection(String nickname, String ip, String port) {
		// TODO Auto-generated method stub
		// client.startConection(ip, port);
	}

	public void stopConection() {
		// TODO Auto-generated method stub
		client.stopConection();
	}

	public void sendMessage(String name, String message) {
		// TODO Auto-generated method stub
		// client.sendMesage(mesage);
	}

	// comunicator-----------------------------------------
	public void setConectionStatus(boolean conected) {
		// TODO Auto-generated method stub

	}

	public void showMesage(String name, String message) {
		// TODO Auto-generated method stub
		staffPane.displayMessage(name, message);
	}

	public void addUser(String name) {
		// TODO Auto-generated method stub
		staffPane.addUser(name);
	}

	public void removeUser(String name) {
		// TODO Auto-generated method stub
		staffPane.removeUser(name);
	}

}
