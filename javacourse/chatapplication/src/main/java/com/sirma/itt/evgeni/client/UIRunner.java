package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class UIRunner {

	public static void main(String[] args) {
		
		ClientControler clientControler = new ClientControler();
		Client client = new Client(clientControler);
		ClientWindow window = new ClientWindow(clientControler);
		int choise = 0;
		while (choise != -1) {
			System.out.println("1)Add conversation");
			System.out.println("2)Add user");
			System.out.println("3)Remove user");
			System.out.println("4)Display mesage");
			System.out.println("5)Select conversation");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Adding conversation...");
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				window.addConversation(name);
			}
			if (choise == 2) {
				System.out.println("Adding user...");
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				window.addUser(name);
			}
			if (choise == 3) {
				System.out.println("Removing user...");
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				window.removeUser(name);
			}
			if (choise == 4) {
			}
			if (choise == 5) {
				System.out.println("Secelcting conversation...");
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				window.selectConversation(name);
			}
			if (choise == 0) {
			}
		}

	}

}
