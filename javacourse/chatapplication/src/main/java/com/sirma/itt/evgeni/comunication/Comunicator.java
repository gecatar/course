package com.sirma.itt.evgeni.comunication;

/**
 * Allow connection between Client Server objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public interface Comunicator {

	/**
	 * Start conection.
	 * 
	 * @param ip
	 * @param port
	 */
	public void startConection(String ip, int port);

	/**
	 * Stop conection.
	 */
	public void stopConection();

	/**
	 * Add user.
	 * 
	 * @param transferator
	 */
	public void addUserSession(DataTransferator transferator);

	/**
	 * Remove user.
	 * 
	 * @param transferator
	 */
	public void closeUserSession(DataTransferator transferator);

	/**
	 * Stop connection attempts.
	 */
	public void closeConectorSession();

	/**
	 * Set name on comunicator.
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * Process message.
	 * 
	 * @param mesage
	 * @param transferator
	 */
	public void processMesage(Mesage mesage, DataTransferator transferator);

	/**
	 * Send message.
	 * 
	 * @param name
	 * @param text
	 */
	public void sendMesage(String name, String text);

}
