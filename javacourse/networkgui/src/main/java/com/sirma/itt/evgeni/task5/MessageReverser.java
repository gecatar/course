package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.net.ServerSocket;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Server;

/**
 * Create connection whit users.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class MessageReverser extends Server {

	public MessageReverser(String ipAdress, int port,
			ComunicatorListener listener) {
		super(ipAdress, port, listener);
	}

	/**
	 * Start connections.
	 */
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				new MessageTransferator(serverSocket.accept()).start();
				listener.userConected();
			}
		} catch (IOException e) {
			closeServerSocket();
			listener.conectionStatusChange(false);
			e.printStackTrace();
		}
	}

	/**
	 * Close server socket.
	 */
	public synchronized void closeServerSocket() {
		if (serverSocket != null) {
			try {
				serverSocket.close();
				serverSocket = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
