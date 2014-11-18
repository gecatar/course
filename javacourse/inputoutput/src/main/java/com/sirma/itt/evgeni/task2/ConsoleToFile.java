package com.sirma.itt.evgeni.task2;

import java.io.IOException;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.DirectoryBrowser;

/**
 * Read user input and save data to file. Saving stop when user type '.'.
 * @author Evgeni Stefanov
 *
 */
public class ConsoleToFile {

	/**
	 * Save user input in user defined file.
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fileWriter = new FileWriter();
		try {
			fileWriter.write(DirectoryBrowser.chooseFile());
		} catch (IOException e) {
			System.out.println("Error while working whit file!!");
			e.printStackTrace();
		}
	}

}