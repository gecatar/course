package com.sirma.itt.evgeni.streams.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.sirma.itt.evgeni.streams.StreamReader;

public class StreamReaderTest {

	@Test
	public void test() {

		StreamReader streamReader = new StreamReader();
		String testString = new String("ytrewq");
		ByteArrayInputStream byteStream = new ByteArrayInputStream(testString.getBytes());
		assertTrue(streamReader.getText(byteStream).equals("qwerty"));
	}
}
