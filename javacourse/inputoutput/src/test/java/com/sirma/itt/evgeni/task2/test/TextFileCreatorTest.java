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
	
	@Before
	public void setUp() throws Exception {
		UserInputReader reader = new Reader();
		creator = new TextFileCreator(reader);
		reverser = new FileReverser();
	}
	

	@Test(expected=FileNotFoundException.class)
	public void createFileTest() throws FileNotFoundException {
		creator.createFile("");
	}
	
	@Test
	public void createFileTestSecond() throws IOException{
		creator.createFile("C:\\eclipse\\test.txt");
		assertEquals("45678910",reverser.getText("C:\\eclipse\\test.txt"));
	}
}
