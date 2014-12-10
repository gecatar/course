package com.sirma.itt.evgeni.task4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.sirma.itt.evgeni.task3.User;

public class Server extends Thread {

	private ServerSocket serverSocket;
	private final ArrayList<User> users;
	private final String ip;
	private final int port;
	private final int count;

	public Server(String ip, int port) {
		users = new ArrayList<User>();
		this.ip = ip;
		this.port = port;
		count = 0;
	}

	public void sendCount(User user) throws IOException {
		user.outputStream.writeObject(String.valueOf(count));
	}

	public void notifyAllUsers() throws IOException {
		for (User user : users) {
			user.outputStream.writeObject("User" + count + "Entered");
		}
	}

	public void stopServer() {
		for (User user : users) {
			closeSocket(user.socket);
		}
		users.clear();
	}

	public void closeSocket(AutoCloseable autoCloseable) {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client conected...");
				ObjectOutputStream outputStream = new ObjectOutputStream(
						socket.getOutputStream());
				User temp = new User(socket, outputStream);
				sendCount(temp);
				notifyAllUsers();
				users.add(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
