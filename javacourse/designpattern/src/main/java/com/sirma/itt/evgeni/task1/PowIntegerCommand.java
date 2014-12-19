package com.sirma.itt.evgeni.task1;

public class PowIntegerCommand implements Command {

	public int calculate(int firstNumber, int secondNumber) {
		return (int) Math.pow(firstNumber, secondNumber);

	}

}
