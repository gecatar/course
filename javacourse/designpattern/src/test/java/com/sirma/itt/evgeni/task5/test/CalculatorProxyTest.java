package com.sirma.itt.evgeni.task5.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task5.CalculatorProxy;

/**
 * Test working on proxy class.
 * 
 * @author GecaTM
 *
 */
public class CalculatorProxyTest {

	CalculatorProxy calculatorProxy;

	/**
	 * Create calculator proxy.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculatorProxy = new CalculatorProxy("User");
	}

	/**
	 * Test mathematical calculation.
	 */
	@Test
	public void calculatorProxyTest() {
		assertEquals(9, calculatorProxy.pow(3, 2));
		assertEquals(6, calculatorProxy.sum(4, 2));
		assertEquals(3, calculatorProxy.decrement(4));
	}

	/**
	 * Test correct returning on exception.
	 */
	@Test(expected = IllegalAccessError.class)
	public void proxyExceptionTest() {
		calculatorProxy.divisor(3, 3);
	}

}
