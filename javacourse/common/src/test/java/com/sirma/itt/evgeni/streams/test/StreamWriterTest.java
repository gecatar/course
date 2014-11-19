package com.sirma.itt.evgeni.streams.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.sirma.itt.evgeni.streams.StreamWriter;

public class StreamWriterTest {

	@Test
	public void test() {
		StreamWriter streamWriter = new StreamWriter();
		ByteArrayOutputStream ost = new ByteArrayOutputStream();
		streamWriter.setStream(ost);
		streamWriter.write("test test 1 2 3");
		streamWriter.closeStreams();
		assertEquals(ost.toString(), "test test 1 2 3");
	}

}
