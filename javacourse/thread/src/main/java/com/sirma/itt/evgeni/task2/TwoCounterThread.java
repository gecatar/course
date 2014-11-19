package com.sirma.itt.evgeni.task2;

/**
 * Create two thread that work simultaneously.
 * @author Evgeni Stefanov
 *
 */
public class TwoCounterThread {

	public static void main(String[] args) {
		
		Counter firstCounter = new Counter(9);
		Counter secondCounter = new Counter(12);
		
		firstCounter.start();
		secondCounter.start();
	}

}