package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ComunicatorView;
import com.sirma.itt.evgeni.comunication.ComunicatorViewListener;

public class InforeaderApp implements ComunicatorListener,
		ComunicatorViewListener {

	Comunicator comunicator;
	ComunicatorView comunicatorView;

	public InforeaderApp() {
		comunicator = new InfoReaderClient(this);
		comunicatorView = new ComunicatorView(this);
	}

	@Override
	public void userConected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		InforeaderApp app = new InforeaderApp();

	}

}
