package com.sirma.itt.evgeni.comunicator.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;

public class DataTransferatorTest {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	DataTransferator transferator;

	@Before
	public void setUp() throws Exception {
		ByteArrayOutputStream tempByteStream = new ByteArrayOutputStream();
		ObjectOutputStream temp = new ObjectOutputStream(tempByteStream);
		temp.writeObject(new Mesage("Sender", "Receiver", "Text"));
		oos = new ObjectOutputStream(temp);
		ois = new ObjectInputStream(new ByteArrayInputStream(
				tempByteStream.toByteArray()));
		transferator = new DataTransferator(null, null, oos, ois);
	}

	/**
	 * Test reading message function.
	 */
	@Test
	public void readMesageTest() throws ClassNotFoundException, IOException {
		Mesage mesage = transferator.readMessage();
		Assert.assertTrue(mesage.sender.equals("Sender"));
		Assert.assertTrue(mesage.receiver.equals("Receiver"));
		Assert.assertTrue(mesage.text.equals("Text"));
	}

	/**
	 * Test writing message function.
	 */
	@Test
	public void writeMessageTest() throws IOException {
		ByteArrayOutputStream temp = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(temp);
		transferator.sendData(new Mesage("Sender", "Receiver", "Text"));
		temp.toByteArray();

	}

}
