package com.sirma.itt.evgeni.comunication;

/**
 * Allow communication between Comunicator and other objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public interface ComunicatorListener {

	/**
	 * Change conection status.
	 * 
	 * @param conectionCondition
	 */
	public void setConectionStatus(String conectionCondition);

	/**
	 * When new message is received.
	 * 
	 * @param name
	 * @param text
	 */
	public void showMesage(String name, String text);

	/**
	 * Add user.
	 * 
	 * @param name
	 */
	public void addUser(String name);

	/**
	 * Remove user.
	 * 
	 * @param name
	 */
	public void removeUser(String name);
}
