package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerConector extends Conector {

	private static final Logger LOGGER = Logger.getLogger(ServerConector.class
			.getName());
	ServerSocket serverSocket;

	public ServerConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void conect() {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				ObjectOutputStream ost = new ObjectOutputStream(
						socket.getOutputStream());
				ObjectInputStream ist = new ObjectInputStream(
						socket.getInputStream());
				comunicator.addUserSession(new DataTransferer(comunicator,
						socket, ost, ist));
			}
		} catch (IOException e) {
			LOGGER.log(Level.INFO, "Connection error.", e);
		} finally {
			comunicator.closeConector();
		}
	}

	@Override
	public void closeConector() {
		if (serverSocket != null) {
			try {
				serverSocket.close();
				serverSocket = null;
			} catch (IOException e) {
				LOGGER.log(Level.INFO, "Cloosing error.", e);
			}
		}
	}

}
