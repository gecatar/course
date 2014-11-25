package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TestReceiver extends Thread {

	public void run() {
		try (MulticastSocket multicastSocket = new MulticastSocket(7005)) {
			multicastSocket.joinGroup(InetAddress.getByName("228.5.6.7"));
			while (true) {
				byte[] buff = new byte[4];
				DatagramPacket packet = new DatagramPacket(buff, buff.length);
				multicastSocket.receive(packet);
				System.out.println("Data received....!@#@!#@!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
