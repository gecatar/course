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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
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
			e.printStackTrace();
			return false;
		}
	}
}
