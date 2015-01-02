package com.sirma.itt.evgeni.comunication;

public interface ComunicatorViewListener {

	public void startConection(String ip, int port);

	public void stopConection();

	public void sendMessage(String message);
}
