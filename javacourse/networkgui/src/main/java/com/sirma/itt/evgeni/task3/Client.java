package com.sirma.itt.evgeni.task3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	ObjectOutputStream ost;
	ObjectInputStream ist;
	Socket socket;

	public void startConection(String ip, int port) throws IOException {
		socket = new Socket(ip, port);
		ost = new ObjectOutputStream(socket.getOutputStream());
		ist = new ObjectInputStream(socket.getInputStream());
	}

	public String getMessage() throws ClassNotFoundException, IOException {

		return (String) ist.readObject();
	}

	public void closeSocket() throws IOException {
		socket.close();
	}
}
