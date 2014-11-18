package com.sirma.itt.evgeni.sumator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

import com.sirma.itt.evgeni.util.MathUtil;

public class SumatorTest {

	@Test
	public void test() {
		int firstInt = 5;
		int secondInt = 6;
		int expectedInt = 11;
		int actualInt = MathUtil.sum(firstInt, secondInt);
		BigDecimal firstBigDecimal = new BigDecimal(2);
		BigDecimal secondBigDecimal = new BigDecimal(4);
		BigDecimal expectedBigDecimal = new BigDecimal(6);
		BigDecimal actualBigDecimal = MathUtil.sum(firstBigDecimal, secondBigDecimal);
		BigInteger firstBigInteger = new BigInteger("99999999999999999");
		BigInteger secondBigInteger = new BigInteger("1");
		BigInteger actualBigInteger = MathUtil.sum(firstBigInteger, secondBigInteger);
		BigInteger expectedBigInteger = new BigInteger("100000000000000000");
		assertEquals(expectedInt, actualInt);
		assertEquals(expectedBigDecimal, actualBigDecimal);
		assertEquals(expectedBigInteger, actualBigInteger);
	}

}

