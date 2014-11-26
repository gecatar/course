package com.sirma.itt.evgeni.util;

/**
 * Exception class for alerting user that values are not in selected range.
 * @author Evgeni Stefanov
 *
 */
public class ValueNotInRangeException extends Exception {
	
	public ValueNotInRangeException(String mesage){
		super(mesage);
	}

}
