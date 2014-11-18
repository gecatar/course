package com.sirma.itt.evgeni.task3;


/**
 * Save strings in massive. Execute two operations. Add element and remove
 * element. Elements are random strings whit user defined length.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Holder {

	public Holder(int count) {
		strings = new String[count];
	}

	String[] strings;
	int index = 0;

	/**
	 * Add element in massive. If massive is full throw index out of boundary
	 * exception. Print how many positions left.
	 */
	public boolean addElement(String element) {
		try {
			strings[index] = element;
			index++;
			System.out.println(strings.length - index + ":Position left!!!");
			return true;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("List is full!!!");
			return false;

		}
	}

	/**
	 * Remove element from massive. If massive is empty throw EmptyListException
	 * exception.
	 * 
	 * @throws EmptyListException
	 */
	public boolean remove() {
		try {
			index--;
			if (index < 0) {
				throw new EmptyListException("List is empty");
			}
			strings[index] = null;
			System.out.println(strings.length - index + ":Position left!!!");
			return true;
		} catch (EmptyListException e) {
			System.out.println("List is empty!!!");
			index++;
			return false;
		}
	}
}