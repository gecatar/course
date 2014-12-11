package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

/**
 * Send data whit multicast socket.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DatagramTransmiter {

	private MulticastSocket multicastSocked;
	private final String ip;
	private final int port;

	public DatagramTransmiter(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	/**
	 * Open multicast socket.
	 */
	public boolean conect() {
		try {
			multicastSocked = new MulticastSocket(port);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Send data gram packages.
	 * 
	 * @return
	 */
	public boolean sendPacked(DatagramPacket datagramPacket) {
		try {
			multicastSocked.send(datagramPacket);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
