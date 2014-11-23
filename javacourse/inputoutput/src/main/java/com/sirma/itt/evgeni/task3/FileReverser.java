package com.sirma.itt.evgeni.task3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

/**
 * Extract content of file as text, reverse it and save it again.
 * 
 * @author Evgeni Stefanov
 *
 */
public class FileReverser {

	/**
	 * @throws FileNotFoundException 
	 * Reverse content of given file.
	 * 
	 * @param path
	 *            the path of file.
	 * @throws  
	 */
	public boolean reverseFile(String path) throws FileNotFoundException {
		try {
			saveText(path, reverseText(getText(path)));
			return true;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
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
	public String reverseText(String text) {
		return new StringBuilder().append(text).reverse().toString();
	}

	/**
	 * Save text to file.
	 * @throws IOException
	 * @throws FileNotFoundException
	 *             Save text to file.
	 * 
	 * @param text
	 * @param path
	 * @return
	 * @throws
	 */
	public boolean saveText(String path, String text)
			throws FileNotFoundException, IOException {
		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			osw.write(text);
			return true;
		}
	}

	/**
	 * Extract text from file.
	 * @param path the path to file that will be readed from.
	 * @return test as String.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getText(String path) throws FileNotFoundException,
			IOException {
		StringBuilder stringBuilder = new StringBuilder();
		try (InputStreamReader inputReader = new InputStreamReader(
				new BufferedInputStream(new FileInputStream(path)))) {
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
