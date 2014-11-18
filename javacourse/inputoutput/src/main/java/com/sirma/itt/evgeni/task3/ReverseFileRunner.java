package com.sirma.itt.evgeni.task3;

import java.nio.file.Path;

import com.sirma.itt.evgeni.streams.FileStreamExtractor;
import com.sirma.itt.evgeni.streams.StreamReader;
import com.sirma.itt.evgeni.streams.StreamWriter;
import com.sirma.itt.evgeni.util.DirectoryBrowser;

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
		StreamReader streamReader = new StreamReader();
		StreamWriter streamWriter = new StreamWriter();
		Path path = DirectoryBrowser.chooseFile();
		String buffer = streamReader.getText(FileStreamExtractor
				.getInputStream(path));
		streamWriter.write(FileStreamExtractor.getOutputStream(path));
		System.out.println(buffer);
	}
}
