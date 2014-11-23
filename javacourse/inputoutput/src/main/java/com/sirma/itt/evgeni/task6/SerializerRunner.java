package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.DirectoryBrowser;

/**
 * Create new object save it to file.
 * @author Evgeni Stefanov
 *
 */
public class SerializerRunner {

	/**
	 * Save and read object from file.
	 * @param args
	 */
	public static void main(String[] args) {

		Serializer serializer = new Serializer();
		DataClass data = new DataClass();
		Path path = DirectoryBrowser.chooseFile();
		serializer.saveObject(data, path.toString());
		DataClass temp = serializer.getObject(path.toString());
		if (temp != null) {
			System.out.println(temp.count);
		}
	}

}
