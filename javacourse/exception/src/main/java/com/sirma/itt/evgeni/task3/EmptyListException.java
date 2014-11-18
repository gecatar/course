package com.sirma.itt.evgeni.task3;


/**
 * Custom Exception for alerting that user wont manipulate empty list.
 * @author Evgeni Stefanov
 *
 */
public class EmptyListException extends Exception{
	public EmptyListException(String message) {
		super(message);
	}
}
