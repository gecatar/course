package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import junit.framework.Assert;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.DataClass;
import com.sirma.itt.evgeni.task6.Serializer;

public class SerializerReadTest {

	Serializer serializer = new Serializer();
	String path = "c:\\users\\root\\testserial";
	DataClass data = new DataClass();
	/**
	 * Test retrieving objects from file.
	 */
	@Test()
	public void getObjectTest() {

		serializer.saveObject(data, path);
		assertNotNull(serializer.getObject(path));

	}

	/**
	 * Test correct saving on objects in file.
	 */
	@Test
	public void saveObjectTest() {
		
		data.count = 0;
		serializer.saveObject(data, path);
		data = serializer.getObject(path.toString());
		if (data.count != 0) {
			fail("Object not readed!!!");
		}

	}
}
