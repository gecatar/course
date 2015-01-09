package com.sirma.itt.evgeni.task7.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task7.Calculator;
import com.sirma.itt.evgeni.task7.CommandInvoker;

/**
 * Test creating and storing command.
 * 
 * @author root
 *
 */
public class CommandInvokerTest {

	@Test
	public void commandInvokerTest() {

		Calculator calculator = new Calculator();
		CommandInvoker invoker = new CommandInvoker(calculator);

		assertEquals(2, invoker.invoke(1, 1, '+'));
		assertEquals(0, invoker.invoke(1, 1, '-'));
		assertEquals(2, invoker.invoke(1, 2, '*'));
		assertEquals(1, invoker.invoke(1, 1, '/'));
		assertEquals(9, invoker.invoke(3, 2, '^'));
	}

}
