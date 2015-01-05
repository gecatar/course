package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.DataClass;
import com.sirma.itt.evgeni.task6.Serializer;

public class SerializerReadTest {

	Serializer serializer = new Serializer();
	DataClass data = new DataClass();

	/**
	 * Test retrieving objects from file.
	 * 
	 * @throws URISyntaxException
	 */
	@Test()
	public void getObjectTest() throws URISyntaxException {
		File file = new File(getClass().getResource("/testserial.txt").toURI());
		serializer.saveObject(data, file.getPath());
		assertNotNull(serializer.getObject(file.getPath()));
	}

	/**
	 * Test correct saving on objects in file.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void saveObjectTest() throws URISyntaxException {
		File file = new File(getClass().getResource("/createtest.txt").toURI());
		data.count = 0;
		serializer.saveObject(data, file.getPath());
		data = serializer.getObject(file.getPath());
		if (data.count != 0) {
			fail("Object not readed!!!");
		}

	}
}
