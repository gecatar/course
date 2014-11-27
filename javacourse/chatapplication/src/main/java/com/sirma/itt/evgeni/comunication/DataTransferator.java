package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DataTransferator extends Thread {

	Comunicator comunicator;
	Socket socket;
	ObjectOutputStream ost;
	ObjectInputStream ist;

	public DataTransferator(Comunicator comunicator, Socket socket,
			ObjectOutputStream ost, ObjectInputStream ist) {
		this.comunicator = comunicator;
		this.socket = socket;
		this.ost = ost;
		this.ist = ist;
	}

	public void sendData(Mesage mesage) {
		try {
			ost.writeObject(mesage);
			ost.flush();
		} catch (IOException e) {
			comunicator.closeUserSession(this);
		}
	}

	public void run() {
		try {
			while (true) {
				Mesage mesage = (Mesage) ist.readObject();
				comunicator.processMesage(mesage, this);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			comunicator.closeUserSession(this);
		}
	}

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