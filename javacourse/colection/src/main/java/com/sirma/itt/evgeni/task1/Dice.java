package com.sirma.itt.evgeni.task1;

/**
 * Generate random value. User define dice sides.
 * @author Evgeni Stefanov
 *
 */
public class Dice {

	private int sides;
	
	public Dice(int sides){
		this.sides = sides;
	}

	/**
	 * Generate random value.
	 * @return random dice value.
	 */
	public int rool() {
		return (int) (Math.random() * sides) + 1;
	}
}
