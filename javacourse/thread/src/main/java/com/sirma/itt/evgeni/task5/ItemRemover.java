package com.sirma.itt.evgeni.task5;

public class ItemRemover extends Thread {

	private Holder holder;

	public ItemRemover(Holder holder) {
		this.holder = holder;
	}

	@Override
	public void run() {
		holder.remove();
	}
}
