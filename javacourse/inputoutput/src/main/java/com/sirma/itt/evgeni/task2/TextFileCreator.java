package com.sirma.itt.evgeni.task2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Create file that contain text readed from console.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextFileCreator {

	public void fuckStreams(Path path) {

		try (OutputStreamWriter osw = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(path.toString())))) {
			
			System.out.println("Type text: Enter '.' to stop.");
			String text = new String();
			while (!text.matches(".")) {
				text = getLine();
				osw.write(text);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Read line from console.
	 * 
	 * @return
	 */
	public String getLine() {
		return ConsoleReader.readLine();
	}

}
