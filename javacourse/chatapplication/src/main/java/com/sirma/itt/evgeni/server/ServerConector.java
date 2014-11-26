package com.sirma.itt.evgeni.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;

public class ServerConector extends Conector {

	ServerSocket serverSocket;

	public ServerConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
	}

	public void run() {

		try {
			serverSocket = new ServerSocket(port);
			setAutoclosable(serverSocket);
			while (true) {
				Socket socket = serverSocket.accept();
				ObjectOutputStream ost = new ObjectOutputStream(
						socket.getOutputStream());
				ObjectInputStream ist = new ObjectInputStream(
						socket.getInputStream());
				comunicator.addDataTransferator(new DataTransferator(
						comunicator, socket, ost, ist));
			}
		} catch (IOException e) {
		} finally {
			stopConector();
		}

	}

	@Override
	public void setAutoclosable(AutoCloseable autoClosable) {
		autoclosableSocket = autoClosable;
		
	}
}
