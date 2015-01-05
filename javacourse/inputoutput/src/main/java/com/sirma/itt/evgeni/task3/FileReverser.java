package com.sirma.itt.evgeni.task3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.task2.TextFileCreator;

/**
 * Extract content of file as text, reverse it and save it again.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class FileReverser {

	private static final Logger LOGGER = Logger.getLogger(TextFileCreator.class
			.getName());

	/**
	 * Reverse file.
	 */
	public boolean reverseFile(String path) {
		try {
			File file = new File(path);
			saveText(file, reverseText(getText(file)));
			return true;
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error when reversing text file!!!", e);
			return false;
		}
	}

	/**
	 * Reverse given text.
	 */
	private String reverseText(String text) {
		return new StringBuilder().append(text).reverse().toString();
	}

	/**
	 * Save text to file.
	 */
	private void saveText(File file, String text) throws IOException {
		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			osw.write(text);
		}
	}

	/**
	 * Extract text from file.
	 */
	private String getText(File file) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		try (InputStreamReader inputReader = new InputStreamReader(
				new BufferedInputStream(new FileInputStream(file)))) {
			int readed = 0;
			char[] buffer = new char[20];
			while (readed != -1) {
				stringBuilder.append(buffer, 0, readed);
				readed = inputReader.read(buffer);
			}
		}
		return stringBuilder.toString();
	}
}
