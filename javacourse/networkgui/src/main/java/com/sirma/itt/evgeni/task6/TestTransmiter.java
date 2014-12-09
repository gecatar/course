package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TestTransmiter {

	private MulticastSocket multicastSocked;
	private String ip;
	private int port;

	public TestTransmiter(String ip, int port) {

	}

	public void conect() {
		try {
			multicastSocked = new MulticastSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean sendData() {
		try {
			byte[] data = { 't', 'e', 's', 't' };
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
