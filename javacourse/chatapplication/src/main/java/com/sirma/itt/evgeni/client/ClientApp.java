package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ConectorShutdownHook;
import com.sirma.itt.evgeni.comunication.UILIstener;
import com.sirma.itt.evgeni.comunication.Window;

/**
 * Send and receive messages from server.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ClientApp implements UILIstener, ComunicatorListener {

	private final Comunicator comunicator;
	private final ViewPanell viewPanell;

	public ClientApp() {
		comunicator = new Client(this);
		viewPanell = new ViewPanell(this);
		Runtime.getRuntime().addShutdownHook(
				new ConectorShutdownHook(comunicator));
		new Window(viewPanell);
	}

	/**
	 * Show user connection status.
	 */
	@Override
	public void setConectionStatus(String conectionCondition) {
		viewPanell.setConectionStatus(conectionCondition);

	}

	/**
	 * Show message on display.
	 */
	@Override
	public void showMesage(String name, String text) {
		viewPanell.displayMessage(name, text);
	}

	/**
	 * Add user in list.
	 */
	@Override
	public void addUser(String name) {
		viewPanell.addUser(name);
	}

	/**
	 * Remove user from list.
	 */
	@Override
	public void removeUser(String name) {
		viewPanell.removeUser(name);
	}

	/**
	 * Start connection.
	 */
	@Override
	public void startConection(String nickname, String ip, String port) {
		comunicator.setName(nickname);
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	/**
	 * Stop connection.
	 */
	@Override
	public void stopConection() {
		comunicator.stopConection();
	}

	/**
	 * Send message to user.
	 */
	@Override
	public void sendMessage(String name, String text) {
		comunicator.sendMesage(name, text);
	}

	/**
	 * Start application.
	 * 
	 * @param args
	 */
	// Runner--------------------------------
	public static void main(String[] args) {
		new ClientApp();
	}
	// --------------------------------------
}
