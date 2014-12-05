package com.sirma.itt.evgeni.server.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.client.view.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Comunicator;

public class ServerWindow extends JFrame implements ComunicatorListener {

	Comunicator comunicator;
	JPanel panel = new JPanel();
	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JButton startConection = new JButton("Conect");
	JButton stopConection = new JButton("Disconect");
	JButton sendData = new JButton("Send Test Data");
	JTextField mesage = new JTextField(8);

	public ServerWindow() {
		comunicator = new Server(this);
		add(panel);
		panel.add(new JLabel("IP Adress"));
		ipAdress.setText("localhost");
		panel.add(ipAdress);
		panel.add(new JLabel("Port"));
		port.setText("1300");
		panel.add(port);
		panel.add(startConection);
		panel.add(stopConection);
		panel.add(sendData);
		panel.add(mesage);
		setSize(new Dimension(200, 300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// -------------------------------------
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == startConection)
					comunicator.startConection(ipAdress.getText(),
							Integer.parseInt(port.getText()));
				;
				if (e.getSource() == stopConection)
					comunicator.stopConection();
				if (e.getSource() == sendData)
					;

			}
		};
		startConection.addActionListener(listener);
		stopConection.addActionListener(listener);
		sendData.addActionListener(listener);
		// -------------------------------------

	}

	public void setConectionStatus(boolean conected) {
		// TODO Auto-generated method stub
		if (conected) {
			setTitle("Conected...");
		} else {
			setTitle("Disconected...");
		}
	}

	public void showMesage(String name, String text) {
		// TODO Auto-generated method stub

	}

	public void addUser(String name) {
		// TODO Auto-generated method stub

	}

	public void removeUser(String name) {
		// TODO Auto-generated method stub

	}

}