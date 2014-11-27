package com.sirma.itt.evgeni.client.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Conversation extends JScrollPane {

	private JTextArea textArea;
	private JTextField textField;
	private JScrollBar verticalScrollBar;

	public Conversation() {

		verticalScrollBar = this.getVerticalScrollBar();
		this.setAutoscrolls(true);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		textArea = new JTextArea();
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(250, 170));
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);

		textArea.setText("textarea");
		textField.setText("frwefrfreferfer");

		panel.add(textArea);
		panel.add(textField);

		setViewportView(panel);
	}
	
	public void writeMesage(){
		textArea.setText(textArea.getText()+"ijwdijwdoiq\n");
		//verticalScrollBar.setValue(verticalScrollBar.getAutoscrolls());
		
	}
}
