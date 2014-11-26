package com.sirma.itt.evgeni.comunication;

public interface Window {

	void setConectionStatus(boolean conected);

	void addUser(String user);

	void removeUser(String user);

	void showMesage(String sender, String text);

}
