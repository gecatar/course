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
		Object object = null;
		while (choise != 9) {
			System.out.println("Choose operation:");
			System.out.println("1)Aquire object");
			System.out.println("2)Release last aquired object");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				object = pool.aquire();
				if (object != null) {
					System.out.println("Operation sucsesofol!!!");
				} else {
					System.out.println("There is no free objects");
				}
			}
			if (choise == 2) {
				if (pool.release(object)) {
					System.out.println("Operation is sucsesofol");
				} else {
					System.out.println("Operation is not sucsesofol");
				}
			}

		}
	}

}
