package com.sirma.itt.evgeni.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Write Object to passed Stream.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ObjectWriter {

	OutputStream outputStream;
	ObjectOutputStream objectOutputStream;

	/**
	 * Write object to stream.
	 * 
	 * @param outputStream
	 * @param object
	 *            that will be rited to stream.
	 * @return true if writing is successful.
	 */
	public boolean writeObject(OutputStream outputStream, Object object) {
		try {
			if (setStream(outputStream)) {
				objectOutputStream.writeObject(object);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream();
		}
		return false;
	}

	/**
	 * Create ObjectOutputStream.
	 * 
	 * @param outputStream
	 * @return true if operation is successful.
	 */
	private boolean setStream(OutputStream outputStream) {
		if (outputStream != null) {
			try {
				this.outputStream = outputStream;
				objectOutputStream = new ObjectOutputStream(outputStream);
				return true;
			} catch (IOException e) {
				closeStream();
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Close streams.
	 */
	private void closeStream() {
		try {
			if (outputStream != null) {
				outputStream.close();
				outputStream = null;
			}
			if (objectOutputStream != null) {
				objectOutputStream.close();
				objectOutputStream = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}