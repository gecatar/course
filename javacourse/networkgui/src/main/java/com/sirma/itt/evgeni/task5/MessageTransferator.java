package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Send and receive messages from client.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class MessageTransferator extends Thread {

	Socket socket;

	public MessageTransferator(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Read messages from client.
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public String readMessage(ObjectInputStream inputStream)
			throws IOException, ClassNotFoundException {
		return (String) inputStream.readObject();
	}

	/**
	 * Send messages to client.
	 * 
	 * @param message
	 * @param outputStream
	 * @throws IOException
	 */
	public void sendMessage(String message, ObjectOutputStream outputStream)
			throws IOException {
		outputStream.writeObject(message);
	}

	/**
	 * Reverse message.
	 * 
	 * @param message
	 * @return
	 */
	public String reverseMessage(String message) {
		return new StringBuilder(message).reverse().toString();
	}

	/**
	 * Start receiving messages.
	 */
	@Override
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

	/**
	 * Close socket.
	 */
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
