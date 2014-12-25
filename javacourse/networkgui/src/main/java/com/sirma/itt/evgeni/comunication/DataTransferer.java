package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataTransferer extends Thread {

	private static final Logger LOGGER = Logger.getLogger(DataTransferer.class
			.getName());
	private final Comunicator comunicator;
	private final Socket socket;
	private final ObjectOutputStream ost;
	private final ObjectInputStream ist;

	public DataTransferer(Comunicator comunicator, Socket socket,
			ObjectOutputStream ost, ObjectInputStream ist) {
		this.comunicator = comunicator;
		this.socket = socket;
		this.ost = ost;
		this.ist = ist;
	}

	/**
	 * Send message.
	 * 
	 * @param mesage
	 */
	public void sendData(String mesage) {
		try {
			ost.writeObject(mesage);
			ost.flush();
		} catch (IOException e) {
			comunicator.closeUsersession(this);
			LOGGER.log(Level.INFO, "Conection lost", e);
		}
	}

	/**
	 * Read messages from input stream.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private String readMessage() throws ClassNotFoundException, IOException {
		return ist.readObject().toString();
	}

	/**
	 * Entry point for receiving messages.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				comunicator.receiveMessage(readMessage(), this);
			}
		} catch (IOException | ClassNotFoundException e) {
			LOGGER.log(Level.INFO, "Conection lost", e);
		} finally {
			comunicator.closeUsersession(this);
		}
	}

	/**
	 * Close socket.
	 */
	public void closeSocket() {
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			LOGGER.log(Level.INFO, "Closing recources.", e);
		}
	}
}