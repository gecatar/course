package com.sirma.itt.evgeni.task6;


/**
 * Send packages whit different size.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PackageSender {

	public static final int BASIC_SIZE = 8;
	public static final int EXTENDED_SIZE = 32;
	public static final int DOUBLE_SIZE = 40;
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
	public void send(byte[] data) {
		if (data.length == BASIC_SIZE) {
			sendPackage(data, basicDatagramTransmiter);
		}
		if (data.length == EXTENDED_SIZE) {
			sendPackage(data, extendedDatagramTransmiter);
		}
		if (data.length == DOUBLE_SIZE) {
			// sendPackage(dataGramPacket, extendedDatagramTransmiter);
		}
	}

	/**
	 * Send extended data gram packets.
	 * 
	 * @param dataGramPacked
	 */
	public void sendPackage(byte[] data, DatagramTransmiter datagramTransmiter) {
		datagramTransmiter.sendPacked(data);
	}
}
