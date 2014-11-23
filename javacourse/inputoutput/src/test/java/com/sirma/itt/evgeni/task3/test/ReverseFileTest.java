package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.FileReverser;

public class ReverseFileTest {

	FileReverser fileReverser = new FileReverser();
	String path = "c:\\users\\root\\testreverse";
	
	@Test
	public void saveTextTest() throws FileNotFoundException{
		String text = "123456";
		assertTrue(fileReverser.reverseFile(path));
	}
	
	@Test
	public void reverseTextTest(){
		String text = "123456";
		String expectedText = "654321";
		String actualText = fileReverser.reverseText(text);
	}
	
	@Test
	public void readTextTest(){
		String text = "654321";
	}

}
