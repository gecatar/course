package com.sirma.itt.evgeni.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *Generate two dice statistic. 
 * @author Evgeni Stefanov
 *
 */
public class DiceRoller {

	private Dice firstDice;
	private Dice secondDice;
	private int count;

	Map<Integer, Combination> combinations = new HashMap<Integer, Combination>();

	public DiceRoller(int sides) {
		firstDice = new Dice(sides);
		secondDice = new Dice(sides);
		count = 0;
	}

	/**
	 * Generate combination of two dices.
	 */
	public void rollDices() {
		combinations.put(count,
				new Combination(firstDice.rool(), secondDice.rool()));
		count++;
	}
	
	public Set<Entry<Integer,Combination>> getReport(){
		return combinations.entrySet();
	}

	/**
	 * Return statistic as text.
	 */
	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for (Entry<Integer, Combination> combination : combinations.entrySet()) {
			stringBuilder.append("Roll number:").append(combination.getKey());
			stringBuilder.append(" ").append(combination.getValue()).append("\n");
		}
		return stringBuilder.toString();
	}
	
}
