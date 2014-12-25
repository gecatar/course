package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.ClientConector;
import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferer;

/**
 * Read information about clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class InfoReader extends Comunicator {

	Conector clientConector;

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
