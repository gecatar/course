package com.sirma.itt.evgeni.comunication;

public abstract class Comunicator {

	protected Conector conector;
	protected ComunicatorListener listener;
	protected String name;

	public Comunicator(ComunicatorListener listener) {
		this.listener = listener;
	}

	public void startConection(String ip, int port) {
		if (conector.startConection(ip, port)) {
			listener.setConectionStatus(MesageCommand.COMUNICATOR_CONECTING);
		}
	}

	public void stopConection() {
		if (conector.stopConection()) {
			listener.setConectionStatus(MesageCommand.COMUNICATOR_DISCONECTED);
			close();
		}
	}

	public void openSession(DataTransferer dataTransferer) {
		dataTransferer.start();
	}

	public abstract void processMesage(Mesage mesage,
			DataTransferer dataTransferer);

	public void closeSession(DataTransferer dataTransferer) {
		dataTransferer.closeSocket();
	}

	public abstract void sendMessage(String name, String text);

	public void setName(String name) {
		this.name = name;
	}

	public void close() {

	}

}
