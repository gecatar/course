package com.sirma.itt.evgeni.task5;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorView;
import com.sirma.itt.evgeni.comunication.MessageLogger;

/**
 * Display UI components.
 * 
 * @author GecaTM
 *
 */
public class ReverserView extends ComunicatorView implements KeyListener {

	private final JTextField reverseField = new JTextField();
	private final MessageLogger messageLogger = new MessageLogger();

	public ReverserView(ActionListener listener) {
		super(listener);
		JLabel revesreLabel = new JLabel("Enter message");
		revesreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		revesreLabel.setMaximumSize(new Dimension(150, 20));
		reverseField.setAlignmentX(Component.CENTER_ALIGNMENT);
		reverseField.setMaximumSize(new Dimension(150, 20));
		reverseField.addKeyListener(this);
		panel.add(revesreLabel);
		panel.add(reverseField);
	}

	@Override
	public String getText() {
		return reverseField.getText();
	}

	/**
	 * Action listener.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().getClass() == JTextField.class) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				reverseField.setText(messageLogger.getNextMessage());
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				reverseField.setText(messageLogger.getPreviousMessage());
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				listener.actionPerformed(new ActionEvent(reverseField, 0,
						"send message"));
				messageLogger.logMessage(reverseField.getText());
				reverseField.setText("");
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
