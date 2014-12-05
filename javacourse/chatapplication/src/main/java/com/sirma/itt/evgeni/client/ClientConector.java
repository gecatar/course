package com.sirma.itt.evgeni.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;

public class ClientConector extends Conector {

	public ClientConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(ipAdress, port);
			setAutoclosable(socket);
			ObjectOutputStream ost = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream ist = new ObjectInputStream(
					socket.getInputStream());
			comunicator.addUserSession(new DataTransferator(comunicator,
					socket, ost, ist));
		} catch (UnknownHostException e) {
			comunicator.stopConection();
		} catch (IOException e) {
			comunicator.stopConection();
		}
	}

	@Override
	public void setAutoclosable(AutoCloseable autoClosable) {
		this.autoclosableSocket = autoClosable;

	}
}
