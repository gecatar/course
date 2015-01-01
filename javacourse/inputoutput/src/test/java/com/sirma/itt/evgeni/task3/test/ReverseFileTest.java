package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.FileReverser;

public class ReverseFileTest {

	FileReverser fileReverser = new FileReverser();

	/**
	 * Check correct storing on data to file.
	 */
	@Test
	public void saveTextTest() throws IOException, URISyntaxException {
		String text = "123456";
		File file = new File(getClass().getResource("/test.txt").toURI());
		fileReverser.reverseFile(file.getPath());
		assertEquals(text.getBytes(), Files.readAllBytes(file.toPath()));
	}
}
