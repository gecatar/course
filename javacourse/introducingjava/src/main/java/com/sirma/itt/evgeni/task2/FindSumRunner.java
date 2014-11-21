package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ArrayUtil;
import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Call ArrayUtil class and find sum of all element in array.
 * @author Evgeni Stefanov
 *
 */
public class FindSumRunner {

	public static void main(String[] args) {
		System.out.println("Find sum of all elements in array.");
		System.out.println("Enter number of elements:");
		int count = ConsoleReader.readInt();
		int[] array = new int[count];
		for(int i=0;i<count;i++){
			System.out.println("Enter "+i+" element:");
			array[i] = ConsoleReader.readInt();
		}
		System.out.println("Sum of elements is:"+ArrayUtil.sum(array));
	}

}
