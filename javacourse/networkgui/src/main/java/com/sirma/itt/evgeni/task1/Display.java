package com.sirma.itt.evgeni.task1;

import java.awt.Dimension;

import javax.swing.JTextField;

/**
 * Display digits and mathematical operation.
 * @author Evgeni Stefanov
 *
 */
public class Display extends JTextField {


	public Display() {
		setMaximumSize(new Dimension(300, 60));
	}
	
	/**
	 * Add digit to Display.
	 * @param digit
	 */
	public void addDigit(char digit){
		displaySymbol(digit);
	}
	
	/**
	 * Add operation if previous symbol is digit.
	 * @param operation
	 */
	public void addOperation(char operation){
		if(previousIsDigit()){
			displaySymbol(operation);
		}
		if(previousIsDot()){
			removeSymbol();
			displaySymbol(operation);
		}
	}
	
	/**
	 * Return tru if previous symbol is dot.
	 * @return
	 */
	public boolean previousIsDot(){
		if(getText().length()>0){
			if((getText().charAt(getText().length()-1)=='.')){
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Return true if previous symbol is digit.
	 * @return
	 */
	public boolean previousIsDigit(){
		if(getText().length()>0){
			if(Character.isDigit(getText().charAt(getText().length()-1))){
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void addDot(){
		if(!previousIsFloat()){
			if(!previousIsDigit())
				displaySymbol('0');
			displaySymbol('.');
		}
	}
	
	/**
	 * Return true if previous number if float value.
	 * @return
	 */
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

	/**
	 * Add symbols.
	 * @param symbol
	 */
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

	/**
	 * Save symbol to Display.
	 * @param symbol
	 */
	public void displaySymbol(char symbol) {
		setText((new StringBuilder(getText()).append(symbol)).toString());
	}

	/**
	 * Remove last symbol from Display.
	 */
	public void removeSymbol() {
		String text = getText();
		if (text.length() > 0) {
			text = text.substring(0, text.length() - 1);
			setText(text);
		}
	}

}
