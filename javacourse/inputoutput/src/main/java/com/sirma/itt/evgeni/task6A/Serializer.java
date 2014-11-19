package com.sirma.itt.evgeni.task6A;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.nio.file.Path;

import com.sirma.itt.evgeni.task6.DataClass;

public class Serializer {

	public DataClass getObject(Path path) {

		FileInputStream fileInputStream = getInputStream(path);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				fileInputStream);
		ObjectInputStream objectInputStream = getObjectInputStream(bufferedInputStream);
		return readFromStream();
	}

	private DataClass readFromStream() {
		return null;
	}

	private ObjectInputStream getObjectInputStream(
			BufferedInputStream bufferedInputStream) {
		
		return null;
	}

	private FileInputStream getInputStream(Path path) {
		try {
			return new FileInputStream(path.toString());
		} catch (FileNotFoundException e) {
			return null;
		}
	}
}
