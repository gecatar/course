package com.sirma.itt.evgeni.util;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleReader {

	static Scanner sc = new Scanner(System.in);

	/**
	 * Read string from console. Reading from console continue while user enter
	 * correct data.
	 * 
	 * @return string from user input.
	 */
	public static String readString() {
		try {
			return sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error!!!");
			sc.next();
			return readString();
		}
	}

	/**
	 * Read from console while user enter correct data.
	 * 
	 * @return integer value(user input).
	 */
	public static int readInt() {

		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter only integer numbers!!!");
			sc.next();
			return readInt();
		}

	}

	/**
	 * Read char.
	 * 
	 * @return char(user input).
	 */
	public static char readChar() {
		try {
			return sc.next().charAt(0);
		} catch (InputMismatchException e) {
			System.out.println("Enter only charecter!!!");
			sc.next();
			return readChar();
		}
	}

	/**
	 * Read float.
	 * 
	 * @return float value(user input).
	 */
	public static float readFloat() {
		try {
			return sc.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println("Enter only float values!!!");
			sc.next();
			return readFloat();
		}
	}

	/**
	 * Read integer value and throw exception if value is not in range.
	 * 
	 * @param min
	 *            if user input is below min an exception occur.
	 * @param max
	 *            if user input is higher then exception occur.
	 * @return user input value.
	 * @throws IllegalArgumentException
	 *             when user data is not in range.
	 */
	public static int readIntInterval(int min, int max) {

		try {
			int number = sc.nextInt();
			if (number <= min || number >= max) {
				throw new IllegalArgumentException("Enter value only in expected range!!!");
			}
			return number;
		} catch (NoSuchElementException e) {
			System.out.println("Enter only integer!!!");
			return readIntInterval(min, max);
		} 
	}
}
