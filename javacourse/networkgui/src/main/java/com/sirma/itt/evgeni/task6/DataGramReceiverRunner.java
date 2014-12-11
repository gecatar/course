package com.sirma.itt.evgeni.task6;

public class DataGramReceiverRunner {

	public static void main(String[] args) {
		new DatagramReceiver("228.5.6.7", 7005, 8).start();
		new DatagramReceiver("228.5.6.8", 7005, 32).start();
	}

}
