package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.FileReverser;

public class ReverseFileTest {

	FileReverser fileReverser = new FileReverser();
	// String path = "c:\\users\\root\\testreverse";
	String path = "C:\\eclipse\\test.txt";

	/**
	 * Check correct storing on data to file.
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Test
	public void saveTextTest() throws IOException, URISyntaxException {
		String text = "123456";
		File file = new File(getClass().getResource("/test.txt").toURI());
		fileReverser.saveText(file, text);
		assertEquals("123456", fileReverser.getText(file));
	}

	/**
	 * Check correct reversing on file.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Test
	public void reverseTextTest() throws IOException, URISyntaxException {
		File file = new File(getClass().getResource("/test.txt").toURI());
		String text = "123456";
		fileReverser.saveText(file, text);
		String expectedText = "654321";
		fileReverser.reverseFile(file.getPath());
		String actualText = fileReverser.getText(file);
		assertEquals(expectedText, actualText);
	}
}
