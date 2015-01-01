package com.sirma.itt.evgeni.tas1.test;

import static org.junit.Assert.assertEquals;

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
	 * Test saving existing and non existing combination.
	 */
	@Test
	public void saveCombinationTest() {
		diceRoller.saveCombination(1, 1, 1);
		assertEquals("Dices:1 1 Drawns:1", diceRoller.toString());
		diceRoller.saveCombination(1, 1, 3);
		assertEquals("Dices:1 1 Drawns:1 3", diceRoller.toString());
	}
}
