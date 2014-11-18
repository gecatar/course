package com.sirma.itt.evgeni.task6;

import java.io.IOException;

import com.sirma.itt.evgeni.util.DirectoryBrowser;

/**
 * Serialize object. User define path.
 * @author Evgeni Stefanov
 *
 */
public class SerializerRunner {

	public static void main(String[] args) {
		
		System.out.println("Choose path to save object:");
		DataClass dataClass = new DataClass();
		try {
			Serializer.saveObject(DirectoryBrowser.chooseFile(), dataClass);
			dataClass = Serializer.getObject(DirectoryBrowser.chooseFile());
			System.out.println("index =" + dataClass.getIndex());
			System.out.println("count =" + dataClass.getCount());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while manipulating object!!!");
		}
		
	}

}
