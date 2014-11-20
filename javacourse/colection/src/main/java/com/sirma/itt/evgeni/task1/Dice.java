package com.sirma.itt.evgeni.task1;

public class Dice {

	private int sides;
	
	public Dice(int sides){
		this.sides = sides;
	}

	public int rool() {
		return (int) (Math.random() / sides) + 1;
	}
}
