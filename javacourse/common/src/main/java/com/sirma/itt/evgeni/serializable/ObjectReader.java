package com.sirma.itt.evgeni.serializable;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectReader {

	InputStream inputStream;
	ObjectInputStream objectInputStream;

	public Object readObject(InputStream inputStream) {
		try {
			if (setStream(inputStream)) {
				return objectInputStream.readObject();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream();
		}
		return null;
	}

	private boolean setStream(InputStream inputStream) {
		if (inputStream != null) {
			try {
				objectInputStream = new ObjectInputStream(inputStream);
				this.inputStream = inputStream;
				return true;
			} catch (IOException e) {
				closeStream();
				e.printStackTrace();
			}
		}
		return false;
	}

	private void closeStream() {
		try {
			inputStream.close();
			inputStream = null;
			objectInputStream.close();
			objectInputStream = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
