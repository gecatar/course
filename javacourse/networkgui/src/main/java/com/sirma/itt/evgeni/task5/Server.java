package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Open connections and receive new clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Server extends Thread {

	ServerSocket serverSocket;
	ComunicatorListener comunicatorListener;

	public Server(ComunicatorListener comunicatorListener) {
		this.comunicatorListener = comunicatorListener;
	}

	/**
	 * Accept new clients.
	 * 
	 * @param ip
	 * @param port
	 */
	public void acceptConections(String ip, int port) {
		try {
			while (true) {
				serverSocket = new ServerSocket(port);
				new serverTransferator(serverSocket.accept()).start();
				comunicatorListener.userConected();
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
