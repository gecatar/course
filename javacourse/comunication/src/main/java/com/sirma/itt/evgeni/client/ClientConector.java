package com.sirma.itt.evgeni.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class ClientConector extends Conector {

	private static final Logger LOGGER = Logger.getLogger(ClientConector.class
			.getName());
	private Socket socket;

	public ClientConector(Comunicator comunicator) {
		super(comunicator);
	}

	@Override
	protected void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			comunicator.openSession(new DataTransferer(comunicator, socket,
					new ObjectOutputStream(socket.getOutputStream()),
					new ObjectInputStream(socket.getInputStream())));
		} catch (IOException e) {
			disconect();
			LOGGER.log(Level.ERROR, "Error when conecting.", e);
		}
	}

	@Override
	protected synchronized void disconect() {
		super.disconect();
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				LOGGER.log(Level.ERROR, "Error when closing socket.", e);
			}
			socket = null;
		}
	}
}
