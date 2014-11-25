package com.sirma.itt.evgeni.comunication;

public interface Controler {
	
	public void setComunicator(Comunicator comunicator);
	
	public void setWindow(Window window);

	public void setConectionStatus(boolean conected);

	public void proccesMesage(Mesage mesage);

}
