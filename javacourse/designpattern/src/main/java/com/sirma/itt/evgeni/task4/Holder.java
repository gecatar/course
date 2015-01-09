package com.sirma.itt.evgeni.task4;

/**
 * Store elements for future using.
 * 
 * @author Evgeni Stefanov
 *
 */
public class Holder {

	private boolean inUse = false;
	private Object object;

	/**
	 * Create new holder.
	 */
	public Holder(Object object) {
		this.object = object;
	}

	/**
	 * Set in use.
	 */
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	/**
	 * Say is object in use.
	 */
	public boolean isInUse() {
		return inUse;
	}

	/**
	 * Return acquired object.
	 */
	public Object getObject() {
		return object;
	}
}
