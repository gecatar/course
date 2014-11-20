package com.sirma.itt.evgeni.task1;

/**
 * Contain two dice combination.
 * @author Evgeni Stefanov
 *
 */
public class Combination {

	private int firstDice;
	private int secondDice;

	/**
	 * First dice value.
	 * @return random generated value.
	 */
	public int getFirstDice() {
		return firstDice;
	}

	/**
	 * Second dice value.
	 * @return random generated value.
	 */
	public int getSecondDice() {
		return secondDice;
	}

	/**
	 * Return dice combination as text.
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("First Dice:").append(firstDice)
				.append(" Second Dice:").append(secondDice).toString();
	}

	public Combination(int firstDice, int secondDice) {
		this.firstDice = firstDice;
		this.secondDice = secondDice;
	}
}
