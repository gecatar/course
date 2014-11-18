package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.streams.StreamReader;
import com.sirma.itt.evgeni.util.DirectoryBrowser;
import com.sirma.itt.evgeni.util.FileStreamExtractor;

/**
 * Read content on text file. Reverse it, and save it again.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ReverseFileRunner {

	/**
	 * Read reverse and save content.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StreamReader streamReader = new StreamReader();
		String temp = streamReader.getText(FileStreamExtractor
				.getInputStream(DirectoryBrowser.chooseFile()));
		System.out.println(temp);
	}
}
