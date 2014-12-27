package com.sirma.itt.evgeni.tas1.test;

import org.junit.Assert;
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
	 * Check behavior when adding existing combination.
	 */
	@Test
	public void addExistingCombinationTest() {
		diceRoller.clearRecords();
		diceRoller.saveCombination(1, 2, 0);
		Assert.assertTrue(diceRoller.saveCombination(1, 2, 1));
	}

	/**
	 * Check behavior when adding non existing combination.
	 */
	@Test
	public void addNonExsistingCombinationTest() {
		diceRoller.clearRecords();
		Assert.assertTrue(diceRoller.saveCombination(1, 2, 0));
	}
}
