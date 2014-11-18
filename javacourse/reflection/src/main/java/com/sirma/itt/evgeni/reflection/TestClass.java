package com.sirma.itt.evgeni.reflection;

import java.awt.Rectangle;
import java.util.Comparator;

/**
 * Reflection and Annotation example.
 * Sample class for demonstrating ClassReader and ClassSetter.
 * @author Evgeni Stefanov
 *
 */
public class TestClass implements Comparator{
	
	public int id = 0;
	private int count = 9;
	private int index = 8;
	private char ch;
	private long ln = 0;
	private short sh = 8;
	private Long lng = new Long(89798);
	
	
	public int getId() {
		return id;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getIndex() {
		return index;
	}
	
	public StringBuilder getStb() {
		return stb;
	}
	
	public String getString() {
		return string;
	}

	Rectangle rect = new Rectangle();
	StringBuilder stb = new StringBuilder();

	private String string = new String("Private String!!!!");
	
	public TestClass(){
		
	}
	/**
	 * Public example.
	 */
	public void testPublic() {
		System.out.println("Public method.");
	}

	/**
	 * Private example.
	 */
	private void testPrivate() {
		System.out.println("Private method. Executed.");
	}
	
	/**
	 * Summing two integer.
	 * @param add 
	 * @return sum of count and add.
	 */
	public int sum(int add) {
		return count + add;
	}

	public int compare(Object arg0, Object arg1) {
		return 0;
	}
}

