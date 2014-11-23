package com.sirma.itt.evgeni.task2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create file that contain text readed from console.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextFileCreator {

	/**
	 * Save user input to file. Saving stop when '.' is entered.
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean createFile(String path) throws FileNotFoundException {

		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			System.out.println("Type text: Enter '.' to stop.");
			String text = new String();
			while (!text.matches(".")) {
				text = getLine();
				osw.write(text);
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
	public String getLine() {
		return ConsoleReader.readLine();
	}

}
