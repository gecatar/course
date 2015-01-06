package com.sirma.itt.evgeni.task4;

/**
 * Store elements for future using. If object is released inUse is false.
 * 
 * @author Evgeni Stefanov
 *
 */
public class Holder {

	private boolean inUse = false;
	private Object object;

	/**
	 * Create new holder.
	 * 
	 * @param object
	 */
	public Holder(Object object) {
		this.object = object;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	/**
	 * Say is object in use.
	 * 
	 * @return true if object is in use.
	 */
	public boolean isInUse() {
		return inUse;
	}

	/**
	 * Return acquired object.
	 * 
	 * @return instance to stored object.
	 */
	public Object getObject() {
		return object;
	}
}
