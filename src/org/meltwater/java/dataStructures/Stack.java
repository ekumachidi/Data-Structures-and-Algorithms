package org.meltwater.java.dataStructures;

import java.util.*;

public class Stack<Item> implements Iterable<Item> {
    private int N;                // size of the stack
    private Node<Item> first;     // top of stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initialises an empty stack.    
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * Returns true if this stack is empty.
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * Adds the item to this stack.
     * @param item
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
       
    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}








/*package org.meltwater.java.dataStructures;

interface Stack<T> {
    Stack<T> push(T ele);
    T pop();
}

public class StackArray<T> implements Stack<T> {
	private T[] array;
	private int total;
	
	public StackArray() {
		array =(T[]) new Object[2];
	}	
	private void resize(int capacity)
    {
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, total);
        array = tmp;
    }

    public StackArray<T> push(T ele)
    {
        if (array.length == total) resize(array.length * 2);
        array[total++] = ele;
        return this;
    }

    public T pop()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = array[--total];
        array[total] = null;
        if (total > 0 && total == array.length / 4) resize(array.length / 2);
        return ele;
    }
    
    @Override
    public String toString()
    {
        return java.util.Arrays.toString(array);
    }
}
*/