package com.sirma.itt.evgeni.task2;

/**
 * Counter thread.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Counter extends Thread {

	private int count;
	private static boolean stop;

	/**
	 * Tell on threads to stop execution.
	 * 
	 * @param stop
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * Get value on count.
	 * 
	 * @param count
	 */
	public Counter(int count) {
		this.count = count;
	}

	/**
	 * Decrement count.
	 */
	public void decrmentCount() {
		count--;
	}

	@Override
	public void run() {
		while (!stop && count > 0) {
			try {
				sleep(500);
				decrmentCount();
				System.out.println(this.getName() + " - Count is:" + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stop = true;
	}
}