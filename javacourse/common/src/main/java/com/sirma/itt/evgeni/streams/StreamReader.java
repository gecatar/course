package com.sirma.itt.evgeni.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamReader {

	InputStream inputStream;
	InputStreamReader inputStreamReader;

	/**
	 * Return content of stream as text.
	 * 
	 * @param inputStream
	 *            will be read from.
	 * @return String whit content of stream.
	 */
	public String getText() {

		StringBuilder stringBuilder = new StringBuilder();
		try {
			int readed = 0;
			char[] buffer = new char[20];
			while (readed != -1) {
				stringBuilder.append(buffer, 0, readed);
				readed = inputStreamReader.read(buffer);
			}
		} catch (IOException e) {
			System.out.println("Error whit stream...");
		} finally {
			closeStream();
		}
		return stringBuilder.toString();
	}

	/**
	 * Create InputStreamReader.
	 * 
	 * @param inputStream
	 * @return true if stream is set correctly.
	 */
	public boolean setStream(InputStream inputStream) {
		if (inputStream != null) {
			this.inputStream = inputStream;
			inputStreamReader = new InputStreamReader(inputStream);
			return true;
		}
		return false;
	}

	/**
	 * Closing streams.
	 * 
	 * @param inputStream
	 * @param inputStreamReader
	 */
	private void closeStream() {
		try {
			if (inputStream != null) {
				inputStream.close();
				inputStream = null;
			}
			if (inputStreamReader != null) {
				inputStreamReader.close();
				inputStreamReader = null;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
