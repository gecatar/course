package com.sirma.itt.evgeni.task3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	 * @throws FileNotFoundException
	 *             Reverse content of given file.
	 * 
	 * @param path
	 *            the path of file.
	 * @throws
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
	 * 
	 * @param text
	 *            the text that will be reversed.
	 * @return reversed text.
	 */
	private String reverseText(String text) {
		return new StringBuilder().append(text).reverse().toString();
	}

	/**
	 * Save text to file.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 *             Save text to file.
	 * 
	 * @param text
	 * @param path
	 * @return
	 * @throws
	 */
	private boolean saveText(File file, String text) throws IOException {
		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			osw.write(text);
			return true;
		}
	}

	/**
	 * Extract text from file.
	 * 
	 * @param path
	 *            the path to file that will be readed from.
	 * @return test as String.
	 * @throws FileNotFoundException
	 * @throws IOException
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
