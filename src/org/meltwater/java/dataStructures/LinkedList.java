package org.meltwater.java.dataStructures;

public class LinkedList {
	public Node head;
	public int size;
	
	public LinkedList() {
		head = null;
	}
	//    add(int position, E element) -> Inserts element at position.
	public void addAtIndex(int data, int position){
		if(position == 1){
			addAtBegin(data);
		}
		int len = size;
		if (position>len+1 || position <1){
			System.out.println("\nINVALID POSITION");
		}
		if(position==len+1){
			addAtEnd(data);
		}
		if(position<=len && position >1){
			Node n = new Node(data);
			Node currNode = head; //so index is already 1
			while((position-2)>0){
				System.out.println(currNode.data);
				currNode=currNode.next;
				position--;
			}
			n.next = currNode.next;
			currNode.next = n;
			size++;
		}
	}
	
//    insertBefore(E elem1, E elem2) -> Insert elem2 before elem1.
	public void addAtBegin(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
		size++;
	}
	
//    insertAfter(E elem1, E elem2) -> Insert elem2 after elem1.
	public void addAtEnd(int data) {
		if (head == null) {
			addAtBegin(data);
		} else {
			Node n = new Node(data);
			Node currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = n;
			size++;
		}
	}
	
//    size() -> Returns the total number of nodes in the list.
	public int getSize(){
		return size;
	}
	
//    contains(E element) -> Returns true if element is in the list, false otherwise.
	public int contains(int data){
		Node n = head;
		int count = 1;
		while(n!=null){
			if(n.data==data){
				return count;
			}else{
				n = n.next;
				count++;
			}
		}
		return -1;
	}
	
//    head() -> Returns the first node in the list.
//    tail() -> Returns the last node in the list.
//    remove(E element) -> Removes element from the list.

	public int deleteAtBegin() {
		int tmp = head.data;
		head = head.next;
		size--;
		return tmp;
	}
	
	public void deleteAtEnd() {
		Node currNode = head;
		if (head.next == null) {
			head = null;
		} else {
			while (currNode.next.next != null) {
				currNode = currNode.next;
			}
			int temp = currNode.next.data;
			currNode.next = null;
			size--;
		}
	}
	
//    isEmpty() -> Returns true if the list has no elements, false otherwise.
//    reverse() -> Reverses the array.
//    toString() -> Returns a nice String representation of the nodes in the list.
	public void display() {
		System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

}
