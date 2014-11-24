package com.sirma.itt.evgeni.task5;

import java.io.File;

/**
 * Allow user to specify path and see its content.
 * 
 * @author GecaTM
 *
 */
public class DirectoryBrowser {

	/**
	 * Display content on passed path.
	 * @param path
	 * @return count of elements on current path.
	 */
	public int listContent(String path) {

		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i =0;i<files.length;i++) {
				System.out.println(files[i].getName());
			}
			return files.length;
		}
		if(file.isFile()){
			System.out.println("Path is on file!!!");
			return 1;
		}
		return 0;
	}
}
