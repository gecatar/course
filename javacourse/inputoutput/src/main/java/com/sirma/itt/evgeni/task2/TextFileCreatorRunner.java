package com.sirma.itt.evgeni.task2;

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
	 */
	public static void main(String[] args) {
		TextFileCreator textFileCreator = new TextFileCreator();
		textFileCreator.saveText(DirectoryBrowser.chooseFile());
	}
}