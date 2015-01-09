package com.sirma.itt.evgeni.task4;

public class SyncThreadRunner {

	/**
	 * Start two thread that will work synchronized.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SyncCount firstCount = new SyncCount(5);
		SyncCount secondCount = new SyncCount(5);

		firstCount.start();
		secondCount.start();
	}

}