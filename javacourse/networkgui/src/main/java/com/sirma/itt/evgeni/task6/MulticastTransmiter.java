package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Send data whit multicast socket.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class MulticastTransmiter {

	private MulticastSocket multicastSocked;
	private String ip;
	private int port;

	public MulticastTransmiter(String ip, int port) {

	}

	/**
	 * Open multicast socket.
	 */
	public void conect() {
		try {
			multicastSocked = new MulticastSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send data gram packages.
	 * 
	 * @return
	 */
	public boolean sendData(byte[] data) {
		try {
			DatagramPacket datagramPacket = new DatagramPacket(data,
					data.length, InetAddress.getByName(ip), port);
			multicastSocked.send(datagramPacket);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
