package com.sirma.itt.evgeni.comunication;

public abstract class Comunicator {

	protected Conector conector;

	public abstract void startConection(String ip, int port);

	public abstract void stopConection();

	public abstract void addUserSession(DataTransferer dataTransferer);

	public abstract void closeUsersession(DataTransferer dataTransferer);

	public abstract void receiveMessage(String message,
			DataTransferer transferer);

	public synchronized void closeConector() {
		if (conector != null) {
			conector.closeConector();
			conector = null;
		}
	}

}
