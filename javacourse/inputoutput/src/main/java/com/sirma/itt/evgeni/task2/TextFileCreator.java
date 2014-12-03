package com.sirma.itt.evgeni.task2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
	 * 
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean createFile(String path) throws FileNotFoundException {
		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			LOGGER.warning("Yeahhhh");
			System.out.println("Type text: Enter '.' to stop.");
			String text = new String();
			while (!text.contains(".")) {
				osw.write(text);
				text = getLine();
			}
			return true;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Read line from console.
	 * 
	 * @return
	 */
	private String getLine() {
		return reader.readLine();
	}

}
