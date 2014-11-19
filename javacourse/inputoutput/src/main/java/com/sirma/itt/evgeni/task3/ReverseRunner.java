package com.sirma.itt.evgeni.task3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class ReverseRunner {

	public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder();
		try {
			InputStreamReader inputReader = new InputStreamReader(
					new BufferedInputStream(new FileInputStream("")));
			try {
				int readed = 0;
				char[] buffer = new char[20];
				while (readed != -1) {
					stringBuilder.append(buffer, 0, readed);
					readed = inputReader.read(buffer);
				}
			} finally {
				inputReader.close();
			}
		} catch (IOException e) {
		}
	}

	public String getText(Path path) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			InputStreamReader inputReader = new InputStreamReader(
					new BufferedInputStream(
							new FileInputStream(path.toString())));
			try {
				int readed = 0;
				char[] buffer = new char[20];
				while (readed != -1) {
					stringBuilder.append(buffer, 0, readed);
					readed = inputReader.read(buffer);
				}
			} finally {
				inputReader.close();
			}
		} catch (IOException e) {
		}
		return stringBuilder.toString();
	}
}
