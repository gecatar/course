package com.sirma.itt.evgeni.homogenius;

public class TreeRunner {

	/**
	 * Initialize new tree and make some searches.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Adding elements to tree!!");
		Data data = new Data("qwerty");
		Data data2 = new Data("asdfg");
		Data data3 = new Data("zxcvbn");		
		Tree<Data> tree = new Tree<Data>(data);
		tree.addElement(data3);
		tree.addElement(data2);
		tree.addElement(new Data("123456"));
		tree.addElement(new Data("123457"));
		tree.addElement(new Data("123458"));
		System.out.println("Print all element in tree.");
		System.out.println(tree);
		System.out.println("Search for values in tree!");
		System.out.println("Search for:"+data2.toString());
		if(tree.contains(data2)){
			System.out.println("Contain this value!");
		}
		System.out.println("Search for:"+data3.toString());
		if(tree.contains(data3)){
			System.out.println("Contain this value!");
		}
		System.out.println("Search for:"+data2.toString());
		if(tree.contains(data2)){
			System.out.println("Contain this value!");
		}
		System.out.println("Search for:"+data2.toString());
		if(tree.contains(data2)){
			System.out.println("Contain this value!");
		}
		System.out.println("Search for:"+data2.toString());
		if(tree.contains(data2)){
			System.out.println("Contain this value!");
		}
		
		
	}

}