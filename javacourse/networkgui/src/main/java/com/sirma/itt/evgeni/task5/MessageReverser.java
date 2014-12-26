package com.sirma.itt.evgeni.task5;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Server;

/**
 * Create connection whit users.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class MessageReverser extends Server {

	private final ArrayList<MessageTransferator> messageTransferators;

	public MessageReverser(String ipAdress, int port,
			ComunicatorListener listener) {
		super(ipAdress, port, listener);
		messageTransferators = new ArrayList<MessageTransferator>();
	}

	/**
	 * Start connections.
	 */
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				MessageTransferator temp = new MessageTransferator(
						serverSocket.accept());
				messageTransferators.add(temp);
				temp.start();
			}
		} catch (IOException e) {
			closeServerSocket();
			listener.conectionStatusChange(false);
			e.printStackTrace();
		}
	}

	/**
	 * Close server socket. And created connections.
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
		if (messageTransferators != null) {
			for (MessageTransferator temp : messageTransferators) {
				temp.closeSocket();
			}
			messageTransferators.clear();
		}
	}

}
