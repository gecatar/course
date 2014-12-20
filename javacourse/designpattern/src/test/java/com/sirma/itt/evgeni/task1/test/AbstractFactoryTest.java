package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.commands.DeductIntegerCommand;
import com.sirma.itt.evgeni.commands.DivisionIntegerCommand;
import com.sirma.itt.evgeni.commands.MultiplyIntegerCommand;
import com.sirma.itt.evgeni.commands.SumIntegerCommand;
import com.sirma.itt.evgeni.factory.Factory;
import com.sirma.itt.evgeni.factory.FactoryProducer;

/**
 * Test abstract factory methods.
 * 
 * @author GecaTM
 *
 */
public class AbstractFactoryTest {

	private Factory factory = FactoryProducer.getFactory("integer");

	/**
	 * Test creating on objects.
	 */
	@Test
	public void createInstanceTest() {
		assertEquals(factory.createInstance("multiply").getClass(),
				MultiplyIntegerCommand.class);
		assertEquals(factory.createInstance("division").getClass(),
				DivisionIntegerCommand.class);
		assertEquals(factory.createInstance("sum").getClass(),
				SumIntegerCommand.class);
		assertEquals(factory.createInstance("deduct").getClass(),
				DeductIntegerCommand.class);
	}

}
