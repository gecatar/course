package com.sirma.itt.evgeni.task5;

public class ItemAdder extends Thread {

	private Holder holder;
	private String string;

	public ItemAdder(Holder holder, String string) {
		this.holder = holder;
		this.string = string;
	}

	@Override
	public void run() {
		holder.addElement(string);
	}

}
