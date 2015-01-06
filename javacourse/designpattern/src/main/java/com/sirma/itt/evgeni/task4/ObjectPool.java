package com.sirma.itt.evgeni.task4;

import java.util.ArrayList;

/**
 * Store object in pool. User can acquire and release objects.
 * 
 * @author Evgeni Stefanov
 *
 */
public class ObjectPool {

	ArrayList<Holder> pool;
	int count;

	public ObjectPool(int count) {
		this.count = count;
		pool = new ArrayList<Holder>();
	}

	/**
	 * Release objects.
	 * 
	 * @param testClass
	 *            object that will be released.
	 */
	public boolean release(Object object) {
		for (Holder holder : pool) {
			if (holder.getObject() == object) {
				holder.setInUse(false);
				return true;
			}
		}
		return false;
	}

	/**
	 * Provide user whit object.
	 * 
	 * @return acquired object.
	 */
	public Object aquire() {

		for (Holder holder : pool) {
			if (!holder.isInUse()) {
				holder.setInUse(true);
				return holder.getObject();
			}
		}
		if (pool.size() < count) {
			Holder temp = new Holder(new Object());
			temp.setInUse(true);
			pool.add(temp);
			return temp.getObject();
		}

		return null;
	}

}
