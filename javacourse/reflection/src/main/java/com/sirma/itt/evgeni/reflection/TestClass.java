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
	
	
	public String getString() {
		return string;
	}

	Rectangle rect = new Rectangle();
	StringBuilder stb = new StringBuilder();

	private String string = new String("Private String!!!!");
	
	public TestClass(){
		
	}
	/**
	 * Private example.
	 */
	private void testPrivate() {
		System.out.println("Private method. Executed.");
	}
	
	public int compare(Object arg0, Object arg1) {
		return 0;
	}
}

