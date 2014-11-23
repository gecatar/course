package com.sirma.itt.evgeni.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Generate two dice statistic.
 * 
 * @author Evgeni Stefanov
 *
 */
public class DiceRoller {

	private Dice firstDice;
	private Dice secondDice;
	private int count;

	Map<Combination, ArrayList<Integer>> combinations = new HashMap<Combination, ArrayList<Integer>>();

	public DiceRoller(int sides) {
		firstDice = new Dice(sides);
		secondDice = new Dice(sides);
		count = 0;
	}

	/**
	 * Generate combination of two dices.
	 */
	public void rollDices() {
	}

	public Set<Entry<Integer, Combination>> getReport() {
		return null;
	}

	/**
	 * Return statistic as text.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.toString();
	}
}
