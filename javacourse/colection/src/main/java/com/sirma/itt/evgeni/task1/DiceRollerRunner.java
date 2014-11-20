package com.sirma.itt.evgeni.task1;

public class DiceRollerRunner {

	public static void main(String[] args) {
		DiceRoller diceRoller = new DiceRoller(6);
		for(int i = 0;i<100;i++){
			diceRoller.rollDices();
		}
		System.out.println(diceRoller);
	}

}
