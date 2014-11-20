package com.sirma.itt.evgeni.task2.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.stubbing.answers.Returns;

import com.sirma.itt.evgeni.task2.TextFileCreator;
import com.sirma.itt.evgeni.util.DirectoryBrowser;

public class TextFileCreatorTest {

	@Test
	public void saveTextTest() throws FileNotFoundException {

		TextFileCreator textFileCreator = Mockito.mock(TextFileCreator.class);
		Mockito.when(textFileCreator.getLine()).thenReturn("123456")
				.thenReturn("test").thenReturn(".");
		textFileCreator.saveText(Paths.get("c:\\Users\\root\\test.txt"));
	}

}
