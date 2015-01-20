package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Transfer messages between two DataTranferators.
 * 
 * @author Evgeni Stefanov
 * 
 */
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
	 */
	public void sendData(Mesage mesage) {
		try {
			ost.writeObject(mesage);
			ost.flush();
		} catch (IOException e) {
			comunicator.closeSession(this);
			LOGGER.log(Level.ERROR, "Error when sending message", e);
		}
	}

	/**
	 * Read messages from input stream.dfdr.
	 */
	public Mesage readMessage() throws ClassNotFoundException, IOException {
		return (Mesage) ist.readObject();
	}

	/**
	 * Entry point for receiving messages.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				comunicator.processMesage(readMessage(), this);
			}
		} catch (IOException | ClassNotFoundException e) {
			LOGGER.log(Level.ERROR, "Error while reading message.", e);
		} finally {
			comunicator.closeSession(this);
		}
	}

	/**
	 * Close socket.
	 */
	public synchronized void closeSocket() {
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, "Error when closing socket.", e);
		}
	}
}