package com.sirma.itt.evgeni.util.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.sirma.itt.evgeni.util.TransferObject;

/**
 * Check correct transferring on data between two streams.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TransferObjectTest {

	/**
	 * Create two streams and check correct transferring on data between them.
	 */
	@Test
	public void transferTest() {

		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(
				new byte[] { 1, 2, 3, 4, 5, 6, 7 });
		TransferObject transverObject = new TransferObject(byteInputStream,
				byteOutputStream);

		transverObject.transfer(3);
		assertTrue(byteOutputStream.size() == 3);
		transverObject.transfer(1);
		assertTrue(byteOutputStream.size() == 4);
		transverObject.transfer(10);
		assertTrue(byteOutputStream.size() == 7);

	}
	
	/**
	 * Create two streams and check correct transferring on data between them.
	 */
	@Test
	public void offsetTransferTest() {
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(
				new byte[] { 1, 2, 3, 4, 5, 6, 7 });
		TransferObject transverObject = new TransferObject(byteInputStream,
				byteOutputStream);
		transverObject.transfer(10, 4);
		assertTrue(byteOutputStream.size() == 3);
	}
}
