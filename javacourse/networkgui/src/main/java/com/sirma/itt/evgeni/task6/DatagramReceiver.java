package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Receive data gram packages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DatagramReceiver extends Thread {

	private String ip;
	private int port;
	private byte[] data;

	/**
	 * Read data gram packages while socket is open.
	 */
	@Override
	public void run() {
		try (MulticastSocket multicastSocket = new MulticastSocket(port)) {
			multicastSocket.joinGroup(InetAddress.getByName(ip));
			while (true) {
				DatagramPacket packet = new DatagramPacket(data, data.length);
				multicastSocket.receive(packet);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
