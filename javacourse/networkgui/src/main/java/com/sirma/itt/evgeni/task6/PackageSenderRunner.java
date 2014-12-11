package com.sirma.itt.evgeni.task6;

import java.io.IOException;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class PackageSenderRunner {

	public static void main(String[] args) throws IOException {
		DatagramTransmiter basicDataGramTransmiter = new DatagramTransmiter(
				"228.5.6.7", 7005);
		DatagramTransmiter extendedDataGramTransmiter = new DatagramTransmiter(
				"228.5.6.8", 7005);
		PackageSender packageSender = new PackageSender(
				basicDataGramTransmiter, extendedDataGramTransmiter);
		int choise = 0;
		while (choise != 9) {
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Sending 8 byte package.");
				packageSender.send(new byte[8]);
			}
			if (choise == 2) {
				System.out.println("Sending 32 byte package.");
				packageSender.send(new byte[32]);
			}
		}
	}
}
