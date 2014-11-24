package com.sirma.itt.evgeni.task5;

/**
 * Real object that will be accesed via proxy class.
 * @author Evgeni Stefanov
 *
 */
public class Calculator {

	public int pow(int firstNumber, int pow) {
		for (int i = 0; i < pow; i++) {
			firstNumber *= firstNumber;
		}
		return firstNumber;
	}
	
	public int divisor(int firstNumber,int secondNumber){
		return firstNumber/secondNumber;
	}
	
	public int sum(int firstNumber,int secondNumber){
		return firstNumber+secondNumber;
	}
	
	public int decrement(int firstNumber){
		firstNumber--;
		return firstNumber;
	}
}