package com.sirma.itt.evgeni.comunication;

public interface ComunicatorListener {

	public void userConected();

	public void displayMessage(String message);

	public void conectionStatusChange(boolean conected);
}
