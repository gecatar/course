package com.sirma.itt.evgeni.client.view;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class ViewRunner {

	public static void main(String[] args) {
		ConverationPane conversationPane = new ConverationPane();
		View view = new View(conversationPane);
		while (true) {
			System.out.println();
			int choise = ConsoleReader.readInt();
			System.out.println("1)Add conversation.");
			System.out.println("2)Display message.");
			if (choise == 1) {
				System.out.println("name:");
				conversationPane.addConversation(ConsoleReader.readString());
			}
			if (choise == 2) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				System.out.println("Enter message:");
				String message = ConsoleReader.readString();
				conversationPane.displayMessage(name, message);
			}
		}

	}

}
