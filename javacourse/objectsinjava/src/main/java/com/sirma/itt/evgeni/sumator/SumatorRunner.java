package com.sirma.itt.evgeni.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.sirma.itt.evgeni.util.MathUtil;

/**
 * Call Sumator class and make calculations.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class SumatorRunner {

	/**
	 * Make calculation whit different type variables.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Call MathUtil class and make calculation");
		int firstInt = 5;
		int secondInt = 6;
		System.out.println("Summing two int numbers " + firstInt + " and "
				+ secondInt + " is: " + MathUtil.sum(firstInt, secondInt));
		float firstFloat = 6.09f;
		float secondFloat = 7.01f;
		System.out
				.println("Summing two float numbers " + firstFloat + " and "
						+ secondFloat + " is: "
						+ MathUtil.sum(firstFloat, secondFloat));
		BigDecimal firstBigDecimal = new BigDecimal(0.0023874);
		BigDecimal secondBigDecimal = new BigDecimal(0.02387498);
		System.out.println("Summing two BigDecimal numbers " + firstBigDecimal
				+ " and " + secondBigDecimal + " is: "
				+ MathUtil.sum(firstBigDecimal, secondBigDecimal));
		BigInteger firstBigInteger = new BigInteger(
				"98233284092384923840932987324");
		BigInteger secondBigInteger = new BigInteger("9823328409232343");
		System.out.println("Summing two BigInteger numbers " + firstBigInteger
				+ " and " + secondBigInteger + " is: "
				+ MathUtil.sum(firstBigInteger, secondBigInteger));

	}

}
