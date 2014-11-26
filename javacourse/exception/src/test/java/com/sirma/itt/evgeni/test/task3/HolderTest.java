package com.sirma.itt.evgeni.test.task3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.Holder;

/**
 * Add and remove objects.
 * @author Evgeni Stefanov
 *
 */
public class HolderTest {
	
	/**
	 * Check correct functioning when adding elements in full list.
	 */
	@Test
	public void addElementTest(){
		Holder holder = new Holder(2);
		assertTrue(holder.addElement("  "));
		assertTrue(holder.addElement("  "));
		assertFalse(holder.addElement(" "));
	}
	
	/**
	 * Check correct functioning when removing objects from empty list.
	 */
	@Test
	public void removeElementTest(){
		Holder holder = new Holder(2);
		holder.addElement(" ");
		assertTrue(holder.remove());
		assertFalse(holder.remove());
		
	}
}
