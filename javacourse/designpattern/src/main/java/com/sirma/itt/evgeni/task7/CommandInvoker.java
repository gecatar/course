package com.sirma.itt.evgeni.task7;

import java.util.HashMap;
import java.util.Map;

/**
 * Store and execute commands.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class CommandInvoker {

	/**
	 * Map for storing commands.
	 */
	Map<Character, Command> commands = new HashMap<Character, Command>();

	/**
	 * Add operations.
	 */
	public void addOperation(Character key, Command command) {
		commands.put(key, command);
	}

	/**
	 * Invoke commands.
	 */
	public int invoke(int firstNumber, int secondNumber, char operation) {
		if (commands.containsKey(operation)) {
			return commands.get(operation).calculate(firstNumber, secondNumber);
		}
		throw new IllegalArgumentException("Invalid command passed");
	}

}
