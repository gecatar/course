package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Transfer messages between two DataTranferators.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DataTransferer extends Thread {

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
		}
	}

	/**
	 * Entry point for receiving messages.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Mesage mesage = (Mesage) ist.readObject();
				comunicator.processMesage(mesage, this);
			}
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			comunicator.closeSession(this);
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
			e.printStackTrace();
		}
	}
}