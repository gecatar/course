package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.TextUtil;

/**
 * Add and remove elements from massive. If list is full or empty an exception
 * occur.
 * 
 * @author Evgeni Stefanov
 */
public class HolderRunner {

	/**
	 * Add and remove elements from massive.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Holder holder = new Holder(5);
		int choise = 0;
		while (choise != 9) {
			System.out.println("Choose operation:");
			System.out.println("1)Add element.");
			System.out.println("2)Delete element.");
			System.out.println("9)EXIT!");
			choise = ConsoleReader.readInt();

			switch (choise) {
			case 1: {
				System.out.println("Enter length of String:");
				int length = ConsoleReader.readInt();
				String string = TextUtil.getRandomString(length);
				new ItemAdder(holder, string).start();
				break;
			}
			case 2:
				new ItemRemover(holder).start();
				;
				break;
			}

		}
	}

}