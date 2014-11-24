package com.sirma.itt.evgeni.tas3.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task3.ExceptionManager;

public class ExceptionManagerTest {

	ExceptionManager exmng;
	List<String> errors;

	@Before
	public void setUp() throws Exception {
		exmng = new ExceptionManager();
	}

	/**
	 * Test adding errors via code.
	 */
	@Test
	public void addExceptionUsingCodeTest() {

		exmng.addExceptionUsingCode("INVID");
		exmng.addExceptionUsingCode("INVPC");
		exmng.addExceptionUsingCode("INVDC");
		errors = exmng.getMesages();
		assertTrue(errors.get(0).equals("Invalid UID"));
		assertTrue(errors.get(1).equals("Invalid Post Code"));
		assertTrue(errors.get(2).equals("Invalid Debit Card Number"));

		exmng.addExceptionAndDescription("test", "test error");
		exmng.addExceptionUsingCode("test");
		errors = exmng.getMesages();
		assertTrue(errors.get(3).equals("test error"));
	}

	/**
	 * Test adding Errors and their description in map.
	 */
	@Test
	public void addExceptionAndDescriptionUsingCode() {
		exmng.clearLog();
		exmng.addExceptionAndDescription("test", "test error");
		exmng.addExceptionUsingCode("test");
		errors = exmng.getMesages();
		assertTrue(errors.get(0).equals("test error"));
	}

	/**
	 * Test adding message. If passed error is not included in map error will
	 * not be stored.
	 */
	@Test
	public void addMessageTest() {
		exmng.clearLog();
		exmng.addExceptionAndDescription("test", "test error");
		exmng.addExceptionMesage("test error");
		errors = exmng.getMesages();
		assertTrue(errors.get(0).equals("test error"));
	}

}
