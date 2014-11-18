package com.sirma.itt.evgeni.streams;

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
	public void write(OutputStream outputStream) {

		OutputStreamWriter outputStreamWriter = null;
		outputStreamWriter = new OutputStreamWriter(outputStream);
		System.out.println("Enter string:");
		System.out.println("Type '.' to stop writing!!!");
		try {
			boolean stop = false;
			while (!stop) {
				String temp = ConsoleReader.readLine();
				if (temp.matches(".")) {
					stop = true;
				} else {
					outputStreamWriter.write(temp);
					outputStream.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStreams(outputStream, outputStreamWriter);
		}
	}

	public void closeStreams(OutputStream outputStream,
			OutputStreamWriter outputStreamWriter) {
		try {
			outputStreamWriter.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
