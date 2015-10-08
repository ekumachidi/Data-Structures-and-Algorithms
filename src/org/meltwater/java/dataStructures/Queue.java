package org.meltwater.java.dataStructures;

import java.util.NoSuchElementException;

public class Queue<Item> {
    private int N;               // number of elements on queue
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    
    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initialises an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    /**
     * Returns true if this queue is empty. 
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue
     * @return
     */
    public int size() {
        return N;     
    }

    /**
     * Returns the item least recently added to this queue 
     * @return
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * Adds the item to this queue.
     * @param item
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    /**
     * Removes and returns the item on this queue
     * @return
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
//        for (Item item : this)
//            s.append(item + " ");
        return s.toString();
    } 
}








/*
interface Queue<T> {
    Queue<T> enqueue(T ele);
    T dequeue();
}

public class QueueArray<T> implements Queue<T> {
	private T[] arr;

    private int total, first, next;

    public QueueArray()
    {
        arr = (T[]) new Object[2];
    }

    private void resize(int capacity)
    {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < total; i++)
            tmp[i] = arr[(first + i) % arr.length];

        arr = tmp;
        first = 0;
        next = total;
    }

    public QueueArray<T> enqueue(T ele)
    {
        if (arr.length == total) resize(arr.length * 2);
        arr[next++] = ele;
        if (next == arr.length) next = 0;
        total++;
        return this;
    }

    public T dequeue()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = arr[first];
        arr[first] = null;
        if (++first == arr.length) first = 0;
        if (--total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return ele;
    }

    @Override
    public String toString()
    {
        return java.util.Arrays.toString(arr);
    }
}

*/