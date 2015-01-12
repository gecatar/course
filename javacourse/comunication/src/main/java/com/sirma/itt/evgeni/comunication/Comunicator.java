package com.sirma.itt.evgeni.comunication;

public abstract class Comunicator {

	protected Conector conector;
	protected ComunicatorListener listener;

	public Comunicator(ComunicatorListener listener) {
		this.listener = listener;
	}

	public void startConection(String ip, int port) {
		conector.startConection(ip, port);
	}

	public void stopConection() {
		conector.stopConection();
	}

	public void openSession(DataTransferer dataTransferer) {
		dataTransferer.start();
	}

	public abstract void processMesage(Mesage mesage,
			DataTransferer dataTransferer);

	public void closeSession(DataTransferer dataTransferer) {
		dataTransferer.closeSocket();
	}

	public void close() {

	}

}
