package com.sirma.itt.evgeni.task5.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task5.Holder;

/**
 * Test adding and removing objects.
 * 
 * @author GecaTM
 *
 */
public class HolderTest {

	Holder holder;

	/**
	 * Test adding elements functioning.
	 */
	@Test
	public void addElementTest() {
		holder = new Holder(2);
		holder.addElement("test1");
		holder.addElement("test2");
		assertEquals("element:test1\nelement:test2", holder.toString());
	}

	/**
	 * Test correct removing on objects.
	 */
	@Test
	public void removeElementTest() {
		holder = new Holder(2);
		holder.addElement("test1");
		holder.addElement("test2");
		holder.remove();
		assertEquals("element:test1", holder.toString());
	}

}
