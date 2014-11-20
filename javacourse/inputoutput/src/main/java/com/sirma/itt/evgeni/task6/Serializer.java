package com.sirma.itt.evgeni.task6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

import com.sirma.itt.evgeni.task6.DataClass;

/**
 * Read and save objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Serializer {

	public static final String FILE_NOT_FOUND_EXCEPTION = "File not found!!!";
	
	/**
	 * Read objects from passed file.
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public DataClass getObject(Path path) throws FileNotFoundException {
		if (!path.toFile().exists()) {
			throw new FileNotFoundException(FILE_NOT_FOUND_EXCEPTION);
		}
		try {
			ObjectInputStream objectStream = null;
			try {
				objectStream = new ObjectInputStream(new BufferedInputStream(
						new FileInputStream(path.toString())));
				return (DataClass) objectStream.readObject();
			} finally {
				if (objectStream != null)
					objectStream.close();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Save object to file.
	 * 
	 * @param dataClass
	 * @param path
	 */
	public void saveObject(DataClass dataClass, Path path) {
		try {
			ObjectOutputStream outputStream = null;
			try {
				outputStream = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream(path.toString())));
				outputStream.writeObject(dataClass);
			} finally {
				outputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
