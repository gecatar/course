package com.sirma.itt.evgeni.task3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

/**
 * Extract content of file as text, reverse it and save it again.
 * @author Evgeni Stefanov
 *
 */
public class FileReverser {
	
	/**
	 * Reverse content of given file.
	 * @param path the path of file.
	 */
	public void reverseFile(Path path){
		String text = getText(path);
		saveText(reverseText(text), path);
	}
	
	/**
	 * Reverse given text.
	 * @param text the text that will be reversed.
	 * @return reversed text.
	 */
	public String reverseText(String text){
		return new StringBuilder().append(text).reverse().toString();
	}

	/**
	 * Save text to file.
	 * @param text
	 * @param path
	 * @return
	 */
	public boolean saveText(String text, Path path) {
		OutputStreamWriter outputWriter = null;
		try {
			outputWriter = new OutputStreamWriter(new BufferedOutputStream(
					new FileOutputStream(path.toString())));
			try {
				outputWriter.write(text);
				return true;
			} finally {
				outputWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Extract text from file.
	 * @param path
	 * @return
	 */
	public String getText(Path path) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			InputStreamReader inputReader = new InputStreamReader(
					new BufferedInputStream(
							new FileInputStream(path.toString())));
			try {
				int readed = 0;
				char[] buffer = new char[20];
				while (readed != -1) {
					stringBuilder.append(buffer, 0, readed);
					readed = inputReader.read(buffer);
				}
			} finally {
				inputReader.close();
			}
		} catch (IOException e) {
		}
		return stringBuilder.toString();
	}
}
