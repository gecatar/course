package com.sirma.itt.evgeni.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class UIRunnerTest extends Thread implements UILIstener {

	JFrame frame;
	StaffPane staffPane;

	public UIRunnerTest() {
		staffPane = new StaffPane(this);
		frame = new JFrame();
		frame.setSize(new Dimension(400, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(staffPane);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new UIRunnerTest().start();
	}

	@Override
	public void run() {
		int choise = 0;
		while (choise != 9) {
			System.out.println("1)Add user");
			System.out.println("2)Remove user");
			System.out.println("3)Display message");
			System.out.println("4)User selected");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Enter user name:");
				String name = ConsoleReader.readString();
				staffPane.addUser(name);
			}
			if (choise == 2) {
				System.out.println("Enter user name:");
				String name = ConsoleReader.readString();
				staffPane.removeUser(name);
			}
			if (choise == 3) {
				System.out.println("Enter user name:");
				String name = ConsoleReader.readString();
				System.out.println("Enter message:");
				String message = ConsoleReader.readString();
				staffPane.displayMessage(name, message);
			}
			if (choise == 4) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				staffPane.userSelected(name);
			}
		}

	}

	public void startConection(String nickname, String ip, String port) {
		System.out.println("Start conection-nickname:" + nickname);
		System.out.println("Start conection-ip:" + ip);
		System.out.println("Start conection-port:" + port);
	}

	public void stopConection() {
		System.out.println("Stop conection command sended...@!#!@#@!#");
	}

	public void sendMessage(String name, String message) {
		// TODO Auto-generated method stub
		System.out.println("Send message:" + name + " Text:" + message);
	}

}
