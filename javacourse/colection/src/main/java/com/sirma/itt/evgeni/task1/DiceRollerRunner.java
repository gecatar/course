package com.sirma.itt.evgeni.task1;

/**
 * Generate report for two dices whit random generated values.
 * @author Evgeni Stefanov
 *
 */
public class DiceRollerRunner {

	/**
	 * Print report.
	 * @param args
	 */
	public static void main(String[] args) {
		DiceRoller diceRoller = new DiceRoller(6);
		diceRoller.rollDices(100);
		System.out.println(diceRoller);
	}

}
