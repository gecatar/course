package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.DataClass;
import com.sirma.itt.evgeni.task6.Serializer;

public class SerializerTest {

	//@Test
	public void test() throws IOException {
		Serializer serializer = new Serializer();
		Path path = Paths.get("c:\\users\\root\\testserial");
		serializer.getObject(path);
		assertTrue(serializer.getObject(path)!=null);
		path = Paths.get("c:\\users\\root\\testserialbad");
		assertTrue(serializer.getObject(path)==null);
		
	}
	@Test(expected=FileNotFoundException.class)
	public void exceptionTest() throws IOException{
		Serializer serializer = new Serializer();
		Path path = Paths.get("c:\\users\\roo%$^$%t\\testserial");
		serializer.getObject(path);
	}

}
