package com.sirma.itt.evgeni.tas1.test;

import static org.junit.Assert.*;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.sirma.itt.evgeni.task1.Combination;
import com.sirma.itt.evgeni.task1.DiceRoller;

/**
 * Check correct generating on dice statistic.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DiceRollerTest {

	/**
	 * Check if there entry's with values that are not compatible with given
	 * criteria.
	 */
	@Test
	public void diceRollerTest() {

		DiceRoller diceRoller = new DiceRoller(6);
		for (int i = 0; i < 20; i++) {
			diceRoller.rollDices();
		}
		Set<Entry<Integer, Combination>> report = diceRoller.getReport();
		assertTrue(report.size() == 20);
		for (Entry<Integer, Combination> roll : report) {
			int firstDice = roll.getValue().getFirstDice();
			int secondDice = roll.getValue().getSecondDice();
			assertTrue(firstDice > 0 && firstDice < 7);
			assertTrue(secondDice > 0 && firstDice < 7);
		}
	}

}
