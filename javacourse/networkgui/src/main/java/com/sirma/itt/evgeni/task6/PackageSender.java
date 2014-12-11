package com.sirma.itt.evgeni.task6;

import java.net.DatagramPacket;

/**
 * Send packages whit different size.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PackageSender {

	private static final int BASIC_SIZE = 8;
	private static final int EXTENDED_SIZE = 32;
	private static final int DOUBLE_SIZE = 40;
	DatagramTransmiter basicDatagramTransmiter;
	DatagramTransmiter extendedDatagramTransmiter;

	public PackageSender(DatagramTransmiter basicDatagramTransmiter,
			DatagramTransmiter extendedDatagramTransmiter) {
		this.basicDatagramTransmiter = basicDatagramTransmiter;
		this.extendedDatagramTransmiter = extendedDatagramTransmiter;
	}

	/**
	 * Send Data gram packets.
	 * 
	 * @param dataGramPacket
	 */
	public void send(DatagramPacket dataGramPacket) {
		if (dataGramPacket.getData().length == BASIC_SIZE) {
			sendPackage(dataGramPacket, basicDatagramTransmiter);
		}
		if (dataGramPacket.getData().length == EXTENDED_SIZE) {
			sendPackage(dataGramPacket, extendedDatagramTransmiter);
		}
		if (dataGramPacket.getData().length == DOUBLE_SIZE) {
			// sendPackage(dataGramPacket, extendedDatagramTransmiter);
		}
	}

	/**
	 * Send extended data gram packets.
	 * 
	 * @param dataGramPacked
	 */
	public void sendPackage(DatagramPacket dataGramPacked,
			DatagramTransmiter datagramTransmiter) {
		datagramTransmiter.sendPacked(dataGramPacked);
	}
}
