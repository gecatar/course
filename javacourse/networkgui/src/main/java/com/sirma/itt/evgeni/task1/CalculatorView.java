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
import javax.swing.JTextField;

public class CalculatorView extends JFrame implements ActionListener {

	JTextField display = new JTextField();

	public CalculatorView() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(300, 300));
		JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.Y_AXIS));
		display = new JTextField();
		display.setMaximumSize(new Dimension(300, 60));
		JLabel label = new JLabel();
		label.setText("kerokoegp");
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(300, 120));
		comboPanel.add(display);
		comboPanel.add(panel);
		add(comboPanel);
		panel.setLayout(new GridLayout(3, 6));
		JButton[] digits = new JButton[10];
		for (int i = 0; i < 10; i++) {
			digits[i] = new JButton(Integer.toString(i));
			digits[i].setName(Integer.toString(i));
			digits[i].setMaximumSize(new Dimension(60, 60));
			digits[i].addActionListener(this);
			panel.add(digits[i]);
		}
		JButton[] operations = new JButton[6];
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
		for (int i = 0; i < 6; i++) {
			operations[i].addActionListener(this);
			panel.add(operations[i]);
		}
		setVisible(true);
	}

	public void addSymbol(String symbol) {
		display.setText((new StringBuilder(display.getText()).append(symbol))
				.toString());
	}

	public void removeSymbol() {
		String text = display.getText();
		if (text.length() > 0) {
			text = text.substring(0, text.length() - 1);
			display.setText(text);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			String symbol = ((JButton) e.getSource()).getName();
			if (symbol.equals("C")) {
				removeSymbol();
			} else {
				addSymbol(symbol);
			}
		}
	}
}
