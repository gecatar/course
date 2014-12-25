package com.sirma.itt.evgeni.comunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;

public class Server extends Thread implements ActionListener {

	protected ServerSocket serverSocket;
	protected String ipAdress;
	protected int port;
	protected ComunicatorListener listener;

	public Server(String ipAdress, int port, ComunicatorListener listener) {
		this.ipAdress = ipAdress;
		this.port = port;
		this.listener = listener;
	}

	public void closeResources(AutoCloseable autoCloseable) {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
