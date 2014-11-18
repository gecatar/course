package com.sirma.itt.evgeni.task2;

import java.io.IOException;

import com.sirma.itt.evgeni.util.DirectoryBrowser;
import com.sirma.itt.evgeni.util.FileStreamExtractor;

/**
 * Read user input and save data to file. Saving stop when user type '.'.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConsoleToFile {

	/**
	 * Save user input in user defined file.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StreamWriter streamWriter = new StreamWriter();
		try {
			streamWriter.write(FileStreamExtractor
					.getOutputStream(DirectoryBrowser.chooseFile()));
		} catch (IOException e) {
			System.out.println("Error while working whit file!!");
			e.printStackTrace();
		}
	}

}