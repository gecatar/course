package com.sirma.itt.evgeni.task2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFileChooser;

import com.sirma.itt.evgeni.util.TransferObject;

public class DownloadAgent extends Thread {

	DownloadProgressUpdater progressUpdater;
	String url;

	public DownloadAgent(DownloadProgressUpdater progressUpdater, String url) {
		this.progressUpdater = progressUpdater;
		this.url = url;
	}

	public File getFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(fileChooser);
		return fileChooser.getSelectedFile();
	}

	public InputStream getInputStream(URLConnection conection)
			throws IOException {
		return conection.getInputStream();
	}

	public URLConnection getConection(String url) throws IOException {
		return new URL(url).openConnection();
	}

	public OutputStream getOutputStream(File file) throws FileNotFoundException {
		return new BufferedOutputStream(new FileOutputStream(file));
	}

	public void run() {
		downloadFile(url);
	}

	public boolean downloadFile(String res) {
		TransferObject transferator = null;
		try {
			URLConnection conection;
			conection = getConection(res);
			long size = conection.getContentLengthLong();
			transferator = new TransferObject(getInputStream(conection),
					getOutputStream(getFile()));
			int readed = 0;
			long downloaded = 0;
			while (readed != -1) {
				downloaded += readed;
				readed = transferator.transfer(1000);
				int percentProgress = (int) (100 * downloaded / size);
				progressUpdater.setProgress(percentProgress);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			transferator.close();
		}

	}
}