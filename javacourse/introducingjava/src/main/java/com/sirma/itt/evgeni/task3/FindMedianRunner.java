package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.util.ArrayUtil;
import com.sirma.itt.evgeni.util.ConsoleReader;


/**
 * Find median of Array.
 * @author Evgeni Stefanov
 *
 */
public class FindMedianRunner {

	/**
	 * Prompt user to enter value for array. Create array and find median.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Find median of  array.");
		System.out.println("Enter number of elements:");
		int count = ConsoleReader.readInt();
		int[] array = new int[count];
		for(int i=0;i<count;i++){
			System.out.println("Enter "+i+" element:");
			array[i] = ConsoleReader.readInt();
		}
		System.out.println("Index of median is:"+ArrayUtil.getMedian(array));
	}

}
