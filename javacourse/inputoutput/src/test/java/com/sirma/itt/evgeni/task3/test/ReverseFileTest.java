package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.FileReverser;

public class ReverseFileTest {

	FileReverser fileReverser = new FileReverser();
	// String path = "c:\\users\\root\\testreverse";
	String path = "C:\\eclipse\\test.txt";

	/**
	 * Check corect storing on data to file.
	 * @throws IOException
	 */
	@Test
	public void saveTextTest() throws IOException {
		String text = "123456";
		fileReverser.saveText(path, text);
		assertEquals("123456",fileReverser.getText("C:\\eclipse\\test.txt"));
	}

	/**
	 * Check correct reversing on file.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void reverseTextTest() throws FileNotFoundException, IOException {
		String text = "123456";
		fileReverser.saveText(path, text);
		String expectedText = "654321";
		fileReverser.reverseFile(path);
		String actualText = fileReverser.getText(path);
		assertEquals(expectedText, actualText);
	}

	@Test
	public void readTextTest() {
		String text = "654321";
	}

}
