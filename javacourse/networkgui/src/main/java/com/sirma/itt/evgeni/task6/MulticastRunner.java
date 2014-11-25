package com.sirma.itt.evgeni.task6;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class MulticastRunner {

	public static void main(String[] args) {
		MulticastTransmiter transmiter = new MulticastTransmiter();
	//	MulticastReceiver receiver = new MulticastReceiver();
		transmiter.openConection();
	//	receiver.openConection();
	//	receiver.start();
		new TestReceiver().start();
		while(true){
			ConsoleReader.readInt();
			transmiter.sendData();
		}
		
	}

}