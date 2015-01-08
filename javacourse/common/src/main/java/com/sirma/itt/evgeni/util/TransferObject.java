package com.sirma.itt.evgeni.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Transfer user defined number of bytes between two streams.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TransferObject implements AutoCloseable {

	private static final Logger LOGGER = Logger.getLogger(TransferObject.class
			.getName());

	private InputStream ist = null;
	private OutputStream ost = null;

	public TransferObject(InputStream ist, OutputStream ost) {
		this.ist = ist;
		this.ost = ost;
	}

	/**
	 * Transfer data between two streams.
	 * 
	 * @param numberOfBytes
	 *            user defined number of bytes. Thath will be transfered.
	 * @param offset
	 *            number of bytes that will be missed.
	 * @return number of transfered bytes.
	 */
	public int transfer(int numberOfBytes, int offset) {
		int transfered;
		try {
			ist.skip(offset);
			byte[] buff = new byte[numberOfBytes];
			transfered = ist.read(buff, 0, numberOfBytes);
			ost.write(buff, 0, transfered);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error while transfering data", e);
			transfered = -1;
		}
		return transfered;
	}

	/**
	 * Transfer bytes between two streams.
	 * 
	 * @param numberOfBytes
	 * @return
	 */
	public int transfer(int numberOfBytes) {
		int transfered;
		try {
			byte[] buff = new byte[numberOfBytes];
			transfered = ist.read(buff, 0, numberOfBytes);
			if (transfered != -1) {
				ost.write(buff, 0, transfered);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error while transfering data", e);
			transfered = -1;
		}
		return transfered;
	}

	public void close() {
		try {
			if (ist != null) {
				ist.close();
				ist = null;
			}
			if (ost != null) {
				ost.close();
				ost = null;
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error when closing sockets", e);
		}
	}
}
