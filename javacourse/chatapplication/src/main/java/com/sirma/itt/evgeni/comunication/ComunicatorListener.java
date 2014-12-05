package com.sirma.itt.evgeni.comunication;

public interface ComunicatorListener {

	public void setConectionStatus(boolean conected);

	public void showMesage(String name, String text);

	public void addUser(String name);

	public void removeUser(String name);
}
