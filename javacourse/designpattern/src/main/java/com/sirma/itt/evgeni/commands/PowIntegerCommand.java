package com.sirma.itt.evgeni.commands;

public class PowIntegerCommand implements Command {

	public int calculate(int firstNumber, int secondNumber) {
		return (int) Math.pow(firstNumber, secondNumber);

	}

}
