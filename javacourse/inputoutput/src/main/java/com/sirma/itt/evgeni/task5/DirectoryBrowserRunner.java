package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * List user defined directory.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DirectoryBrowserRunner {

	/**
	 * List content on directory or display message if path is on file.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DirectoryBrowser directoryBrowser = new DirectoryBrowser();
		System.out.println("Enter path:");
		String path = ConsoleReader.readString();
		directoryBrowser.listContent(path);
	}

}
