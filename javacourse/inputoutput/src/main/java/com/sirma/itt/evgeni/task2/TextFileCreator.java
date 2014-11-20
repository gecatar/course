package com.sirma.itt.evgeni.task2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create file that contain text readed from console.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextFileCreator {

	/**
	 * Save text to file.
	 * @param path
	 */
	public void saveText(Path path) {
		OutputStreamWriter outputStream = null;
		try {
			outputStream = getStream(path);
			String text = new String();
			System.out.println(path);
			System.out.println("Type text: Enter '.' to stop.");
			while (!text.matches(".")) {
				text = getLine();
				outputStream.write(text);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while saving to file!!!");
			e.printStackTrace();
		} finally {
			closeStream(outputStream);
		}
	}

	/**
	 * Read line from console.
	 * @return
	 */
	public String getLine() {
		return ConsoleReader.readLine();
	}

	/**
	 * Extract stream from file.
	 * @param path the path to file.
	 * @return stream extracted from file.
	 * @throws FileNotFoundException 
	 */
	public OutputStreamWriter getStream(Path path) throws FileNotFoundException {
		return new OutputStreamWriter(new BufferedOutputStream(
				new FileOutputStream(path.toString())));
	}

	/**
	 * Close stream.
	 * @param outputStream
	 */
	public void closeStream(OutputStreamWriter outputStream) {
		try {
			if (outputStream != null)
				outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
