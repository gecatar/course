package com.sirma.itt.evgeni.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFileChooser;

import com.sirma.itt.evgeni.util.TransferObject;

public class DownloadAgent extends Thread {

	URL url;
	URLConnection urlConection;
	InputStream ist;
	OutputStream ost;
	boolean correctURL;
	DownloadProgressUpdater progressUpdater;
	JFileChooser fileChooser = new JFileChooser();
	long size;
	long downloaded;

	public DownloadAgent(String url,DownloadProgressUpdater progressUpdater ) {
		this.progressUpdater = progressUpdater;
		correctURL = true;
		try {
			this.url = new URL(url);
			urlConection = this.url.openConnection();
			ist = urlConection.getInputStream();
			size = urlConection.getContentLength();
			fileChooser.showSaveDialog(fileChooser);
			ost = new FileOutputStream(fileChooser.getSelectedFile());
		} catch (Exception e) {
			correctURL = false;
		}
	}

	public void run() {
		downloadFile();
	}

	public void downloadFile() {
		TransferObject tranferator = new TransferObject(ist, ost);
		int readed = 0;
		while (readed != -1) {
			downloaded += readed;
			readed = tranferator.transfer(1000);
			int percentProgress = (int) (100 * downloaded / size);
			progressUpdater.setProgress(percentProgress);
		}
		try {
			ist.close();
			ost.flush();
			ost.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}