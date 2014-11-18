package com.sirma.itt.evgeni.test.task2;

import org.junit.Test;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class ReadIntervalExceptionTest {

//	@Test(expected=IllegalArgumentException.class)
	public void test() {
		System.out.write(120);
		ConsoleReader.readIntInterval(0, 100);
	}
}