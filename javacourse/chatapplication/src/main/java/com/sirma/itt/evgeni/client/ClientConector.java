package com.sirma.itt.evgeni.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;

/**
 * Create connection between client and server.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ClientConector extends Conector {

	private static final Logger LOGGER = Logger.getLogger(ClientConector.class
			.getName());

	public ClientConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
	}

	/**
	 * Starting point for creating connection.
	 */
	@Override
	public void run() {
		try {
			LOGGER.log(Level.SEVERE, "test");
			Socket socket = new Socket(ipAdress, port);
			setAutoclosable(socket);
			ObjectOutputStream ost = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream ist = new ObjectInputStream(
					socket.getInputStream());
			comunicator.addUserSession(new DataTransferator(comunicator,
					socket, ost, ist));
		} catch (IOException e) {
			comunicator.closeConectorSession();
			LOGGER.log(Level.SEVERE, "Error when conecting.", e);
		}
	}

	/**
	 * Set resource that will be closed when connector is closed.
	 */
	@Override
	public void setAutoclosable(AutoCloseable autoClosable) {
		this.autoclosableSocket = autoClosable;

	}
}
