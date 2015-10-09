package org.meltwater.java.dataStructures;

import java.util.*;

public class Set<E extends Comparable<E>> {
	private TreeSet<E> set;

    /**
     * Initialises an empty set.
     */
    public Set() {
        set = new TreeSet<E>();
    }

    /**
     * Adds the key to this set (if it is not already present).
     * @param  key the key to add
     * @throws NullPointerException if key is null
     */
    public void add(E key) {
        if (key == null) throw new NullPointerException("called add() with a null key");
        set.add(key);
    }
    
    /**
     * Returns true if this set contains the given key.
     * @param  key the key
     * @return true if this set contains key and
     *         false otherwise
     * @throws NullPointerException if key is null
     */
    public boolean contains(E key) {
        if (key == null) throw new NullPointerException("called contains() with a null key");
        return set.contains(key);
    }

    /**
     * Removes the key from this set (if the key is present).
     * @param  key the key
     * @throws NullPointerException if key is null
     */
    public void delete(E key) {
        if (key == null) throw new NullPointerException("called delete() with a null key");
        set.remove(key);
    }

    /**
     * Returns the number of keys in this set.
     * @return the number of keys in this set
     */
    public int size() {
        return set.size();
    }

    /**
     * Returns true if this set is empty.
     * @return true if this set is empty, and false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the largest key in this set.
     * @return the largest key in this set
     * @throws NoSuchElementException if this set is empty
     */
    public E max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty set");
        return set.last();
    }

    /**
     * Returns the smallest key in this set.
     * @return the smallest key in this set
     * @throws NoSuchElementException if this set is empty
     */
    public E min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty set");
        return set.first();
    }

    /**
     * toString()
     * This operation returns a nice string format
     */
    public String toString() {
		StringBuilder returnedString = new StringBuilder();
		for (int i = 0; i <= size() - 1; i++) {
			returnedString.append(set.get(i).toString() + ", ");
		}
		return returnedString.toString();

	}
}
