package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {

	String ipAdress;
	int port;

	public Client(String ipAdress, int port) {
		this.ipAdress = ipAdress;
		this.port = port;
	}

	public Socket connect(String ipAdress, int port) throws IOException {
		return new Socket(ipAdress, port);
	}

	public void sendMessage(String message, ObjectOutputStream outputStream)
			throws IOException {
		outputStream.writeObject(message);
	}

	public String readMessage(ObjectInputStream inputStream)
			throws ClassNotFoundException, IOException {
		return (String) inputStream.readObject();
	}

	@Override
	public void run() {
		try {
			Socket socket = connect(ipAdress, port);
			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());
			ObjectOutputStream outputStream = new ObjectOutputStream(
					socket.getOutputStream());
			while (true) {
				sendMessage("", outputStream);
				readMessage(inputStream);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
