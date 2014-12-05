package com.sirma.itt.evgeni.comunication;

public interface UILIstener {

	public void startConection(String nickname, String ip, String port);

	public void stopConection();

	public void sendMessage(String name, String message);
}
