package com.sirma.itt.evgeni.comunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread implements ActionListener {

	protected String ipAdress;
	protected int port;
	protected Socket socket;
	protected ObjectOutputStream outputStream;
	protected ObjectInputStream inputStream;
	protected ComunicatorListener listener;

	public Client(String ipAdress, int port, ComunicatorListener listener) {
		this.ipAdress = ipAdress;
		this.port = port;
		this.listener = listener;
	}

	public void stopClient() {
		if (socket != null) {
			closeResources(socket);
			socket = null;
		}
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
