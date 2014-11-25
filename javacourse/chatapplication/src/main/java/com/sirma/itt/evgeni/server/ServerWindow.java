package com.sirma.itt.evgeni.server;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.Window;

public class ServerWindow extends JFrame implements Window{

	JPanel panel = new JPanel();
	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JButton startConection = new JButton("Conect");
	JButton stopConection = new JButton("Disconect");
	JButton sendData = new JButton("Send Test Data");
	JTextField mesage = new JTextField(8);
	Controler controler;

	public void updateConectionStatus(boolean conected) {
		if (conected) {
			setTitle("Conected...");
		} else {
			setTitle("Disconected...");
		}
	}

	public void updateMesage(Mesage mesage) {
		this.mesage.setText(mesage.text);
	}

	public ServerWindow(final Controler controler) {
		this.controler = controler;
		this.controler.setWindow(this);
		add(panel);
		panel.add(new JLabel("IP Adress"));
		ipAdress.setText("localhost");
		panel.add(ipAdress);
		panel.add(new JLabel("Port"));
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
				//	controler.startConection(ipAdress.getText(), 7005);
				;
				if (e.getSource() == stopConection)
				//	controler.stopConection();
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
		
	}

	public void addUser(String user) {
		// TODO Auto-generated method stub
		
	}

	public void removeUser(String user) {
		// TODO Auto-generated method stub
		
	}

	public void displayMesage(String user, String text) {
		// TODO Auto-generated method stub
		
	}
}