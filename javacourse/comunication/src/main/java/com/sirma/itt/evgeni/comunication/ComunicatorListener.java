package com.sirma.itt.evgeni.comunication;

public interface ComunicatorListener {

	public void setConectionStatus(String conectionCondition);

	public void showMesage(String name, String text);

	public void addUser(String name);

	public void removeUser(String name);
}
