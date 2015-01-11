package com.sirma.itt.evgeni.comunication;

public class ComunicatorApp implements ComunicatorListener, UILIstener {

	private Comunicator comunicator;
	private Window window;

	public ComunicatorApp(Comunicator comunicator, Window window) {
		comunicator.setListener(this);
	}

	@Override
	public void setConectionStatus(MesageCommand status) {

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
	public void startConection(String nickname, String ip, String port) {
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	@Override
	public void stopConection() {
		comunicator.stopConection();
	}

	@Override
	public void sendMessage(String name, String message) {

	}

}
