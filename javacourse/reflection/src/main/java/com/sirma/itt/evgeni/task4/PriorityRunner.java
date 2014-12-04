package com.sirma.itt.evgeni.task4;

import java.util.Arrays;

import com.sirma.itt.evgeni.reflection.PriorityFirst;
import com.sirma.itt.evgeni.reflection.PrioritySecond;
import com.sirma.itt.evgeni.reflection.PriorityThird;
import com.sirma.itt.evgeni.reflection.TestClass;

/**
 * Create Array whit elements that will be sorted by priority. If class contain
 * method whit highest priority from method from other class it must be executed
 * first.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PriorityRunner {

	/**
	 * Create list whit objects. After this sort list using comparator. Class
	 * which contain method whit highest priority must be on first place.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		TestClass[] list = new TestClass[3];
		list[0] = new PriorityThird();
		list[1] = new PrioritySecond();
		list[2] = new PriorityFirst();
		System.out.println(list);
		Arrays.sort(list, new AnotationComparator());
		System.out.println(list);

	}
}