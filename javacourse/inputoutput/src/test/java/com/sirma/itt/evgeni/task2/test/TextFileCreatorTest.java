package com.sirma.itt.evgeni.task2.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

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
	 * 
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
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void createFileTest() {
		assertFalse(creator.createFile(""));
	}

	/**
	 * Save data to file and check its content.
	 */
	@Test
	public void createFileTestSecond() throws IOException, URISyntaxException {
		File file = new File(getClass().getResource("/test.txt").toURI());
		creator.createFile(file.getPath());
		assertArrayEquals("45678910".getBytes(),
				Files.readAllBytes(file.toPath()));
	}
}
