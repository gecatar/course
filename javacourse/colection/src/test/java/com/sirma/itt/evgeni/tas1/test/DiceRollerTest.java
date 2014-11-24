package com.sirma.itt.evgeni.tas1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task1.DiceRoller;

public class DiceRollerTest {

	DiceRoller diceRoller;

	@Before
	public void setUp() throws Exception {
		diceRoller = new DiceRoller(6);
	}

	/**
	 * Check adding records whe first dice is in map.
	 */
	@Test
	public void addWhenFirstInMap() {
		diceRoller.addWhenBoothNotInMap(0, 0, 0);
		diceRoller.addWhenFirstDiceInMap(0, 1, 0);
		String expectedRecord = "First Dice:0 Second Dice:0\nDrawns:0 \nFirst Dice:0 Second Dice:1\nDrawns:0 \n";
		assertEquals(expectedRecord, diceRoller.toString());
	}

	/**
	 * Check behavior when booth dices are not included in map.
	 */
	@Test
	public void addWhenBoothNotInMapTest() {
		diceRoller.addWhenBoothNotInMap(0, 0, 0);
		String expectedRecord = "First Dice:0 Second Dice:0\nDrawns:0 \n";
		assertEquals(expectedRecord, diceRoller.toString());
		diceRoller.clearRecords();
	}

	/**
	 * Check behavior when booth dices are included in map.
	 */
	@Test
	public void addWhenBoothDiceInMaptest() {
		diceRoller.addWhenBoothNotInMap(0, 0, 0);
		diceRoller.addWhenBoothDiceInMap(0, 0, 1);
		String expectedRecord = "First Dice:0 Second Dice:0\nDrawns:0 1 \n";
		assertEquals(expectedRecord, diceRoller.toString());
		diceRoller.clearRecords();
	}

}
