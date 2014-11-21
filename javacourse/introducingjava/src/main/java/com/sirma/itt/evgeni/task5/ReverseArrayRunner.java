package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.util.ArrayUtil;
import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Reverse all elements from array.
 * @author Evgeni Stefanov
 *
 */
public class ReverseArrayRunner {

	/**
	 * Prompt user to enter array. Reverse all elements.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Reverse array.");
		System.out.println("Enter number of elements:");
		int count = ConsoleReader.readInt();
		int[] array = new int[count];
		for(int i=0;i<count;i++){
			System.out.println("Enter "+i+" element:");
			array[i] = ConsoleReader.readInt();
		}
		System.out.println("Before reverse:");
		System.out.println(ArrayUtil.print(array));
		ArrayUtil.reverse(array);
		System.out.println("After reverse:");
		System.out.println(ArrayUtil.print(array));
		
	}

}