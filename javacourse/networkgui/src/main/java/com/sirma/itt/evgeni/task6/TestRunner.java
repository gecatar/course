package com.sirma.itt.evgeni.task6;


public class TestRunner {

	public static void main(String[] args) throws InterruptedException {
		TestTransmiter testTransmiter = new TestTransmiter();
		testTransmiter.conect();
		TestReceiver testReceiver = new TestReceiver();
		testReceiver.start();
		while(true){
			Thread.sleep(1000);
			if(testTransmiter.sendData()){
				System.out.println("Data sended");
			}
		}
	}

}
