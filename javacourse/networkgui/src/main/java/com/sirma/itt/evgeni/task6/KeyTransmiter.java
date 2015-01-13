package com.sirma.itt.evgeni.task6;

/**
 * Send packages whit different size.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class KeyTransmiter {

	public static final int BASIC_SIZE = 8;
	public static final int EXTENDED_SIZE = 32;
	private DatagramTransmiter basicDatagramTransmiter;
	DatagramTransmiter extendedDatagramTransmiter;

	public KeyTransmiter(DatagramTransmiter basicDatagramTransmiter,
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
