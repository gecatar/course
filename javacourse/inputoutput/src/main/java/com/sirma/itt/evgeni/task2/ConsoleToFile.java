package com.sirma.itt.evgeni.task2;

import java.nio.file.Path;

import com.sirma.itt.evgeni.streams.FileStreamExtractor;
import com.sirma.itt.evgeni.streams.StreamReader;
import com.sirma.itt.evgeni.streams.StreamWriter;
import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.DirectoryBrowser;

/**
 * Read user input and save data to file. Saving stop when user type '.'.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConsoleToFile {

	/**
	 * Save user input in user defined file.if (temp.matches("."))
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StreamWriter streamWriter = new StreamWriter();
		StreamReader streamReader = new StreamReader();
		System.out.println("Choose file.");
		Path path = DirectoryBrowser.chooseFile();
		streamWriter.setStream(FileStreamExtractor.getOutputStream(path));
		System.out.println("Enter '.' to stop entering text.");
		String text = "";
		while (!text.matches(".")) {
			text = ConsoleReader.readLine();
			streamWriter.write(text);
		}
		streamWriter.closeStreams();
		streamReader.setStream(FileStreamExtractor.getInputStream(path));
		System.out.println(streamReader.getText());
	}
}