package com.sirma.itt.evgeni.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamReader {

	/**
	 * Return content of stream as text.
	 * @param inputStream will be read from.
	 * @return String whit content of stream.
	 */
	public String getText(InputStream inputStream) {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
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
			closeStream(inputStream, inputStreamReader);
		}
		stringBuilder.reverse();
		return stringBuilder.toString();
	}

	/**
	 * Closing streams.
	 * @param inputStream
	 * @param inputStreamReader
	 */
	private void closeStream(InputStream inputStream,
			InputStreamReader inputStreamReader) {
		try {
			inputStream.close();
			inputStreamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
