package com.sirma.itt.evgeni.task4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.sirma.itt.evgeni.util.TransferObject;

/**
 * Tests are placed in common project.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TransferObjectRunner {

	public static void main(String[] args) {
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(
				new byte[] { 1, 2, 3, 4, 5, 6, 7 });
		TransferObject transverObject = new TransferObject(byteInputStream,
				byteOutputStream);

		transverObject.transfer(7);
		transverObject.close();

	}

}
