package com.sirma.itt.evgeni.task1;

import java.awt.Dimension;

import javax.swing.JTextField;

public class Display extends JTextField {


	public Display() {
		setMaximumSize(new Dimension(300, 60));
	}
	
	public void addDigit(char digit){
		displaySymbol(digit);
	}
	
	public void addOperation(char operation){
		if(previousIsDigit()){
			displaySymbol(operation);
		}
		if(previousIsDot()){
			removeSymbol();
			displaySymbol(operation);
		}
	}
	
	public boolean previousIsDot(){
		if(getText().length()>0){
			if((getText().charAt(getText().length()-1)=='.')){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean previousIsDigit(){
		if(getText().length()>0){
			if(Character.isDigit(getText().charAt(getText().length()-1))){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public void addDot(){
		if(!previousIsFloat()){
			displaySymbol('.');
		}
	}
	
	public boolean previousIsFloat(){
		for(int i=(getText().length()-1);i>=0;i--){
			if(getText().charAt(i)=='.'){
				return true;
			}
			if(!Character.isDigit(getText().charAt(i))){
				return false;
			}
		}
		return false;
	}

	public void addSymbol(char symbol) {
		if (Character.isDigit(symbol)) {
			addDigit(symbol);
		}
		if (symbol == '.') {
			addDot();
		}
		if ((symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/')){
			addOperation(symbol);
		}
	}

	public void displaySymbol(char symbol) {
		setText((new StringBuilder(getText()).append(symbol)).toString());
	}

	public void removeSymbol() {
		String text = getText();
		if (text.length() > 0) {
			text = text.substring(0, text.length() - 1);
			setText(text);
		}
	}

}
