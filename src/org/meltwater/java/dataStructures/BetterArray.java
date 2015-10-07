package org.meltwater.java.dataStructures;

public class BetterArray<E> {//Array of Generic items of type E
//	BetterArray, an improved Java array that store an unlimited number of elements.
//	The operation takes constant amortised time
	 
	  private static final int DEFAULT_SIZE = 10;
	  private E[] array; //An array of E i.e Elements of type E
	  private int size = 0; //Number of elements
	  
//	  Initialise an empty BetterArray
	  public BetterArray() {
		    array = (E[]) new Object[DEFAULT_SIZE];
		  }
	  
//  insert(int position, E element) -> Inserts element at position.
	  
	  
//    shift(E element) -> Insert element at the start of the array, usually position 0.
	  private void resize(int capacity) {
	        assert capacity >= size;
	        E[] temp = (E[]) new Object[capacity];
	        for (int i = 0; i < size; i++)
	            temp[i] = array[i];
	        array = temp;
	    }
	  
//    append(E element) -> Append element to the end of the array.
	  public void add(E element) {
	        if (size == array.length) resize(2*array.length);    // double size of array if necessary
	        array[size++] = element;                            // add item
	    }
//    index(E element) -> Return the index of element in the array.
	  
//    contains(E element) -> Returns true if element is in array, false otherwise. Define contains in terms of index (See 4).
//    get(int index) -> Returns element at position index. If index is less than 0 or greater than maximum position occupied by an element, throw an appropriate exception.
	  public E get(int index){
		    if(index > size){throw new RuntimeException("Invalid index");}
		    E element = (E) array[index];
		    return element;
		}
	  
//    size() -> Returns the total number of elements in the array.
//	  size operation takes constant time
	  public int size() {
		return size;
	}
	  
//    isEmpty() -> Returns true if array has no elements, false otherwise.
//	  the isEmpty operation takes constant time
	  public boolean isEmpty() {
	        return size == 0;
	    }
	  
//    remove(int index) -> Delete element at position index.
	  public E remove(int index){
		    if(index>=size || index < 0 ){throw new RuntimeException("Invalid index");}
		    E element = (E) array[index];
		    --size;
		    System.arraycopy(array, index + 1, array, index, size - index);
		    array[size] = null;
		    return element;
		}
	  
//    remove(E element) -> Remove all occurrences of element from the array.
//    reverse() -> Reverses the array.
//    toString() -> Returns a nice String representation of the elements in the array.
	  public void dispString() {
//		for (int i = 0; i < array.length; ++i) {
//			String s = (String)s.get(i);
//			System.out.println(s);
//		}
	}
}
