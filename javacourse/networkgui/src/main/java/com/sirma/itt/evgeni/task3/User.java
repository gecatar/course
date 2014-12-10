package com.sirma.itt.evgeni.task3;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class User {

	public Socket socket;
	public ObjectOutputStream outputStream;

	public User(Socket socket, ObjectOutputStream outputStream) {
		this.socket = socket;
		this.outputStream = outputStream;
	}
}
