package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ReflectionUtil;

/**
 * Create new instance. Name represent name of class that will be created.
 * @author Evgeni Stefanov
 *
 */
public class CreatorRunner {

	public static void main(String[] args) {
		String name = "com.sirma.itt.javatrain.evgeni.reflection.TestClass";
		ReflectionUtil.CreateFromName(name);

	}

}
