package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastTransmiter {
	
	MulticastSocket socket;
	InetAddress adress;
	
	public void openConection(){
		try {
			socket = new MulticastSocket(7005);
			adress = InetAddress.getByName("localhost");
		} catch (IOException e) {
			closeConection();
			e.printStackTrace();
		}
	}
	
	public void sendData(){
		byte[] data = {'t','e','s','t'};
		DatagramPacket packet = new DatagramPacket(data,data.length,adress,7005);
		try {
			socket.send(packet);
			System.out.println("Data sended @!#@!!@$#@$");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConection(){
		socket.close();
	}
}
