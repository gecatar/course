package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

/**
 * Transfer messages between two DataTranferators.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DataTransferator extends Thread {

	private final Comunicator comunicator;
	private final Socket socket;
	private final ObjectOutputStream ost;
	private final ObjectInputStream ist;

	public DataTransferator(Comunicator comunicator, Socket socket,
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
			comunicator.closeUserSession(this);
			ComunicatorLogger.getlogger().log(Level.INFO,
					"User lost conection.", e);
		}
	}

	/**
	 * Read messages from input stream.
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
			ComunicatorLogger.getlogger().log(Level.INFO,
					"Error when reading.", e);
		} finally {
			comunicator.closeUserSession(this);
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
			ComunicatorLogger.getlogger().log(Level.INFO,
					"Closing socket error.", e);
		}
	}
}