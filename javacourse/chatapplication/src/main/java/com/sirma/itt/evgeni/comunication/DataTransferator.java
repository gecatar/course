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
	 * 
	 * @param mesage
	 */
	public void sendData(Mesage mesage) {
		try {
			ost.writeObject(mesage);
			ost.flush();
		} catch (IOException e) {
			comunicator.closeUserSession(this);
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
			e.printStackTrace();
		}
	}
}