package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientConector extends Conector {

	private static final Logger LOGGER = Logger.getLogger(ClientConector.class
			.getName());
	private Socket socket;

	public ClientConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
	}

	@Override
	public void conect() {
		try {
			socket = new Socket(ipAdress, port);
			ObjectOutputStream ost = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream ist = new ObjectInputStream(
					socket.getInputStream());
			comunicator.addUserSession(new DataTransferer(comunicator, socket,
					ost, ist));
		} catch (IOException e) {
			LOGGER.log(Level.INFO, "Conection error", e);
			comunicator.closeConector();
		}
	}

	@Override
	public void closeConector() {
		if (socket != null) {
			try {
				socket.close();
				socket = null;
			} catch (IOException e) {
				LOGGER.log(Level.INFO, "Conection error", e);
			}
		}
	}

}
