package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Read content on text file. Reverse it, and save it again.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ReverseFileRunner {

	/**
	 * Read, reverse and save content.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FileReverser fileReverser = new FileReverser();
		System.out.println("Enter path on file that will be reversed:");
		String path = ConsoleReader.readString();
		fileReverser.reverseFile(path);
	}
}
