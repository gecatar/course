package com.sirma.itt.evgeni.binarytree;

/**
 * Binary tree. Contain method for adding and searching values in binary tree.
 * 
 * @author Evgeni Stefanov
 */
public class Tree {

	Node node;

	public Tree(int number) {
		node = new Node(number);
	}
	
	public Node getNode(){
		return node;
	}
	
	/**
	 * Return all element in tree.
	 */
	public String toString(){
		return node.toString();
	}


	/**
	 * Search for numbers in tree.
	 * 
	 * @param num
	 *            searched number
	 * @return true if tree contain num
	 */
	public boolean searchNumber(int num) {
		Node temp = node;
		while (temp != null) {
			if (num < temp.number) {
				temp = temp.leftNode;
			} else if (num > temp.number) {
				temp = temp.rightNode;
			} else
				return true;
		}
		return false;
	}

	/**
	 * Add new number. Only if does not exist in tree.
	 * 
	 * @param num
	 */
	public void addNumber(int num) {
		Node temp = node;
		while (temp != null) {
			if (num < temp.number) {
				if (temp.leftNode == null) {
					temp.leftNode = new Node(num);
					temp = null;
				} else {
					temp = temp.leftNode;
				}
			} else if (num > temp.number) {
				if (temp.rightNode == null) {
					temp.rightNode = new Node(num);
					temp = null;
				} else {
					temp = temp.rightNode;
				}
			} else
				temp = null;
		}
	}
}
