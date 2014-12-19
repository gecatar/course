package com.sirma.itt.evgeni.task2;

import java.io.FileNotFoundException;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.InputReader;

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
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		TextFileCreator textFileCreator = new TextFileCreator(new InputReader());
		System.out.println("Enter path to file:");
		textFileCreator.createFile(ConsoleReader.readString());
	}
}