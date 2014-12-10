package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageTransferator extends Thread {

	Socket socket;

	public MessageTransferator(Socket socket) {
		this.socket = socket;
	}

	public String readMessage(ObjectInputStream inputStream)
			throws IOException, ClassNotFoundException {
		return (String) inputStream.readObject();
	}

	public void sendMessage(String message, ObjectOutputStream outputStream)
			throws IOException {
		outputStream.writeObject(message);
		closeSocket();
	}

	public String reverseMessage(String message) {
		return new StringBuilder(message).reverse().toString();
	}

	public void run() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());
			while (true) {
				sendMessage(reverseMessage(readMessage(inputStream)),
						outputStream);
			}
		} catch (IOException | ClassNotFoundException e) {
			closeSocket();
			e.printStackTrace();
		}
	}

	public synchronized void closeSocket() {
		if (socket != null) {
			try {
				socket.close();
				socket = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
