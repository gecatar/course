package com.sirma.itt.evgeni.task6;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create new object save it to file.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class SerializerRunner {

	/**
	 * Save and read object from file.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Serializer serializer = new Serializer();
		DataClass data = new DataClass();
		System.out.println("Enter path to file:");
		String path = ConsoleReader.readString();
		serializer.saveObject(data, path);
		DataClass temp = serializer.getObject(path);
		if (temp != null) {
			System.out.println(temp.count);
		}
	}

}
