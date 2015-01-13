package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create counter thread and start counting. Until user send stop command.
 * 
 * @author Evgeni Stefanov
 *
 */
public class CounterRunner {

	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.start();
		System.out.println("Enter char to stop counting");
		ConsoleReader.readChar();
		counter.setStop(true);
		System.out.println("Count value is:" + counter.getCount());
	}

}
