package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ComunicatorView;
import com.sirma.itt.evgeni.comunication.ComunicatorViewListener;

public class ClientApp implements ComunicatorListener, ComunicatorViewListener {

	Comunicator comunicator;
	ComunicatorView comunicatorView;

	public ClientApp() {
		comunicator = new ReverserClient(this);
		comunicatorView = new ReverserView(this);
		comunicatorView.setTitle("Reverse client app...");
	}

	@Override
	public void startConection(String ip, int port) {
		comunicator.startConection(ip, port);
	}

	@Override
	public void stopConection() {
		comunicator.stopConection();
	}

	@Override
	public void displayMessage(String message) {
		comunicatorView.displayMessage(message);
	}

	@Override
	public void conectionStatusChange(boolean conected) {
		comunicatorView.setConectionStatus(conected);
	}

	@Override
	public void sendMessage(String message) {
		comunicator.sendMessage(message);
	}

	public static void main(String[] args) {
		new ClientApp();
	}

}
