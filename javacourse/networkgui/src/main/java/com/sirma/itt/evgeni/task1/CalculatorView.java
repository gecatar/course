package com.sirma.itt.evgeni.task1;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{

	public CalculatorView(){
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(300,300));
		JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.Y_AXIS));
		JTextField display = new JTextField();
		display.setMaximumSize(new Dimension(300,60));
		JLabel label = new JLabel();
		label.setText("kerokoegp");
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(300,120));
		comboPanel.add(display);
		comboPanel.add(panel);
		add(comboPanel);
		
		
		panel.setLayout(new GridLayout(3, 6));
		for(int i=0;i<18;i++){
			JButton temp = new JButton("( )");
			temp.setMaximumSize(new Dimension(60,60));
			panel.add(temp);
		}
		setVisible(true);
	}
}
