package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.util.ArrayUtil;
import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Apply quick sort algorithm.
 * @author Evgeni Stefanov
 *
 */
public class SortingRunner {

	/**
	 * Prompt user to enter array element and apply quick sort.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Sort array.");
		System.out.println("Enter number of elements:");
		int count = ConsoleReader.readInt();
		int[] array = new int[count];
		for(int i=0;i<count;i++){
			System.out.println("Enter "+i+" element:");
			array[i] = ConsoleReader.readInt();
		}
		System.out.println("Before sorting:");
		System.out.println(ArrayUtil.print(array));
		ArrayUtil.quickSort(array, 0, array.length-1);
		System.out.println("After sorting:");
		System.out.println(ArrayUtil.print(array));
	}

}