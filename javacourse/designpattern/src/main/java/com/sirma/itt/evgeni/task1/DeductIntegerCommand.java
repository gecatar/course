package com.sirma.itt.evgeni.task1;

public class DeductIntegerCommand implements Command {

	public int calculate(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

}