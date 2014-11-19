package com.sirma.itt.evgeni.task5;

public class ItemRemover extends Thread{

	Holder holder;
	
	public ItemRemover(Holder holder){
		this.holder = holder;
	}
	
	public void run(){
		holder.remove();
	}
}
