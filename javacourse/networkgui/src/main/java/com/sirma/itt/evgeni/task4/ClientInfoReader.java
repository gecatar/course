package com.sirma.itt.evgeni.task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sirma.itt.evgeni.comunication.Client;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;

/**
 * Read information about clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ClientInfoReader extends Client {

	public ClientInfoReader(String ipAdress, int port,
			ComunicatorListener listener) {
		super(ipAdress, port, listener);
	}

	/**
	 * Start listening for messages.
	 */
	@Override
	public void run() {
		try {
			createConection();
			while (true) {
				listener.displayMessage(inputStream.readObject().toString());
			}
		} catch (IOException | ClassNotFoundException e) {
			stopClient();
			listener.conectionStatusChange(false);
		}
	}

	/**
	 * Create connection.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void createConection() throws UnknownHostException, IOException {
		socket = new Socket(ipAdress, port);
		inputStream = new ObjectInputStream(socket.getInputStream());
		listener.conectionStatusChange(true);
	}
}
