package com.sirma.itt.evgeni.comunication;

public class ServerComunicator extends Comunicator {

	public ServerComunicator(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ServerConector(this, ip, port);
			conector.start();
		}
	}

	@Override
	public void stopConection() {

	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		// TODO Auto-generated method stub

	}

}
