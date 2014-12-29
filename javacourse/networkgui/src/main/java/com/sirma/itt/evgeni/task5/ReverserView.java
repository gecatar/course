package com.sirma.itt.evgeni.task5;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorView;
import com.sirma.itt.evgeni.comunication.ComunicatorViewListener;

public class ReverserView extends ComunicatorView {

	JTextField reverseField = new JTextField();

	public ReverserView(ComunicatorViewListener listener) {
		super(listener);
		JLabel revesreLabel = new JLabel("Enter message");
		revesreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		revesreLabel.setMaximumSize(new Dimension(150, 20));
		reverseField.setAlignmentX(Component.CENTER_ALIGNMENT);
		reverseField.setMaximumSize(new Dimension(150, 20));
		panel.add(revesreLabel);
		panel.add(reverseField);
	}

}
