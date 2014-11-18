package com.sirma.itt.evgeni.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;

/**
 * Create Buffered streams extracted from files.
 * @author Evgeni Stefanov
 *
 */
public class FileStreamExtractor {

	/**
	 * Create InputStream from FileInputStream.
	 * @param path the path on file which streams will be extracted.
	 * @return extracted stream.
	 */
	public static FileInputStream getInputStream(Path path){
		try {
			return new FileInputStream(path.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Cant acces file!!!!!");
			return null;
		}
	}
	
	/**
	 * Create OutputStream from FileOutputStream.
	 * @param path the path on file which streams will be extracted.
	 * @return extracted stream.
	 */
	public static FileOutputStream getOutputStream(Path path){
		try {
			return new FileOutputStream(path.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Cant acces file!!!!!");
			return null;
		}
	}
}
