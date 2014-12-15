package com.sirma.itt.evgeni.task7;

import java.util.HashMap;
import java.util.Map;

import com.sirma.itt.evgeni.task1.Command;

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
	 * Allow adding commands.
	 * 
	 * @param key
	 *            specify concrete command.
	 * @param command
	 */
	public void addOperation(Character key, Command command) {
		commands.put(key, command);
	}

	/**
	 * 
	 * @param firstNumber
	 *            first of two values.
	 * @param secondNumber
	 *            second of two values.
	 * @param operation
	 *            determine which command will be executed.
	 * @return result from calculation. Return 0 if command is not included in
	 *         map.
	 */
	public int invoke(int firstNumber, int secondNumber, char operation) {
		if (commands.containsKey(operation)) {
			return commands.get(operation).calculate(firstNumber, secondNumber);
		}
		throw new IllegalArgumentException("Invalid command passed");
	}

}
