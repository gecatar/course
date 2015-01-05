package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;

/**
 * Separate massive whit objects into Page object.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PageBeanRunner {

	/**
	 * Allow creating collections whit objects. User define Page size.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> objects = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			objects.add(new Integer(i));
		}
		PageBean pageBean = new PageBean(objects, 3);
		System.out.println(pageBean.getNext());
		System.out.println(pageBean.getNext());
		System.out.println(pageBean.getNext());
		System.out.println(pageBean.getNext());

		System.out.println(pageBean.getPrevious());
		System.out.println(pageBean.getPrevious());
		System.out.println(pageBean.getPrevious());
		System.out.println(pageBean.getPrevious());

		System.out.println(pageBean);
	}

}