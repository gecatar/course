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
		StreamWriter streamWriter = new StreamWriter();
		StreamReader streamReader = new StreamReader();
		System.out.println("Choose file.");
		Path path = DirectoryBrowser.chooseFile();
		streamReader.setStream(FileStreamExtractor.getInputStream(path));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(streamReader.getText());
		stringBuilder.reverse();
		streamWriter.setStream(FileStreamExtractor.getOutputStream(path));
		streamWriter.write(stringBuilder.toString());
		System.out.println(stringBuilder);
		streamWriter.closeStreams();
	}
}
