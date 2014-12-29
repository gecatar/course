package com.sirma.itt.evgeni.comunication;

public class ClientComunicator extends Comunicator {

	public ClientComunicator(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ClientConector(this, ip, port);
			conector.start();
		}
		comunicatorListener.displayMessage("Open conection...");
	}

	@Override
	public void stopConection() {
		closeConector();
		comunicatorListener.displayMessage("Close conector...");
		comunicatorListener.displayMessage("Close conection...");
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {

	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {

	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {

	}

	@Override
	public void sendMessage() {

	}

}
