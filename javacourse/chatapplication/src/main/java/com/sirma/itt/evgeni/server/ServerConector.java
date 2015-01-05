package com.sirma.itt.evgeni.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;

public class ServerConector extends Conector {

	private static final Logger LOGGER = Logger.getLogger(ServerConector.class
			.getName());
	ServerSocket serverSocket;

	public ServerConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			setAutoclosable(serverSocket);
			while (true) {
				Socket socket = serverSocket.accept();
				LOGGER.log(Level.INFO, "New User connected");
				ObjectOutputStream ost = new ObjectOutputStream(
						socket.getOutputStream());
				ObjectInputStream ist = new ObjectInputStream(
						socket.getInputStream());
				comunicator.addUserSession(new DataTransferator(comunicator,
						socket, ost, ist));
			}
		} catch (IOException e) {
			LOGGER.log(Level.INFO, "Error when waiting users.", e);
		} finally {
			comunicator.closeConectorSession();
		}
	}

	@Override
	public void setAutoclosable(AutoCloseable autoClosable) {
		autoclosableSocket = autoClosable;

	}
}
