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

	/**
	 * Test retrieving objects from file.
	 */
	@Test()
	public void getObjectTest() {

		try {
			Path path = Paths.get("c:\\users\\root\\testserial");
			assertNotNull("Object shouldn't be null",
					serializer.getObject(path));
			path = Paths.get("c:\\users\\roo%$^$%t\\testserial");
			serializer.getObject(path);
			fail("Grumna");
		} catch (Exception e) {
			assertTrue(e instanceof FileNotFoundException);
			assertEquals(Serializer.FILE_NOT_FOUND_EXCEPTION, e.getMessage());
		}

	}

	/**
	 * Test correct saving on objects in file.
	 */
	@Test
	public void saveObjectTest() {
		DataClass data = new DataClass();
		Path path = Paths.get("c:\\users\\root\\savetest");
		data.count = 0;
		serializer.saveObject(data, path);
		try {
			data = serializer.getObject(path);
			if (data.count != 0) {
				fail("Object not readed!!!");
			}
		} catch (FileNotFoundException e) {
			fail("File not founded!!!");
		}

	}
}
