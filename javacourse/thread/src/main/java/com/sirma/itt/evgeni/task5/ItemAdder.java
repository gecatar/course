package com.sirma.itt.evgeni.task5;

public class ItemAdder extends Thread {

	Holder holder;
	String string;

	public ItemAdder(Holder holder, String string) {
		this.holder = holder;
		this.string = string;
	}

	public void run() {
		holder.addElement(string);
	}

}
