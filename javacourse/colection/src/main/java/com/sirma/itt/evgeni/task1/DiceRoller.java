package com.sirma.itt.evgeni.task1;

public class DiceRoller {

	Dice firstDice;
	Dice secondDice;
	
	
	
	public DiceRoller(int sides){
		firstDice = new Dice(sides);
		secondDice = new Dice(sides);
	}
	
	public void rollDices(){
		firstDice.rool();
		secondDice.rool();
	}
	
	public String generateReport(){
		return null;
	}
}
