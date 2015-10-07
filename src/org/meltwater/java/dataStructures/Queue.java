package org.meltwater.java.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private int N;               // number of elements on queue
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /* Initialises an empty queue.*/
    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    /* Returns true if this queue is empty.*/
    public boolean isEmpty() {
        return first == null;
    }

    /* Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return N;     
    }

    /* Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
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
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
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
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}


    /**
     * Unit tests the <tt>Queue</tt> data type.
     */
//    public static void main(String[] args) {
//        Queue<String> q = new Queue<String>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            if (!item.equals("-")) q.enqueue(item);
//            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
//        }
//        StdOut.println("(" + q.size() + " left on queue)");
//    }
//}
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