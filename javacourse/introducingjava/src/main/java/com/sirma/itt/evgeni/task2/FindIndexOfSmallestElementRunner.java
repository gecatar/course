package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ArrayUtil;
import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Call ArrayUtil class and find index of smallest element.
 * @author Evgeni Stefanov
 *
 */
public class FindIndexOfSmallestElementRunner {

	public static void main(String[] args) {
		System.out.println("Find element whit smallest value of  array.");
		System.out.println("Enter number of elements:");
		int count = ConsoleReader.readInt();
		int[] array = new int[count];
		for(int i=0;i<count;i++){
			System.out.println("Enter "+i+" element:");
			array[i] = ConsoleReader.readInt();
		}
		System.out.println("Index of smallest element is:"+ArrayUtil.getMinElement(array));
	}

}
