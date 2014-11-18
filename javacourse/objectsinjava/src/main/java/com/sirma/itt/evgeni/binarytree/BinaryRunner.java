package com.sirma.itt.evgeni.binarytree;

/**
 * Create binary tree. Store numbers. 
 * List elements in sorted way.
 * @author Evgeni Stefanov
 *
 */
public class BinaryRunner {

	/**
	 * Initialize tree add elements and print in sorted way.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Tree tree = new Tree(6);
		tree.addNumber(3);
		tree.addNumber(9);
		tree.addNumber(1);
		tree.addNumber(7);
		tree.addNumber(10);
		tree.addNumber(12);
		tree.addNumber(15);
		tree.addNumber(76);
		
		System.out.println(tree);
		
	}

}
