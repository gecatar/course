package com.sirma.itt.evgeni.task3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ServerConector extends Thread {

	private final DateFormat dateFormat;
	private ServerSocket serverSocket;
	private final String ip;
	private final int port;

	public ServerConector(String ip, int port) {
		this.ip = ip;
		this.port = port;
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * Create message.
	 * 
	 * @return
	 */
	public String createMessage() {
		return "Hello!!!<" + dateFormat.format(System.currentTimeMillis())
				+ ">";
	}

	public void closeSocket() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				System.out.println("Waiting for user....");
				new ObjectOutputStream(serverSocket.accept().getOutputStream())
						.writeObject(createMessage());
				System.out.println("Message send to client");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
