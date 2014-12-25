package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ComunicatorView;
import com.sirma.itt.evgeni.comunication.ComunicatorViewListener;

public class InfoServerApp implements ComunicatorListener,
		ComunicatorViewListener {

	Comunicator comunicator;
	ComunicatorView comunicatorView;

	public InfoServerApp() {
		comunicator = new InfoReaderServer(this);
		comunicatorView = new ComunicatorView(this);
		comunicatorView.setTitle("Info server app...");
	}

	@Override
	public void userConected() {

	}

	@Override
	public void displayMessage(String message) {

	}

	@Override
	public void conectionStatusChange(boolean conected) {
		comunicatorView.setConectionStatus(conected);
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
	public void sendMessage() {

	}

	public static void main(String[] args) {
		new InfoServerApp();
	}

}
