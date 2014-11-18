package com.sirma.itt.evgeni.binarytree.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.binarytree.Tree;

/**
 * Test functionality of binary tree structure.
 * @author Evgeni Stefanov
 *
 */
public class BinaryTreeTest {

	/**
	 * Add several numbers and check order on printed string.
	 */
	@Test
	public void firstTest() {
		
		Tree tree = new Tree(6);
		tree.addNumber(3);
		tree.addNumber(9);
		tree.addNumber(1);
		tree.addNumber(7);
		tree.addNumber(10);
		tree.addNumber(12);
		tree.addNumber(15);
		tree.addNumber(76);
		
		String expectedString = " 1  3  6  7  9  10  12  15  76 ";
		String actualString = tree.toString();
		
		assertEquals(expectedString, actualString);
	}
	
	@Test
	public void secondTest(){
		
		Tree tree = new Tree(6);
		tree.addNumber(3);
		tree.addNumber(7);
		tree.addNumber(1);
		tree.addNumber(15);
		tree.addNumber(10);
		tree.addNumber(12);
		tree.addNumber(33);
		tree.addNumber(20);
		String expectedString = " 1  3  6  7  10  12  15  20  33 ";
		String actualString = tree.toString();
		assertEquals(expectedString, actualString);
	}

}
