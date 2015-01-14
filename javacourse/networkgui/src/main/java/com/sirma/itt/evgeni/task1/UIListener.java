package com.sirma.itt.evgeni.task1;

/**
 * Allow connection between action listener and controller object.
 * 
 * @author GecaTM
 *
 */
public interface UIListener {

	/**
	 * When operation button is pressed.
	 */
	public void operationPressed(String number, char operation);

	/**
	 * When equal button is pressed.
	 */
	public void calculatePresset(String number);

	/**
	 * When clear button is pressed.
	 */
	public void clearPreset();
}
