package com.sirma.itt.evgeni.task1;

import java.awt.Dimension;

import javax.swing.JTextField;

/**
 * Display digits and mathematical operation.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Display extends JTextField {

	public Display() {
		setMaximumSize(new Dimension(300, 60));
		setEditable(false);
	}

	/**
	 * Return true if previous number if float value.
	 * 
	 * @return
	 */
	private boolean previousIsFloat() {
		for (int i = (getText().length() - 1); i >= 0; i--) {
			if (getText().charAt(i) == '.') {
				return true;
			}
			if (!Character.isDigit(getText().charAt(i))) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Return true if previous symbol is digit.
	 * 
	 * @return
	 */
	private boolean previousIsDigit() {
		if (getText().length() > 0) {
			if (Character.isDigit(getText().charAt(getText().length() - 1))) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Add digit to Display.
	 * 
	 * @param digit
	 */
	private void addDigit(char digit) {
		displaySymbol(digit);
	}

	/**
	 * 
	 */
	private void addDot() {
		if (!previousIsFloat()) {
			if (!previousIsDigit())
				displaySymbol('0');
			displaySymbol('.');
		}
	}

	/**
	 * Add symbols.
	 * 
	 * @param symbol
	 */
	public void addSymbol(char symbol) {
		if (Character.isDigit(symbol)) {
			if (symbol == '0') {
				if (previousIsDigit() || previousIsFloat()) {
					addDigit(symbol);
				}
			} else {
				addDigit(symbol);
			}
		}
		if (symbol == '.') {
			addDot();
		}
	}

	/**
	 * Save symbol to Display.
	 * 
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
