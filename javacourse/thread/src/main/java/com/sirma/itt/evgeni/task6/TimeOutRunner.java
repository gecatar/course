package com.sirma.itt.evgeni.task6;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create time out table that will manage objects. If objects are not used in
 * last session they will be deleted. User define interval for changing session.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TimeOutRunner {

	public static void main(String[] args) {

		System.out.println("Enter timeout value:");
		int timeOut = ConsoleReader.readInt();
		TimeOutTable timeOutTest = new TimeOutTable(timeOut);

		int choise = 0;
		while (choise != 9) {
			System.out.println("1)Add element");
			System.out.println("2)Remove element");
			System.out.println("3)Get element");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Adding element...");
				System.out.println("enter description:");
				String temp = ConsoleReader.readString();
				timeOutTest.put(temp, new Object());
			}
			if (choise == 2) {
				System.out.println("Removing element...");
				System.out.println("enter description:");
				String temp = ConsoleReader.readString();
				timeOutTest.remove(temp);
			}
			if (choise == 3) {
				System.out.println("Geting element...");
				System.out.println("enter description:");
				String temp = ConsoleReader.readString();
				System.out.println(timeOutTest.get(temp));
			}
		}
	}
}