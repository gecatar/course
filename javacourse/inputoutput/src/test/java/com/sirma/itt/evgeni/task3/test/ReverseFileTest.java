package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertArrayEquals;

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
	public void reverseFileTest() throws IOException, URISyntaxException {
		File file = new File(getClass().getResource("/reversertest.txt")
				.toURI());
		byte[] fileBytes = Files.readAllBytes(file.toPath());
		fileReverser.reverseFile(file.getPath());
		fileReverser.reverseFile(file.getPath());
		assertArrayEquals(fileBytes, Files.readAllBytes(file.toPath()));

	}
}
