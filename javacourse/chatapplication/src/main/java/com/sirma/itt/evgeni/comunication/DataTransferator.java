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
	boolean stop = false;

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
			closeSocket();
		}
	}

	public void run() {
		try {
			while (stop != true) {
				Mesage mesage = (Mesage) ist.readObject();
				comunicator.processMesage(mesage, this);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			closeSocket();
		}
	}

	public synchronized void closeSocket() {
		try {
			stop = true;
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			comunicator.removeDataTransferator(this);
			socket = null;
		}
	}
}