package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task1.CalculatorApp;

/**
 * Check correct working when button is pressed.
 * 
 * @author GecaTM
 *
 */
public class CalculatorAppTest {

	CalculatorApp app;

	/**
	 * Check work when operation and number are passed.
	 */
	@Test
	public void operationPressedTest() {
		app = new CalculatorApp();
		app.operationPresset("0", '+');
		assertEquals(
				"First number:0\nFirst number defined:true\nNext operation:+",
				app.toString());
		app.operationPresset("5", '-');
		assertEquals(
				"First number:0\nFirst number defined:false\nNext operation:+",
				app.toString());
	}

	/**
	 * Check work when equals operation and number are passed.
	 */
	@Test
	public void calculatePressedTest() {
		app = new CalculatorApp();
		app.calculatePresset("890");
		assertEquals(
				"First number:null\nFirst number defined:false\nNext operation: ",
				app.toString());
		app.operationPresset("123", '+');
		assertEquals(
				"First number:123\nFirst number defined:true\nNext operation:+",
				app.toString());
	}

}
