package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

public class Calculator {

	public String calculateString(String string) {
		
		int firstDigitStartIndex;
		int firstDigitEndIndex;
		int secondDigitStartIndex;
		int secondDigitEndIndex;
		
		for(int i=0;i<string.length();i++){
			System.out.println(string.charAt(i));
			
			if(string.charAt(i)=='*'){
				System.out.println("Multiply detected....");
			}
		}
		return "";
	}
	
	public void calculateOperation(Operation[] operation){
		
	}
}
