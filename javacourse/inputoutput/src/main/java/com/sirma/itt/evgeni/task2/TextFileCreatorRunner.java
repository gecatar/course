package com.sirma.itt.evgeni.task2;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.sirma.itt.evgeni.util.DirectoryBrowser;


/**
 * Read user input and save data to file. Saving stop when user type '.'.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextFileCreatorRunner {

	/**
	 * Save user input in user defined file.if (temp.matches("."))
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		TextFileCreator creator = new TextFileCreator();
		try {
			creator.createFile("C:\\eclipse\\test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}