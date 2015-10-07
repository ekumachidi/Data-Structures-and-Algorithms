package org.meltwater.java.dataStructures;

public class Node {
	int data;
	Node left;
	Node right;	
	Node next;
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
