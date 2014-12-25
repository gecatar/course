package com.sirma.itt.evgeni.comunication;

public abstract class Comunicator {

	public abstract void startConection(String ip, int port);

	public abstract void stopConection();
}
