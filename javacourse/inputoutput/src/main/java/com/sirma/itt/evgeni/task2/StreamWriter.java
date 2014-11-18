package com.sirma.itt.evgeni.task2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class StreamWriter {
	/**
	 * Save user input while user enter only '.'.
	 * 
	 * @param path
	 *            file that will be saved.
	 * @throws IOException
	 */
	public void write(OutputStream ost) throws IOException {

		OutputStreamWriter osw = null;
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

	}

}
