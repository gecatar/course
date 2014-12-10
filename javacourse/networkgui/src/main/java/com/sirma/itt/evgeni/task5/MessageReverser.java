package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.net.ServerSocket;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Server;

public class MessageReverser extends Server {

	public MessageReverser(String ipAdress, int port,
			ComunicatorListener listener) {
		super(ipAdress, port, listener);
	}

	public void acceptConections(String ip, int port) {
		try {
			while (true) {
				serverSocket = new ServerSocket(port);
				new MessageTransferator(serverSocket.accept()).start();
				listener.userConected();
			}
		} catch (IOException e) {
			closeServerSocket();
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
