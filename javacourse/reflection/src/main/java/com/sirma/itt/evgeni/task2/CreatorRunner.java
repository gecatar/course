package com.sirma.itt.evgeni.task2;

/**
 * Create new instance. Name represent name of class that will be created.
 * @author Evgeni Stefanov
 *
 */
public class CreatorRunner {

	/**
	 * Create class whit reflection.
	 * @param args
	 */
	public static void main(String[] args) {
		ClassCreator classCreator = new ClassCreator();
		String name = "com.sirma.itt.evgeni.reflection.TestClass";
		Object object = classCreator.createFromName(name);
		System.out.println(classCreator.listInterfaces(object));
		System.out.println(classCreator.getParrent(object));
	}

}
