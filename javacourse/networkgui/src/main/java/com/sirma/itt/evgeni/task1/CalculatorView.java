package com.sirma.itt.evgeni.task1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorView extends JFrame implements ActionListener {

	Display display;

	public CalculatorView() {

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
		JButton[] operations = new JButton[7];
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
		for (JButton button : operations) {
			button.addActionListener(this);
		}
		// Adding components to panell.
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
		setVisible(true);
	}

	public void displayResults(BigDecimal result) {
		display.setText(String.valueOf(result));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			char symbol = ((JButton) e.getSource()).getName().charAt(0);
			if (symbol == '=') {
			} else {
				if (symbol == 'C') {
					display.removeSymbol();
				} else {
					display.addSymbol(symbol);
				}
			}
		}
	}

}
