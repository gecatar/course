package com.sirma.itt.evgeni.task7.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task7.Calculator;
import com.sirma.itt.evgeni.task7.CommandInvoker;
import com.sirma.itt.evgeni.task7.DeductCommand;
import com.sirma.itt.evgeni.task7.DivisionCommand;
import com.sirma.itt.evgeni.task7.MultiplyCommand;
import com.sirma.itt.evgeni.task7.PowCommand;
import com.sirma.itt.evgeni.task7.SumCommand;

/**
 * Test creating and storing command.
 * 
 * @author root
 *
 */
public class CommandInvokerTest {

	@Test
	public void commandInvokerTest() {

		CommandInvoker invoker = new CommandInvoker();
		Calculator calculator = new Calculator();

		invoker.addOperation('-', new DeductCommand(calculator));
		invoker.addOperation('+', new SumCommand(calculator));
		invoker.addOperation('*', new MultiplyCommand(calculator));
		invoker.addOperation('/', new DivisionCommand(calculator));
		invoker.addOperation('^', new PowCommand(calculator));

		assertEquals(2, invoker.invoke(1, 1, '+'));
		assertEquals(0, invoker.invoke(1, 1, '-'));
		assertEquals(2, invoker.invoke(1, 2, '*'));
		assertEquals(1, invoker.invoke(1, 1, '/'));
		assertEquals(9, invoker.invoke(3, 2, '^'));
	}

}
