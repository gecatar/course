package com.sirma.itt.evgeni.comunication;

public abstract class Comunicator {

	private Conector conector;

	public void startConection(String ip, int port) {
		conector.startConection(ip, port);
	}

	public void stopConection() {
		conector.stopConection();
	}

	public abstract void processMesage(Mesage mesage,
			DataTransferator dataTransferator);

	public abstract void closeSession(DataTransferator dataTransferator);

	public void close() {

	}

}
