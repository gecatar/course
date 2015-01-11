package com.sirma.itt.evgeni.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class ServerConector extends Conector {

	private static final Logger LOGGER = Logger.getLogger(ServerConector.class
			.getName());
	ServerSocket serverSocket;

	public ServerConector(Comunicator comunicator) {
		super(comunicator);
	}

	@Override
	protected void connect(String ip, int port) {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				comunicator.openSession(new DataTransferer(comunicator, socket,
						new ObjectOutputStream(socket.getOutputStream()),
						new ObjectInputStream(socket.getInputStream())));
			}
		} catch (IOException e) {
			disconect();
			LOGGER.log(Level.ERROR, "Error when waiting users.", e);
		} finally {
			disconect();
		}
	}

	@Override
	protected synchronized void disconect() {
		super.disconect();
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				LOGGER.log(Level.ERROR, "Error when closing socket.", e);
			}
		}
	}

}
