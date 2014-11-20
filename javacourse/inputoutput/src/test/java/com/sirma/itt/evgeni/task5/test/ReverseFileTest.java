package com.sirma.itt.evgeni.task5.test;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.FileReverser;

public class ReverseFileTest {

	FileReverser fileReverser = new FileReverser();
	Path path = Paths.get("c:\\users\\root\\testreverse");
	
	@Test
	public void saveTextTest(){
		String text = "123456";
		assertTrue(fileReverser.saveText(text, path));
		assertEquals(text, fileReverser.getText(path));
	}
	
	@Test
	public void readTextTest(){
		String text = "654321";
		assertTrue(fileReverser.saveText(text, path));
		assertEquals(text, fileReverser.getText(path));
	}

}
