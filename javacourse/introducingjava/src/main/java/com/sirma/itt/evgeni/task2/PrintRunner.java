package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ArrayUtil;
import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Call ArrayUtil class and print all elements in array as text.
 * @author Evgeni Stefanov
 *
 */
public class PrintRunner {

	public static void main(String[] args) {
		System.out.println("Print all elements in array.");
		System.out.println("Enter number of elements:");
		int count = ConsoleReader.readInt();
		int[] array = new int[count];
		for(int i=0;i<count;i++){
			System.out.println("Enter "+i+" element:");
			array[i] = ConsoleReader.readInt();
		}
		System.out.println(ArrayUtil.print(array));
	}

}
