package com.sirma.itt.evgeni.task3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

	ObjectInputStream ist;
	Socket socket;

	public void startConection(String ip, int port) throws IOException {
		socket = new Socket(ip, port);
		ist = new ObjectInputStream(socket.getInputStream());
		System.out.println("Conected...");
	}

	public String getMessage() throws ClassNotFoundException, IOException {
		System.out.println("Getting message!!!");
		return (String) ist.readObject();
	}

	public void closeSocket() throws IOException {
		System.out.println("Closing socket!!!!");
		socket.close();
	}
}
