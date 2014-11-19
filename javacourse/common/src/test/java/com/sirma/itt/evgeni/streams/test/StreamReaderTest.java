package com.sirma.itt.evgeni.streams.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.sirma.itt.evgeni.streams.StreamReader;

/**
 * Create test Stream and compare result after reading from it.
 * @author Evgeni Stefanov
 *
 */
public class StreamReaderTest {

	/**
	 * Create stream and read from it.
	 */
	@Test
	public void test() {

		StreamReader streamReader = new StreamReader();
		String testString = new String("ytrewq");
		ByteArrayInputStream byteStream = new ByteArrayInputStream(testString.getBytes());
		streamReader.setStream(byteStream);
		assertEquals(streamReader.getText(), testString);
		
	}
}
