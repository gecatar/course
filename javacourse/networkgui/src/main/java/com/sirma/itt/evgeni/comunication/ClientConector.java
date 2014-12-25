package com.sirma.itt.evgeni.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConector extends Conector {

	public ClientConector(Comunicator comunicator, String ipAdress, int port) {
		super(comunicator, ipAdress, port);
	}

	@Override
	public void conect() {
		try {
			Socket socket = new Socket(ipAdress, port);
			ObjectOutputStream ost = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream ist = new ObjectInputStream(
					socket.getInputStream());
			comunicator.addUserSession(new DataTransferer(comunicator, socket,
					ost, ist));
		} catch (IOException e) {
			e.printStackTrace();
			comunicator.closeConector();
		}
	}

	@Override
	public void closeConector() {
		// TODO Auto-generated method stub

	}

}
