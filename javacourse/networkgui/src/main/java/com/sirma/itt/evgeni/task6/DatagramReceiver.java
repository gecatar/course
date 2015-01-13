package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Receive data gram packages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DatagramReceiver extends Thread {

	private static final Logger LOGGER = Logger
			.getLogger(DatagramReceiver.class.getName());
	private final String ip;
	private final int port;
	private final int dataGramSize;

	public DatagramReceiver(String ip, int port, int datagramSize) {
		this.ip = ip;
		this.port = port;
		this.dataGramSize = datagramSize;
	}

	/**
	 * Read data gram packages while socket is open.
	 */
	@Override
	public void run() {
		try (MulticastSocket multicastSocket = new MulticastSocket(port)) {
			multicastSocket.joinGroup(InetAddress.getByName(ip));
			while (true) {
				byte[] data = new byte[dataGramSize];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				multicastSocket.receive(packet);
				System.out.println("data gram received!!!");
			}
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, "Error when receiving data.", e);
		}
	}
}
