package com.sirma.itt.evgeni.streams;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class StreamWriter {

	OutputStream outputStream;
	OutputStreamWriter outputStreamWriter;

	/**
	 * Save user input while user enter only '.'.
	 * 
	 * @param path
	 *            file that will be saved.
	 * @throws IOException
	 */
	public void write(String text) {
		try {
			outputStreamWriter.write(text);
			outputStreamWriter.flush();
		} catch (IOException e) {
			closeStreams();
			System.out.println("Error while saving to file!!!");
		}
	}

	public boolean setStream(OutputStream outputStream) {
		if (outputStream != null) {
			outputStreamWriter = new OutputStreamWriter(outputStream);
			return true;
		}
		return false;
	}

	public synchronized void closeStreams() {
		try {
			if (outputStreamWriter != null) {
				outputStreamWriter.close();
				outputStreamWriter = null;
			}
			if (outputStreamWriter != null) {
				outputStreamWriter.close();
				outputStreamWriter = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
