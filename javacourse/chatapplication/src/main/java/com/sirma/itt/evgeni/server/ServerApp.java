package com.sirma.itt.evgeni.server;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ConectorShutdownHook;
import com.sirma.itt.evgeni.comunication.UILIstener;
import com.sirma.itt.evgeni.comunication.Window;

/**
 * Create connection whit users, send and receive messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ServerApp implements UILIstener, ComunicatorListener {

	private static final Logger LOGGER = Logger.getLogger(ServerApp.class
			.getName());
	static {
		try {
			FileHandler handler;
			handler = new FileHandler("%h/ServerLog.txt", true);
			LOGGER.getLogger("").addHandler(handler);
			LOGGER.log(Level.SEVERE, "Log file created!!!");
		} catch (SecurityException | IOException e) {
			LOGGER.log(Level.SEVERE, "Log file is not created!!!", e);
		}

	}
	private Comunicator comunicator;
	private ConectionPanel conectionPanel;

	public ServerApp() {
		comunicator = new Server(this);
		conectionPanel = new ConectionPanel(this);
		Runtime.getRuntime().addShutdownHook(
				new ConectorShutdownHook(comunicator));
		new Window(conectionPanel);
	}

	/**
	 * Start connection.
	 */
	@Override
	public void startConection(String name, String ip, String port) {
		comunicator.setName(name);
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	/**
	 * Stop connection.
	 */
	@Override
	public void stopConection() {
		comunicator.stopConection();

	}

	@Override
	public void setConectionStatus(String conectionCondition) {
	}

	@Override
	public void showMesage(String name, String text) {
	}

	@Override
	public void addUser(String name) {
	}

	@Override
	public void removeUser(String name) {
	}

	@Override
	public void sendMessage(String receiver, String text) {
	}

	/**
	 * Start application.
	 */
	// Runner------------------------------
	public static void main(String[] args) {
		new ServerApp();
	}
	// -------------------------------------
}
