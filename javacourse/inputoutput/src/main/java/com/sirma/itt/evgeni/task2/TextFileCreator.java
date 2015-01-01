package com.sirma.itt.evgeni.task2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.interfaces.UserInputReader;

/**
 * Create file that contain text readed from console.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextFileCreator {

	private static final Logger LOGGER = Logger.getLogger(TextFileCreator.class
			.getName());
	private final UserInputReader reader;

	public TextFileCreator(UserInputReader reader) {
		this.reader = reader;
	}

	/**
	 * Save user input to file. Saving stop when '.' is entered.
	 */
	public boolean createFile(String path) {
		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			System.out.println("Type text: Enter '.' to stop.");
			String text = new String();
			while (!text.equals(".")) {
				osw.write(text);
				text = reader.readLine();
			}
			return true;
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error when creating text file!!!", e);
			return false;
		}
	}
}
