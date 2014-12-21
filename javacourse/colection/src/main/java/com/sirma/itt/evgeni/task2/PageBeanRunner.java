package com.sirma.itt.evgeni.task2;

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

		Object[] obj = new Object[10];
		for (int i = 0; i < 10; i++) {
			obj[i] = new Integer(i);
		}
		PageBean pageBean = new PageBean(obj, 3);
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