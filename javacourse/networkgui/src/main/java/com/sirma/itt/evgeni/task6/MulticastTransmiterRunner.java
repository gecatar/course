package com.sirma.itt.evgeni.task6;

import java.net.UnknownHostException;

public class MulticastTransmiterRunner {

	public static void main(String[] args) throws UnknownHostException,
			InterruptedException {
		DatagramTransmiter firstDatagramTransmiter = new DatagramTransmiter(
				"228.5.6.7", 7005);
		DatagramTransmiter secondDatagramTransmiter = new DatagramTransmiter(
				"228.5.6.8", 7005);
		firstDatagramTransmiter.conect();
		secondDatagramTransmiter.conect();
		int choise = 0;
		while (choise != 9) {
			Thread.sleep(2000);
			firstDatagramTransmiter.sendPacked(new byte[8]);
			Thread.sleep(2000);
			secondDatagramTransmiter.sendPacked(new byte[32]);
		}
	}

}