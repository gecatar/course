package com.sirma.itt.evgeni.commands;

public class DeductIntegerCommand implements Command {

	public int calculate(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

}