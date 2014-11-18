package com.sirma.itt.evgeni.task2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class FileWriter {
	/**
	 * Save user input while user enter only '.'.
	 * 
	 * @param path
	 *            file that will be saved.
	 * @throws IOException
	 */
	public void write(Path path) throws IOException {

		FileOutputStream ost = null;
		OutputStreamWriter osw = null;
		try {
			ost = new FileOutputStream(path.toString());
			osw = new OutputStreamWriter(ost);
			System.out.println("Enter string:");
			System.out.println("Type '.' to stop writing!!!");
			boolean stop = false;
			while (!stop) {
				String temp = ConsoleReader.readLine();
				if (temp.matches(".")) {
					stop = true;
				} else {
					osw.write(temp);
				}
			}
			osw.flush();
			ost.flush();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!!!");
		} finally {
			ost.close();
		}

	}

}
