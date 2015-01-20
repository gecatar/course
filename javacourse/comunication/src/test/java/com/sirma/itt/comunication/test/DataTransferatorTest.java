package com.sirma.itt.comunication.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;

public class DataTransferatorTest {

	private DataTransferer transferer;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ByteArrayOutputStream byteOutputStream;
	private ByteArrayInputStream byteInputStream;

	@Before
	public void setUp() throws Exception {
		byteOutputStream = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(byteOutputStream);
		ByteArrayOutputStream tempByteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream tempObjectOutputStream = new ObjectOutputStream(
				tempByteOutputStream);
		tempObjectOutputStream.writeObject(new Mesage("Sender", "Receiver",
				"Text"));
		tempObjectOutputStream.close();
		oos = new ObjectOutputStream(byteOutputStream);
		ois = new ObjectInputStream(new ByteArrayInputStream(
				tempByteOutputStream.toByteArray()));
		transferer = new DataTransferer(null, null, oos, ois);
	}

	/**
	 * Test reading message function.
	 */
	@Test
	public void readMesageTest() throws ClassNotFoundException, IOException {
		Mesage mesage = transferer.readMessage();
		Assert.assertTrue(mesage.sender.equals("Sender"));
		Assert.assertTrue(mesage.receiver.equals("Receiver"));
		Assert.assertTrue(mesage.text.equals("Text"));
	}
}
