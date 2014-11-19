package com.sirma.itt.evgeni.task4;

/**
 * Helper class for synchronizing thread.
 * @author Evgeni Stefanov
 *
 */
public class Synchronizator {

	boolean syncState;
	
	/**
	 * Determine is thread ready for counting.
	 * @param syncOn
	 * @return
	 */
	public boolean isSyncReady(boolean syncOn){
		if(syncOn==syncState){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Lock thread.
	 */
	public synchronized void lock(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Change sync state.
	 * And unlock locked thread.
	 */
	public synchronized void changeState() {
		if (syncState == true) {
			syncState = false;
		} else {
			syncState = true;
		}
		notifyAll();
	}
}