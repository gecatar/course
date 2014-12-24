package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task1.Display;

public class DisplayTest {

	Display display;

	/**
	 * Check adding symbols functionality.
	 */
	@Test
	public void addSymbolTest() {
		display = new Display();
		display.addSymbol('0');
		assertEquals("", display.getText());
		display.addSymbol('.');
		assertEquals("0.", display.getText());
		display.addSymbol('.');
		assertEquals("0.", display.getText());
		display.removeSymbol();
		display.removeSymbol();
		display.addSymbol('9');
		assertEquals("9", display.getText());
	}

	/**
	 * Check removing symbol method.
	 */
	@Test
	public void removeSymbolTest() {
		display = new Display();
		display.addSymbol('0');
		display.removeSymbol();
		assertEquals("", display.getText());
	}

}
