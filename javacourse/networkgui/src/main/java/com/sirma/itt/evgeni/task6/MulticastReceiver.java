package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.channels.DatagramChannel;

public class MulticastReceiver extends Thread{

	DatagramSocket socket;
	InetAddress adress;

	public void openConection() {
		try {
			adress = InetAddress.getByName("localhost");
			socket = new DatagramSocket(7005,adress);
		} catch (IOException e) {
			closeConection();
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			DatagramChannel datagramChanel = DatagramChannel.open();
			datagramChanel.socket().connect(InetAddress.getByName("localhost"),7005);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			receive();
		}
	}
	
	public void receive(){
		byte[] data = new byte[4];
		DatagramPacket packet = new DatagramPacket(data,data.length);
		try {
			socket.receive(packet);
			System.out.println("data received !@#@!#@!#");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeConection() {
		socket.close();
	}

}