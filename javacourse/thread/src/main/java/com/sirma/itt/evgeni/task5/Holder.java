package com.sirma.itt.evgeni.task5;

import java.util.ArrayList;

/**
 * Save strings in massive. Execute two operations. Add element and remove
 * element. Elements are random strings whit user defined length.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Holder {

	public Holder(int count) {
		this.count = count;
	}

	ArrayList<String> strings = new ArrayList<String>();
	int count;

	/**
	 * Add element in massive. Generate random string whit given length. If
	 * massive is full throw index out of boundary exception. Print how many
	 * positions left.
	 */
	public synchronized void addElement(String string) {
		if (strings.size() < count) {
			strings.add(string);
			System.out.println("New element addet!!!");
			notifyAll();
		} else {
			System.out.println("List is full!!!");
			try {
				wait();
			} catch (InterruptedException e) {
			}
			addElement(string);
		}
	}

	/**
	 * Remove element from massive. If massive is empty throw index out of
	 * boundary exception. Print how much free space left.
	 */
	public synchronized void remove() {
		if(strings.size()>0){
			strings.remove(strings.size()-1);
			System.out.println("Last elements from list removed...");
			notifyAll();
		}else{
			try {
				wait();
			} catch (InterruptedException e) {
			}
			remove();
		}
		
	}
}