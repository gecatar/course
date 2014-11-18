package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.util.ReflectionUtil;

/**
 * Execute Private Reader Class that read private content from selected class.
 * @author Evgeni Stefanov
 *
 */
public class PrivateReaderRunner {

	public static void main(String[] args) {
		ReflectionUtil.readPrivate(new TestClass());
	}

}