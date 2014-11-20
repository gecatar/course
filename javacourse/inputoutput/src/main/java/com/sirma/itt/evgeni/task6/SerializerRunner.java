package com.sirma.itt.evgeni.task6;

import java.io.IOException;
import java.nio.file.Path;

import com.sirma.itt.evgeni.util.DirectoryBrowser;

public class SerializerRunner {

	public static void main(String[] args) {

		Serializer serializer = new Serializer();
		DataClass data = new DataClass();
		Path path = DirectoryBrowser.chooseFile();
		serializer.saveObject(data, path);
		try {
			DataClass temp = serializer.getObject(path);
			if (temp != null) {
				System.out.println(temp.count);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
