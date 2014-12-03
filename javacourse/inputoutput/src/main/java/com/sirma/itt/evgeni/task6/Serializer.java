package com.sirma.itt.evgeni.task6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.task2.TextFileCreator;

/**
 * Read and save objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Serializer {

	private static final Logger LOGGER = Logger.getLogger(TextFileCreator.class
			.getName());

	/**
	 * Read objects from passed file.
	 * 
	 * @param path
	 *            the path to file which will be read from.
	 * @return extracted object from file.
	 * @throws IOException
	 */
	public DataClass getObject(String path) {
		try (ObjectInputStream objectStream = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(path)))) {
			return (DataClass) objectStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.log(Level.SEVERE, "Error when getting object!!!", e);
			return null;
		}
	}

	/**
	 * Save object to file.
	 * 
	 * @param dataClass
	 *            the object that will be saved in file.
	 * @param path
	 *            the path to file.
	 */
	public boolean saveObject(DataClass dataClass, String path) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			outputStream.writeObject(dataClass);
			return true;
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error when saving object!!!", e);
			return false;
		}
	}
}
