package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import com.sirma.itt.evgeni.serializable.ObjectReader;
import com.sirma.itt.evgeni.serializable.ObjectWriter;
import com.sirma.itt.evgeni.streams.FileStreamExtractor;
import com.sirma.itt.evgeni.util.DirectoryBrowser;

/**
 * Serialize object. User define path.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class SerializerRunner {

	public static void main(String[] args) {

		DataClass dataClass = new DataClass();
		System.out.println("Choose path to save object:");
		Path path = DirectoryBrowser.chooseFile();
		OutputStream outputStream = FileStreamExtractor.getOutputStream(path);
		if (outputStream != null) {
			new ObjectWriter().writeObject(outputStream, dataClass);

			DataClass test = (DataClass) new ObjectReader()
					.readObject(FileStreamExtractor.getInputStream(path));
			System.out.println(test.count);
		}
	}

}
