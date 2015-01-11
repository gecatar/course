package com.sirma.itt.evgeni.comunication;

public abstract class Comunicator {

	private Conector conector;
	protected ComunicatorListener listener;

	public void setListener(ComunicatorListener listener) {
		this.listener = listener;
	}

	public void startConection(String ip, int port) {
		conector.startConection(ip, port);
	}

	public void stopConection() {
		conector.stopConection();
	}

	public abstract void processMesage(Mesage mesage,
			DataTransferer dataTransferer);

	public abstract void closeSession(DataTransferer dataTransferer);

	public void close() {

	}

}
