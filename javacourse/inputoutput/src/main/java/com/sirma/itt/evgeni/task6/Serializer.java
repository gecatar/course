package com.sirma.itt.evgeni.task6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

/**
 * Serialize object and save it to file.
 * @author Evgeni Stefanov
 *
 */
public class Serializer {
	/**
	 * 
	 * @param path to file where object will be saved.
	 * @param o object that will be serialized.
	 * @throws IOException
	 */
	public static void saveObject(Path path, DataClass o) throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(path.toString());
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	/**
	 * Read object from file.
	 * @param path file that will be read.
	 * @return DataClass object.
	 * @throws IOException
	 */
	public static DataClass getObject(Path path) throws IOException {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(path.toString());
			ois = new ObjectInputStream(fis);
			return (DataClass) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Error while reading object!!!");
			e.printStackTrace();
		} finally{
			if(ois!=null){
				fis.close();
			}
		}
		return null;
	}
}