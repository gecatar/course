package com.sirma.itt.evgeni.comunication;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {

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

}
