package com.sirma.itt.evgeni.task7;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Allow adding and removing stocks from store. If operation can't be completed
 * thread suspend its execution and wait while state is changed.
 * 
 * @author Evgeni Stefanov
 *
 */
public class TraderRunner {

	public static void main(String[] args) {

		System.out.println("Enter size on store:");
		int size = ConsoleReader.readInt();
		Store store = new Store(size);

		int choise = 0;
		while (choise != 9) {

			System.out.println("Enter operation...:");
			System.out.println("1)Buy stock.");
			System.out.println("2)Sell stock.");
			System.out.println("3)List inventary.");
			choise = ConsoleReader.readInt();

			if (choise == 1) {

				System.out.println("Enter description:");
				String description = ConsoleReader.readString();
				System.out.println("Enter quantity:");
				int quantity = ConsoleReader.readInt();

				new Buyer(store, description, quantity).start();
			}
			if (choise == 2) {

				System.out.println("Enter description:");
				String description = ConsoleReader.readString();
				System.out.println("Enter quantity:");
				int quantity = ConsoleReader.readInt();

				new Seller(store, description, quantity).start();
			}
			if (choise == 3) {
				System.out.println(store);
			}
		}

	}

}