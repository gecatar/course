package com.sirma.itt.evgeni.task6;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Allow adding and removing items.
 * @author Evgeni Stefanov
 *
 */
public class TraderRunner {

	public static void main(String[] args) {
		
		//observers
		StockContainer stock = new StockContainer();
		SoldContainer sold = new SoldContainer();
		
		Trader trader = new Trader();
		trader.addObserver(stock);
		trader.addObserver(sold);
		
		while(true){
			System.out.println("Choose operation:");
			System.out.println("1)Buy Stock.");
			System.out.println("2)Sell Stock.");
			int choise = ConsoleReader.readInt();
			if(choise == 1){
				System.out.println("Enter description:");
				String description = ConsoleReader.readString();
				System.out.println("Enter quantity:");
				int quantity = ConsoleReader.readInt();
				trader.buyItem(description, quantity);
			}
			if(choise == 2){
				System.out.println("Enter description:");
				String description = ConsoleReader.readString();
				System.out.println("Enter quantity:");
				int quantity = ConsoleReader.readInt();
				trader.sellItem(description, quantity);
			}
			System.out.println(trader.toString());
		}
		
	}

}