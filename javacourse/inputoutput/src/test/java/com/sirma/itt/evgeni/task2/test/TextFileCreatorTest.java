package com.sirma.itt.evgeni.task2.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.interfaces.UserInputReader;
import com.sirma.itt.evgeni.task2.TextFileCreator;
import com.sirma.itt.evgeni.task3.FileReverser;

public class TextFileCreatorTest {

	TextFileCreator creator;
	FileReverser reverser;
	
	/**
	 * Create reverser object to read data from file.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		UserInputReader reader = new Reader();
		creator = new TextFileCreator(reader);
		reverser = new FileReverser();
	}
	

	/**
	 * Force create file to throw exception.
	 * @throws FileNotFoundException
	 */
	@Test(expected=FileNotFoundException.class)
	public void createFileTest() throws FileNotFoundException {
		creator.createFile("");
	}
	
	/**
	 * Save data to file and check its content.
	 * @throws IOException
	 */
	@Test
	public void createFileTestSecond() throws IOException{
		creator.createFile("C:\\eclipse\\test.txt");
		assertEquals("45678910",reverser.getText("C:\\eclipse\\test.txt"));
	}
}
