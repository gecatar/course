package com.sirma.itt.evgeni.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.sirma.itt.evgeni.interfaces.UserInputReader;

public class InputReader implements UserInputReader{
	
	static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Read string from console. Reading from console continue while user enter
	 * correct data.
	 * 
	 * @return string from user input.
	 */
	public String readString() {
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
	public int readInt() {

		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter only integer numbers!!!");
			sc.next();
			return readInt();
		}

	}

	/**
	 * Read string from console. Reading from console continue while user enter
	 * correct data.
	 * 
	 * @return string from user input.
	 */
	public String readLine() {
		try {
			return sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Input error!!!");
			sc.next();
			return readLine();
		}
	}

}
