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

	Map<Integer, Map<Integer, ArrayList<Integer>>> combinations = new HashMap<Integer, Map<Integer, ArrayList<Integer>>>();

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
		combinations = new HashMap<Integer, Map<Integer, ArrayList<Integer>>>();
	}

	/**
	 * Save combination in record base.
	 * @param firstDice
	 * @param secondDice
	 * @param drawNumber
	 * @return
	 */
	public boolean saveCombination(int firstDice, int secondDice, int drawNumber) {
		if (combinations.containsKey(firstDice)) {
			if (combinations.get(firstDice).containsKey(secondDice)) {
				addWhenBoothDiceInMap(firstDice, secondDice, drawNumber);
			} else {
				addWhenFirstDiceInMap(firstDice, secondDice, drawNumber);
			}
		} else {
			addWhenBoothNotInMap(firstDice, secondDice, drawNumber);
		}
		return false;
	}

	/**
	 * Add combination when first dice is included in record.
	 * @param firstDice
	 * @param secondDice
	 * @param drawNumber
	 */
	public void addWhenFirstDiceInMap(int firstDice, int secondDice,
			int drawNumber) {
		ArrayList<Integer> drawnData = new ArrayList<Integer>();
		drawnData.add(drawNumber);
		combinations.get(firstDice).put(secondDice, drawnData);
	}

	/**
	 * Add combination when two dices are included.
	 * @param firstDice
	 * @param secondDice
	 * @param drawNumber
	 */
	public void addWhenBoothDiceInMap(int firstDice, int secondDice,
			int drawNumber) {
		combinations.get(firstDice).get(secondDice).add(drawNumber);
	}

	/**
	 * Add combination when booth dices are not in records.
	 * @param firstDice
	 * @param secondDice
	 * @param drawNumber
	 */
	public void addWhenBoothNotInMap(int firstDice, int secondDice,
			int drawNumber) {
		Map<Integer, ArrayList<Integer>> temp = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> drawnColection = new ArrayList<Integer>();
		drawnColection.add(drawNumber);
		temp.put(secondDice, drawnColection);
		combinations.put(firstDice, temp);
	}

	/**
	 * Return statistic as text.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Entry<Integer, Map<Integer, ArrayList<Integer>>> firstEntry : combinations
				.entrySet()) {
			for (Entry<Integer, ArrayList<Integer>> secondEntry : firstEntry
					.getValue().entrySet()) {
				stringBuilder.append("First Dice:").append(firstEntry.getKey())
						.append(" ");
				stringBuilder.append("Second Dice:")
						.append(secondEntry.getKey()).append("\n");
				stringBuilder.append("Drawns:");
				for (Integer integer : secondEntry.getValue()) {
					stringBuilder.append(integer).append(" ");
				}
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
}
