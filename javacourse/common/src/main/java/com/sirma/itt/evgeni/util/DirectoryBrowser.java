package com.sirma.itt.evgeni.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Allow browsing file system.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DirectoryBrowser {

	/**
	 * Create path to selected file. Return null if operation is not successful.
	 * 
	 * @return path to selected file.
	 */
	public static Path findFile() {
		File folder = null;
		boolean stop = false;
		System.out.println("Enter path:");
		String path = ConsoleReader.readString();
		while (!stop) {
			try {
				folder = new File(path);
				if (folder.isDirectory()) {
					File[] temp = folder.listFiles();
					for (int i = 0; i < temp.length; i++) {
						System.out.println(i + ")" + temp[i].getName());
					}
					System.out.println("Enter number of directory:");
					System.out.println("Enter -1 for previos folder.");
					int choise = ConsoleReader.readInt();
					if (choise == -1) {
						path = folder.getParent();
					}
					if (choise >= 0) {
						path = temp[choise].getAbsolutePath();
						System.out.println(path);
					}
				} else {
					if (folder.isFile()) {
						System.out.println("This path is on file!!!");
						return folder.toPath();

					}
				}
			} catch (Exception e) {
				System.out.println("Error while searching file!!!");
				stop = true;
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * Create path to selected file. Return null if operation is not successful.
	 * 
	 * @return path to selected file.
	 */
	public static Path chooseDir() {
		File folder = null;
		boolean directoryChoosed = false;
		System.out.println("Enter path:");
		String path = ConsoleReader.readString();
		while (!directoryChoosed) {
			try {
				folder = new File(path);
				if (folder.isDirectory()) {
					File[] temp = folder.listFiles();
					for (int i = 0; i < temp.length; i++) {
						System.out.println(i + ")" + temp[i].getName());
					}
					System.out.println("Enter number of directory:");
					System.out.println("Enter -1 for previos folder.");
					System.out.println("Enter -2 select directory.");
					int choise = ConsoleReader.readInt();
					if (choise == -1) {
						path = folder.getParent();
					}
					if (choise == -2) {
						directoryChoosed = true;
						return Paths.get(path);
					}
					if (choise >= 0) {
						path = temp[choise].getAbsolutePath();
						System.out.println(path);
					}
				}

			} catch (Exception e) {
				System.out.println("Error while searching file!!!");
				e.printStackTrace();
			}

		}
		return null;
	}
	
	/**
	 * Create path to selected file.
	 * Return null if operation is not successful.
	 * @return path to selected file.
	 */
	public static Path chooseFile() {
		File folder = null;
		boolean fileChoosed = false;
		System.out.println("Enter path:");
		String path = ConsoleReader.readString();
		while (!fileChoosed) {
			try {
				folder = new File(path);
				if (folder.isDirectory()) {
					File[] temp = folder.listFiles();
					for (int i = 0; i < temp.length; i++) {
						System.out.println(i + ")" + temp[i].getName());
					}
					System.out.println("Enter number of directory:");
					System.out.println("Enter -1 for previos folder.");
					System.out.println("Enter -2 for creating file.");
					int choise = ConsoleReader.readInt();
					if (choise == -1) {
						path = folder.getParent();
					}
					if (choise == -2) {
						fileChoosed = true;
						return Paths.get(path, "\\", ConsoleReader.readString());
					}
					if (choise >= 0) {
						path = temp[choise].getAbsolutePath();
						System.out.println(path);
					}
				}
				else{
					if(folder.isFile()){
						fileChoosed = true;
						System.out.println("File choosed!!!");
						return folder.toPath();
						
					}
				}
			} catch (Exception e) {
				System.out.println("Error while searching file!!!");
				fileChoosed = true;
				e.printStackTrace();
			}

		}
		return null;
	}
}
