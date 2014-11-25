package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class TestTransmiter {

	MulticastSocket multicastSocked;

	public void conect() {
		try {
			System.out.println("Initializing....");
			multicastSocked = new MulticastSocket(7005);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean sendData() {
		try {
			System.out.println("Try to send data...!!!21@!!@!@");
			byte[] data = { 't', 'e', 's', 't' };
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length,
					InetAddress.getByName("228.5.6.7"), 7005);
			multicastSocked.send(datagramPacket);
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
