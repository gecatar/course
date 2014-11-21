package com.sirma.itt.evgeni.heterogenius;

/**
 * @author Evgeni Stefanov
 * @param <D>
 */
public class Tree {

	public Tree(Object obj) {
		node = new Leaf(obj);
	}

	// define number of nodes
	private int count = 3;	
	//Starting point.
	private Leaf node;

	
	/**
	 * Search for element in tree.
	 * @param object that will looking for.
	 * @return
	 */
	public boolean contains(Object object){
		return node.contains(object);
	}

	/**
	 * Add element in tree if element is unique.
	 * @param dat will be added to tree
	 */
	public void addElement(Object object) {
		Leaf temp = node;
		if (!contains(object)) {
			while (temp != null) {
				if (temp.conections.size() < count) {
					temp.conections.add(new Leaf(object));
					temp = null;
				} else {
					temp = temp.conections.get(0);
				}
			}
		}
	}
	
	/**
	 * Print all element in tree.
	 * @param node Starting point.
	 */
	@Override
	public String toString(){
		return node.toString();
	}
}