package com.sirma.itt.evgeni.task3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.ServerComunicator;

/**
 * Create incoming connections and send data.
 * 
 * @author GecaTM
 *
 */
public class Server extends ServerComunicator {

	private final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	public Server(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	/**
	 * Add user session.
	 */
	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		dataTransferer.sendData("<Hello>"
				+ dateFormat.format(System.currentTimeMillis()));
		comunicatorListener.displayMessage("Client conected");
	}

}
