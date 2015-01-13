package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class KeyReceiver extends Thread {

	private KeyView view;
	private String ip;
	private int port;
	private int dataGramSize;

	public KeyReceiver(KeyView view, String ip, int port, int dataGramSize) {
		this.view = view;
		this.ip = ip;
		this.port = port;
		this.dataGramSize = dataGramSize;
	}

	@Override
	public void start() {
		while (true) {
			try (MulticastSocket multicastSocket = new MulticastSocket(port)) {
				multicastSocket.joinGroup(InetAddress.getByName(ip));
				while (true) {
					byte[] data = new byte[dataGramSize];
					DatagramPacket packet = new DatagramPacket(data,
							data.length);
					multicastSocket.receive(packet);
				}
			} catch (IOException e) {
			}
		}
	}
}
