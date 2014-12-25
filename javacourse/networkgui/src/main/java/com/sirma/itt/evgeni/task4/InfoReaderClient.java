package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class InfoReaderClient extends ClientComunicator {

	DataTransferer dataTransferer;

	public InfoReaderClient(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		this.dataTransferer = dataTransferer;
		comunicatorListener.conectionStatusChange(true);
	}

	@Override
	public synchronized void closeUsersession(DataTransferer dataTransferer) {
		if (dataTransferer != null) {
			dataTransferer.closeSocket();
			comunicatorListener.conectionStatusChange(true);
		}
	}

}
