package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Send data whit multicast socket.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DatagramTransmiter {

	private MulticastSocket multicastSocked;
	private final InetAddress ip;
	private final int port;

	public DatagramTransmiter(String ip, int port) throws UnknownHostException {
		this.ip = InetAddress.getByName(ip);
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
	public boolean sendPacked(byte[] data) {
		try {
			multicastSocked
					.send(new DatagramPacket(data, data.length, ip, port));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
