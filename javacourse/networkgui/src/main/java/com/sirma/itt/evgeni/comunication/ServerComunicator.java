package com.sirma.itt.evgeni.comunication;


public class ServerComunicator extends Comunicator {

	public ServerComunicator(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ServerConector(this, ip, port);
			conector.start();
		}
		comunicatorListener.displayMessage("Receiving conections...");
	}

	@Override
	public void stopConection() {
		closeConector();
		comunicatorListener.displayMessage("Closing conector.");
		comunicatorListener.displayMessage("Stop receiving conections...");
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		comunicatorListener.displayMessage("user conected!!!");
	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {

	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {

	}

	@Override
	public void sendMessage(String message) {

	}
}
