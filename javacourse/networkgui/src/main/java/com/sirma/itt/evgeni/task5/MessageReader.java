package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.sirma.itt.evgeni.comunication.Client;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.interfaces.UserInputReader;
import com.sirma.itt.evgeni.util.InputReader;

/**
 * Send and receive messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class MessageReader extends Client {

	public MessageReader(String ipAdress, int port, ComunicatorListener listener) {
		super(ipAdress, port, listener);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Start conection.
	 * 
	 * @param ipAdress
	 * @param port
	 * @return
	 * @throws IOException
	 */
	public Socket connect(String ipAdress, int port) throws IOException {
		return new Socket(ipAdress, port);
	}

	/**
	 * Send messages to server.
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
	 * Read incoming messages.
	 * 
	 * @param inputStream
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public String readMessage(ObjectInputStream inputStream)
			throws ClassNotFoundException, IOException {
		return (String) inputStream.readObject();
	}

	/**
	 * Start sending and receiving messages.
	 */
	@Override
	public void run() {
		try {
			Socket socket = connect(ipAdress, port);
			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());
			ObjectOutputStream outputStream = new ObjectOutputStream(
					socket.getOutputStream());
			UserInputReader inputReader = new InputReader();
			while (true) {
				sendMessage(inputReader.readLine(), outputStream);
				readMessage(inputStream);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
