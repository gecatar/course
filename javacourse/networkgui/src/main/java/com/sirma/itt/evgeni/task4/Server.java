package com.sirma.itt.evgeni.task4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.sirma.itt.evgeni.task3.User;

/**
 * Send information about clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Server extends Thread {

	private ServerSocket serverSocket;
	private final ArrayList<User> users;
	private final String ip;
	private final int port;
	private int count;

	public Server(String ip, int port) {
		users = new ArrayList<User>();
		this.ip = ip;
		this.port = port;
		count = 1;
	}

	/**
	 * Send number of currently connected users.
	 * 
	 * @param user
	 * @throws IOException
	 */
	public void sendCount(User user) throws IOException {
		user.outputStream.writeObject(String.valueOf(count));
	}

	/**
	 * Notify all users.
	 * 
	 * @throws IOException
	 */
	public void notifyAllUsers() throws IOException {
		for (User user : users) {
			user.outputStream.writeObject("User" + count + "Entered");
		}
	}

	/**
	 * Close all sockets.
	 */
	public void stopServer() {
		for (User user : users) {
			closeSocket(user.socket);
		}
		users.clear();
		closeSocket(serverSocket);
	}

	/**
	 * Close socket.
	 * 
	 * @param autoCloseable
	 */
	public void closeSocket(AutoCloseable autoCloseable) {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Starting point for receiving connections.
	 */
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				ObjectOutputStream outputStream = new ObjectOutputStream(
						socket.getOutputStream());
				User temp = new User(socket, outputStream);
				sendCount(temp);
				notifyAllUsers();
				users.add(temp);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
