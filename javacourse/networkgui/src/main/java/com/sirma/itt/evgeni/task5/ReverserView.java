package com.sirma.itt.evgeni.task5;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorView;
import com.sirma.itt.evgeni.comunication.ComunicatorViewListener;

public class ReverserView extends ComunicatorView implements KeyListener {

	JTextField reverseField = new JTextField();

	public ReverserView(ComunicatorViewListener listener) {
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
	public void keyPressed(KeyEvent e) {
		if (e.getSource().getClass() == JTextField.class) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				listener.sendMessage("up 123 :");
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				listener.sendMessage("down 123 :");
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				listener.sendMessage("enter 123 :");
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
