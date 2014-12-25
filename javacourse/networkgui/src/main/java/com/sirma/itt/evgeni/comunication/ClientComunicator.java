package com.sirma.itt.evgeni.comunication;

public class ClientComunicator extends Comunicator {

	ClientConector clientConector;

	@Override
	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ClientConector(this, ip, port);
		}
	}

	@Override
	public void stopConection() {
		// TODO Auto-generated method stub

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
