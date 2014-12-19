package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Acquire objects from object pool. User define size of pool.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ObjectPoolRunner {

	public static void main(String[] args) {
		System.out.println("Enter size of pool:");
		int size = ConsoleReader.readInt();
		ObjectPool pool = new ObjectPool(size);
		int choise = 0;
		while (choise != 9) {
			System.out.println("Enter number diffrent from 9 to aquire object");
			choise = ConsoleReader.readInt();
			Object object = pool.aquire();
			if (object != null) {
				System.out.println("Operation sucsesofol!!!");
			} else {
				System.out.println("There is no free objects");
			}
		}
	}

}
