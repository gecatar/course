package com.sirma.itt.evgeni.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Generate two dice statistic.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DiceRoller {

	private final Dice firstDice;
	private final Dice secondDice;

	private final Map<String, ArrayList<Integer>> combinations = new HashMap<String, ArrayList<Integer>>();

	public DiceRoller(int sides) {
		firstDice = new Dice(sides);
		secondDice = new Dice(sides);
	}

	/**
	 * Generate combination of two dices.
	 */
	public void rollDices(int drawns) {
		for (int i = 0; i < drawns; i++) {
			saveCombination(firstDice.rool(), secondDice.rool(), i);
		}
	}

	/**
	 * Clear saved Records.
	 */
	public void clearRecords() {
		combinations.clear();
	}

	/**
	 * Save combination in record base.
	 * 
	 * @param firstDice
	 * @param secondDice
	 * @param drawNumber
	 * @return
	 */
	public boolean saveCombination(int firstDice, int secondDice, int drawNumber) {
		String combination = getCombinationString(firstDice, secondDice);
		if (combinations.containsKey(combination)) {
			return addExsistingCombination(combination, drawNumber);
		} else {
			return addNonExsistingCombination(combination, drawNumber);
		}
	}

	/**
	 * Create string whit two values of dices.
	 * 
	 * @param firstDice
	 * @param secondDice
	 * @return
	 */
	public String getCombinationString(int firstDice, int secondDice) {
		return String.valueOf(firstDice) + " " + secondDice;
	}

	/**
	 * Add existing combination.
	 * 
	 * @param combination
	 * @param drawNumber
	 * @return
	 */
	public boolean addExsistingCombination(String combination, int drawNumber) {
		if (combinations.containsKey(combination)) {
			combinations.get(combination).add(drawNumber);
			return true;
		}
		return false;
	}

	/**
	 * Add non existing combination.
	 * 
	 * @param combination
	 * @param drawNumber
	 * @return
	 */
	public boolean addNonExsistingCombination(String combination, int drawNumber) {
		if (!combinations.containsKey(combination)) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(drawNumber);
			combinations.put(combination, temp);
			return true;
		}
		return false;
	}

	/**
	 * Return statistic as text.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Entry<String, ArrayList<Integer>> entry : combinations.entrySet()) {
			stringBuilder.append("Dices:").append(entry.getKey()).append(" ");
			stringBuilder.append("Drawns:");
			for (Integer integer : entry.getValue()) {
				stringBuilder.append(integer).append(" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString().trim();
	}
}
