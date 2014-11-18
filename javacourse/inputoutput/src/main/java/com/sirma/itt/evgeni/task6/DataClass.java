package com.sirma.itt.evgeni.task6;

import java.io.Serializable;

/**
 * Example class from serialization tasks.
 * @author Evgeni Stefanov
 *
 */
public class DataClass implements Serializable {

	private int index =0;
	public int count = 34;
	private boolean isReady = false;
	public int getIndex() {
		return index;
	}
	/**
	 * Example method.
	 * @return count.
	 */
	public int getCount() {
		return count;
	}
	public boolean isReady() {
		return isReady;
	}
	
}
