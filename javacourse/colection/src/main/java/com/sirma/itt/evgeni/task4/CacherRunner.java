package com.sirma.itt.evgeni.task4;

/**
 * Check cache behavior.
 * @author Evgeni Stefanov
 *
 */
public class CacherRunner {

	/**
	 * Add elements in cacher. User define size on cacher.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Create 10 objects and test cache functionality!!!");
		System.out.println("Enter size on cacher:");
		Cacher cacher = new Cacher(5);
		Object[] obj = new Object[10];
		
		for (int i = 0; i < 10; i++) {
			obj[i] = new Integer(i);
		}
		
		cacher.addElement(0, obj[0]);
		System.out.println(cacher);
		cacher.addElement(1, obj[1]);
		System.out.println(cacher);
		cacher.addElement(1, obj[1]);
		System.out.println(cacher);
		
		cacher.addElement(2, obj[2]);
		System.out.println(cacher);
		cacher.addElement(3, obj[3]);
		System.out.println(cacher);
		cacher.addElement(4, obj[4]);
		System.out.println(cacher);
		cacher.addElement(1, obj[1]);
		System.out.println(cacher);
		
		cacher.addElement(5, obj[5]);
		System.out.println(cacher);
		cacher.addElement(0, obj[0]);
		System.out.println(cacher);
		cacher.addElement(4, obj[4]);
		System.out.println(cacher);

	}

}
