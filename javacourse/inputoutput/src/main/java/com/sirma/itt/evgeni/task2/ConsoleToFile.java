package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.streams.FileStreamExtractor;
import com.sirma.itt.evgeni.streams.StreamWriter;
import com.sirma.itt.evgeni.util.DirectoryBrowser;

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
		streamWriter.write(FileStreamExtractor.getOutputStream(DirectoryBrowser
				.chooseFile()));
	}

}