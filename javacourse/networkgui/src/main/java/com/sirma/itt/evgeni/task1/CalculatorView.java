package com.sirma.itt.evgeni.task1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Display and contain UI components. Send messages for user inputs.
 * 
 * @author GecaTM
 *
 */
public class CalculatorView extends JFrame implements ActionListener {

	private Display display;
	private UIListener uiListener;
	private boolean clearDisplay;
	private boolean exceptionTrigered;

	public CalculatorView(UIListener uiListener) {

		this.uiListener = uiListener;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(400, 250));
		JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.Y_AXIS));
		display = new Display();
		JLabel label = new JLabel();
		label.setText("kerokoegp");
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(300, 120));
		comboPanel.add(display);
		comboPanel.add(panel);
		add(comboPanel);
		panel.setLayout(new GridLayout(5, 4));
		JButton[] digits = new JButton[10];
		for (int i = 0; i < 10; i++) {
			digits[i] = new JButton(Integer.toString(i));
			digits[i].setName(Integer.toString(i));
			digits[i].setMaximumSize(new Dimension(60, 60));
			digits[i].addActionListener(this);
		}
		JButton[] operations = new JButton[8];
		operations[0] = new JButton("-");
		operations[0].setName("-");
		operations[1] = new JButton("+");
		operations[1].setName("+");
		operations[2] = new JButton("/");
		operations[2].setName("/");
		operations[3] = new JButton("*");
		operations[3].setName("*");
		operations[4] = new JButton("=");
		operations[4].setName("=");
		operations[5] = new JButton("C");
		operations[5].setName("C");
		operations[6] = new JButton(".");
		operations[6].setName(".");
		operations[7] = new JButton("CL");
		operations[7].setName("D");
		for (JButton button : operations) {
			button.addActionListener(this);
		}
		// Adding components to panel.
		panel.add(digits[7]);
		panel.add(digits[8]);
		panel.add(digits[9]);
		panel.add(operations[0]);
		panel.add(digits[4]);
		panel.add(digits[5]);
		panel.add(digits[6]);
		panel.add(operations[1]);
		panel.add(digits[1]);
		panel.add(digits[2]);
		panel.add(digits[3]);
		panel.add(operations[2]);
		panel.add(digits[0]);
		panel.add(operations[6]);
		panel.add(operations[4]);
		panel.add(operations[3]);
		panel.add(operations[5]);
		panel.add(operations[7]);
		setVisible(true);
	}

	/**
	 * Display result.
	 */
	public void displayResults(String result) {
		display.setText(result);
		clearDisplay = true;
	}

	/**
	 * Trigger exception flag.
	 */
	public void trigerException() {
		exceptionTrigered = true;
	}

	/**
	 * Get number displayed at moment of invocation.
	 */
	public String getNumber() {
		return display.getText();
	}

	/**
	 * When UI components are preset.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			char symbol = ((JButton) e.getSource()).getName().charAt(0);
			if (symbol == '+' || symbol == '-' || symbol == '*'
					|| symbol == '/') {
				if (display.getText().length() > 0 && !exceptionTrigered) {
					uiListener.operationPressed(display.getText(), symbol);
					clearDisplay = true;
				}
			}
			if (symbol == '=') {
				uiListener.calculatePresset(display.getText());
			}
			if (symbol == 'C') {
				display.removeSymbol();
			}
			if (symbol == 'D') {
				uiListener.clearPreset();
				display.setText("");
			}
			if ((symbol >= '0' && symbol <= '9') || symbol == '.') {
				if (clearDisplay == true || exceptionTrigered) {
					display.setText("");
					clearDisplay = false;
					exceptionTrigered = false;
				}
				display.addSymbol(symbol);
			}
		}
	}

}
