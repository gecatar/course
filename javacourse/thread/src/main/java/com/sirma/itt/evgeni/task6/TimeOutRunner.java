package com.sirma.itt.evgeni.task6;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create time out table tath will manage objects. If objects are not used in
 * last session they will be deleted. User define interval for changing session.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TimeOutRunner {

	public static void main(String[] args) {

		TimeOutTable timeOutTest = new TimeOutTable(1000);

		timeOutTest.put("hhjgjhgjh", new Object());
		timeOutTest.put("hhj@#$@", new Object());
		timeOutTest.put("hhj@23423#$@", new Object());

		int choise = 0;
		while (choise != 9) {
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("adding element...");
				System.out.println("enter description....$%^$%");
				String temp = ConsoleReader.readString();
				timeOutTest.put(temp, new Object());
			}
			if (choise == 2) {
				System.out.println("Removing element...@!#");
				System.out.println("enter description....$%^$%");
				String temp = ConsoleReader.readString();
				timeOutTest.remove(temp);
			}
			if (choise == 3) {
				System.out.println("Geting element...@!#");
				System.out.println("enter description....$%^$%");
				String temp = ConsoleReader.readString();
				System.out.println(timeOutTest.get(temp));
			}
		}
	}
}