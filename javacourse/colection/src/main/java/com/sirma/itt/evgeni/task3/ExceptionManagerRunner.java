package com.sirma.itt.evgeni.task3;

import java.util.List;
import java.util.Set;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Collect errors and their description.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ExceptionManagerRunner {

	/**
	 * Allow user to add errors and their description.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ExceptionManager exmng = new ExceptionManager();
		System.out.println("List of error codes:");
		Set<String> codes = exmng.getKeys();
		for (String key : codes) {
			System.out.println(key);
		}
		System.out.println("1)Add exception via code.");
		System.out.println("2)Add exception via text.");
		System.out.println("3)List saved exception.");
		System.out.println("4)Add exception code and description.");
		System.out.println("5)List error codes.");
		System.out.println("9)EXIT");
		int choise = 0;
		while (choise != 9) {
			choise = ConsoleReader.readInt();
			switch (choise) {
			case 1: {
				System.out.println("Enter error code:");
				exmng.addExceptionUsingCode(ConsoleReader.readString());
				break;
			}
			case 2: {
				System.out
						.println("Enter mesage. If mesage is incorect it will not be stored.");
				exmng.addExceptionMesage(ConsoleReader.readString());
				break;
			}
			case 3: {
				List<String> list = exmng.getMesages(exmng.getMesage());
				for (String str : list) {
					System.out.println(str);
				}
				break;
			}
			case 4: {
				System.out
						.println("Enter key and description for new type error.");
				exmng.addExceptionAndDescription(ConsoleReader.readString(),
						ConsoleReader.readString());
				break;
			}
			}
		}
	}
}
