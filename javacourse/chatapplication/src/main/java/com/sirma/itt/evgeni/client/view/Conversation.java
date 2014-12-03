package com.sirma.itt.evgeni.client.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Conversation extends JScrollPane implements ActionListener {

	private final JTextArea textArea;
	private final JTextField textField;
	private final JScrollBar verticalScrollBar;

	public Conversation(String name) {

		verticalScrollBar = this.getVerticalScrollBar();
		this.setAutoscrolls(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		setName(name);
		textArea = new JTextArea();
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(250, 170));
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField.addActionListener(this);
		panel.add(textArea);
		panel.add(textField);

		setViewportView(panel);
	}

	public void writeMesage(String message) {
		textArea.setText(textArea.getText() + message + "\n");
		verticalScrollBar.setValue(verticalScrollBar.getMaximum());

	}

	public void actionPerformed(ActionEvent arg0) {
		writeMesage(textField.getText());
		textField.setText("");

	}
}
